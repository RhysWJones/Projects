using DataParallelismProj.DTO;
using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.Handler
{
    class FileHandler
    {
        string folderPath = "StoreData";
        string storeCodesFile = "StoreCodes.csv";
        string storeDataFolder = "StoreData";

        public Boolean LoadOrders(string selectedFolderPath)
        {
           ConcurrentDictionary<string, Store> stores = LoadStores();

            ConcurrentDictionary<string, Date> dates = new ConcurrentDictionary<string, Date>();
            List<Order> orders = new List<Order>();

            string[] fileNames = Directory.GetFiles(folderPath + @"\" + storeDataFolder);

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

                //fileNameSplit[0] = store code
                //fileNameSplit[1] = week number
                //fileNameSplit[2] = year

                string[] orderData = File.ReadAllLines(folderPath + @"\" + storeDataFolder + @"\" + fileNameExt);

                foreach (string entry in orderData)
                {
                    string[] orderSplit = entry.Split(',');

                    Order order = new Order(store, date, new Supplier(orderSplit[0], orderSplit[1]), Convert.ToDouble(orderSplit[2]));
                    order.Date = date;

                    lock(orders)
                    {
                        orders.Add(order);
                    }
                    
                    //orderSplit[0] = supplier name
                    //orderSplit[1] = supplier type
                    //orderSplit[2] = cost
                }

            });

            return true;
        }

        public ConcurrentDictionary<string, Store> LoadStores()
        {
            ConcurrentDictionary<string, Store> stores = new ConcurrentDictionary<string, Store>();

            string storeCodesFilePath = Directory.GetCurrentDirectory() + @"\" + folderPath + @"\" + storeCodesFile;
            string[] storeCodesData = File.ReadAllLines(storeCodesFilePath);

            Parallel.ForEach(storeCodesData, storeData =>
           {
               string[] storeDataSplit = storeData.Split(',');
               Store store = new Store { StoreCode = storeDataSplit[0], StoreName = storeDataSplit[1] };

               if (!stores.ContainsKey(store.StoreCode))
                   stores.TryAdd(store.StoreCode, store);

                //storeDataSplit[0] = store code
                //storeDataSplit[1] = store location
            });

            return stores;
        }
    }
}
