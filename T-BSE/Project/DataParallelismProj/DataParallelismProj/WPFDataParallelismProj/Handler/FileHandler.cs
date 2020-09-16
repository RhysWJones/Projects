using WPFDataParallelismProj.DTO;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPFDataParallelismProj.Handler
{
    class FileHandler
    {
        private string folderPath = "StoreData";
        private string storeCodesFile = "StoreCodes.csv";
        private string storeDataFolder = "StoreData";

        private static FileHandler instance;

        private FileHandler()
        {
        }

        public static FileHandler GetInstance()
        {
            if (instance == null)
            {
                instance = new FileHandler();
            }

            return instance;
        }

        public async Task<bool> SetFolderPath(string selectedFolderPath)
        {
            await Task.Run(() =>
            {
                folderPath = selectedFolderPath;
            });
            return true;
        }

        public async Task<HashSet<Order>> LoadOrders(Action<int, int> callback)
        {
            ConcurrentDictionary<string, Store> stores = await LoadStores(callback);

            ConcurrentDictionary<string, Date> dates = new ConcurrentDictionary<string, Date>();
            HashSet<Order> orders = new HashSet<Order>();

            string[] fileNames = Directory.GetFiles(folderPath + @"\" + storeDataFolder);

            int orderFilesRead = 0;

            await Task.Run(() =>
            {
                //foreach(string filePath in fileNames)
                Parallel.ForEach(fileNames, filePath =>
                {
                    //Full file name with the extension (#####.csv)
                    string fileNameExt = Path.GetFileName(filePath);
                    //File name without extension
                    string fileName = Path.GetFileNameWithoutExtension(filePath);

                    //Split the filename up into store code, week and year
                    string[] fileNameSplit = fileName.Split('_');

                    //Gets the store object with the matching store code.
                    Store store = stores[fileNameSplit[0]];

                    //Create Date object from week and year.
                    Date date = new Date { Week = Convert.ToInt32(fileNameSplit[1]), Year = Convert.ToInt32(fileNameSplit[2]) };

                    if (!dates.ContainsKey(date.ToString()))
                    {
                        dates.TryAdd(date.ToString(), date);
                    }

                    string[] orderData = File.ReadAllLines(folderPath + @"\" + storeDataFolder + @"\" + fileNameExt);

                    foreach (string entry in orderData)
                    {
                        string[] orderSplit = entry.Split(',');

                        Order order = new Order(store, dates[date.ToString()], new Supplier(orderSplit[0], orderSplit[1]), Convert.ToDouble(orderSplit[2]));

                        lock (orders)
                        {
                            orders.Add(order);
                        }
                    }
                    orderFilesRead++;
                    callback(orderFilesRead, fileNames.Length);
                });
            });

            return orders;
        }

        public async Task<ConcurrentDictionary<string, Store>> LoadStores(Action<int, int> callback)
        {
            ConcurrentDictionary<string, Store> stores = new ConcurrentDictionary<string, Store>();

            string storeCodesFilePath = folderPath + @"\" + storeCodesFile;
            string[] storeCodesData = File.ReadAllLines(storeCodesFilePath);

            int storeFilesRead = 0;

            await Task.Run(() =>
            {
                Parallel.ForEach(storeCodesData, storeData =>
                {
                    string[] storeDataSplit = storeData.Split(',');
                    Store store = new Store { StoreCode = storeDataSplit[0], StoreName = storeDataSplit[1] };

                    if (!stores.ContainsKey(store.StoreCode))
                    {
                        stores.TryAdd(store.StoreCode, store);
                        storeFilesRead++;
                        callback(storeFilesRead, storeCodesData.Length);
                    }
                });
            });
            return stores;
        }
    }
}
