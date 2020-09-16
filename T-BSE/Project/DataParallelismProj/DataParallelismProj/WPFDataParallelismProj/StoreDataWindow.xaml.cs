using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms.DataVisualization.Charting;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Windows.Threading;
using WPFDataParallelismProj.CommandsFactory;
using WPFDataParallelismProj.DTO;

namespace WPFDataParallelismProj
{
    /// <summary>
    /// Interaction logic for StoreDataWindow.xaml
    /// </summary>
    public partial class StoreDataWindow : Window
    {
        //Folder Path Window instance, for getting the folder path.
        private FolderPathWindow FPW;

        //Collections of objects.
        private HashSet<Order> orders = new HashSet<Order>();

        public StoreDataWindow()
        {
            FPW = new FolderPathWindow();

            InitializeComponent();

            WindowState = WindowState.Maximized;

            FPW.ShowDialog();

            Task.Run(async () =>
            {
                bool setupComplete = (bool)(await (CommandFactory.CreateCommand(CommandFactory.SET_FOLDER_PATH, FPW.SelectedPath).Execute()));
            });
        }

        private void Load_Data_Button_Click(object sender, RoutedEventArgs e)
        {
            //Empty the collections and garbage collect to avoid cached data reaching 3gb.
            orders = null;
            GC.Collect();

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            Task t1 = new Task(async () =>
            {
                orders = (HashSet<Order>)(await (CommandFactory.CreateCommand(CommandFactory.LOAD_DATA, LoadProgress).Execute()));

                Store[] stores = (Store[])(await (CommandFactory.CreateCommand(CommandFactory.GET_STORES, orders).Execute()));

                Date[] dates = (Date[])(await (CommandFactory.CreateCommand(CommandFactory.GET_DATES, orders).Execute()));
                Array.Sort(dates);

                String[] suppliers = (String[])(await (CommandFactory.CreateCommand(CommandFactory.GET_SUPPLIERS, orders).Execute()));

                String[] supplierTypes = (String[])(await (CommandFactory.CreateCommand(CommandFactory.GET_SUPPLIER_TYPES, orders).Execute()));

                Dictionary<string, double> supplierOrderChartData = new Dictionary<string, double>();

                foreach(string supplier in suppliers)
                {
                    double totalCostForSupplier = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_FOR_SUPPLIER, orders, supplier).Execute()));
                    supplierOrderChartData.Add(supplier, totalCostForSupplier);
                }


                await Dispatcher.BeginInvoke((Action)(() =>
                {
                    stopWatch.Stop();

                    Chart chart = FindName("Chart") as Chart;
                    //chart.ChartAreas[0].AxisX.LabelStyle.Angle = -90;
                    chart.ChartAreas[0].AxisX.LabelStyle.Interval = 1;
                    chart.ChartAreas[0].AxisY.LabelStyle.Format = "£{000,0}";
                    chart.ChartAreas[0].AxisY.LabelStyle.Interval = 250000;
                    chart.DataSource = supplierOrderChartData;
                    chart.Series["series"].XValueMember = "Key";
                    chart.Series["series"].YValueMembers = "Value";

                    if (orders.Count > 0)
                    {
                        TimeToLoad.Text = "TimeToLoad: " + stopWatch.Elapsed.TotalSeconds;
                        DateBox.ItemsSource = dates;
                        StoreListView.ItemsSource = stores;
                        SupplierListView.ItemsSource = suppliers;
                        SupplierTypeListView.ItemsSource = supplierTypes;
                    }
                }));
                GC.Collect();
            });

            t1.Start();

            Load_Data_Button.Header = "Reload Data";
        }

        private void Total_Cost_Of_All_Orders_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCost = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_ALL_ORDERS, orders).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TotalPrice.Text = ("Total cost of all orders: " + totalCost.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_For_Store_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + StoreListView.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            Store selectedStore = (Store)StoreListView.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostForStore = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_FOR_STORE, orders, selectedStore).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {

                        TotalPrice.Text = ("Total cost for store: " + totalCostForStore.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_In_Week_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + DateBox.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            Date selectedDate = (Date)DateBox.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostForWeek = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_IN_WEEK, orders, selectedDate).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {

                        TotalPrice.Text = ("Total cost in week: " + totalCostForWeek.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_In_Week_For_Store_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + StoreListView.SelectedItem + " on " + DateBox.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            Date selectedDate = (Date)DateBox.SelectedItem;
            Store selectedStore = (Store)StoreListView.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostForStoreForWeek = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_IN_WEEK_FOR_STORE, orders, selectedDate, selectedStore).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TotalPrice.Text = ("Total cost in week for store: " + totalCostForStoreForWeek.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_For_Supplier_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + SupplierListView.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            string selectedSupplier = (string)SupplierListView.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostForSupplier = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_FOR_SUPPLIER, orders, selectedSupplier).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TotalPrice.Text = ("Total cost for supplier: " + totalCostForSupplier.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_For_SupplierType_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + SupplierTypeListView.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            string selectedSupplierType = (string)SupplierTypeListView.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostForSupplierType = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_FOR_SUPPLIER_TYPE, orders, selectedSupplierType).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TotalPrice.Text = ("Total cost for supplier type: " + totalCostForSupplierType.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_In_Week_For_SupplierType_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + SupplierTypeListView.SelectedItem + " on " + DateBox.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            string selectedSupplierType = (string)SupplierTypeListView.SelectedItem;
            Date selectedDate = (Date)DateBox.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostInWeekForSupplierType = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_IN_WEEK_FOR_SUPPLIER_TYPE, orders, selectedDate, selectedSupplierType).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TotalPrice.Text = ("Total cost in week for supplier type: " + totalCostInWeekForSupplierType.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_For_SupplierType_For_Store_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + SupplierTypeListView.SelectedItem + " at " + StoreListView.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            string selectedSupplierType = (string)SupplierTypeListView.SelectedItem;
            Store selectedStore = (Store)StoreListView.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostForSupplierTypeAtStore = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_FOR_SUPPLIER_TYPE_FOR_STORE, orders, selectedStore, selectedSupplierType).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TotalPrice.Text = ("Total cost for supplier type for store: " + totalCostForSupplierTypeAtStore.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private void Total_Cost_In_Week_For_SupplierType_For_Store_Button_Click(object sender, RoutedEventArgs e)
        {
            TimeToLoad.Text = ("Calculating total for " + SupplierTypeListView.SelectedItem + " at " + StoreListView.SelectedItem + " on " + DateBox.SelectedItem + "...");

            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            string selectedSupplierType = (string)SupplierTypeListView.SelectedItem;
            Store selectedStore = (Store)StoreListView.SelectedItem;
            Date selectedDate = (Date)DateBox.SelectedItem;

            Task t1 = new Task(async () =>
            {
                if (orders.Count > 0)
                {
                    double totalCostInWeekForSupplierTypeAtStore = (double)(await (CommandFactory.CreateCommand(CommandFactory.GET_TOTAL_COST_IN_WEEK_FOR_SUPPLIER_TYPE_FOR_STORE, orders, selectedDate, selectedStore, selectedSupplierType).Execute()));

                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TotalPrice.Text = ("Total cost in week for supplier type for store: " + totalCostInWeekForSupplierTypeAtStore.ToString("C", CultureInfo.CurrentCulture));

                        stopWatch.Stop();
                        TimeToLoad.Text = ("Time to load: " + stopWatch.Elapsed.TotalSeconds);
                    }), DispatcherPriority.Background);
                }

                else
                {
                    await Dispatcher.BeginInvoke((Action)(() =>
                    {
                        TimeToLoad.Text = ("\nData not loaded.");

                    }), DispatcherPriority.Background);
                }
                GC.Collect();
            });
            t1.Start();
        }

        private async void LoadProgress(int currentlyLoaded, int totalToLoad)
        {
            await Dispatcher.BeginInvoke(new Action(() =>
            {
                PBText.Text = "Loaded: " + currentlyLoaded + "/" + totalToLoad;
                Loading_Bar.Maximum = totalToLoad;
                Loading_Bar.Value = currentlyLoaded;
            }));
        }
    }
}
