using System;
using System.Collections.Concurrent;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;

namespace WPFDataParallelismProj.CommandsFactory
{
    class CommandFactory
    {
        public const int SET_FOLDER_PATH = 1;
        public const int LOAD_DATA = 2;
        public const int GET_SUPPLIERS = 3;
        public const int GET_STORES = 4;
        public const int GET_SUPPLIER_TYPES = 5;
        public const int GET_DATES = 6;
        public const int GET_TOTAL_COST_ALL_ORDERS = 7;
        public const int GET_TOTAL_COST_FOR_STORE = 8;
        public const int GET_TOTAL_COST_IN_WEEK = 9;
        public const int GET_TOTAL_COST_IN_WEEK_FOR_STORE = 10;
        public const int GET_TOTAL_COST_FOR_SUPPLIER = 11;
        public const int GET_TOTAL_COST_FOR_SUPPLIER_TYPE = 12;
        public const int GET_TOTAL_COST_IN_WEEK_FOR_SUPPLIER_TYPE = 13;
        public const int GET_TOTAL_COST_FOR_SUPPLIER_TYPE_FOR_STORE = 14;
        public const int GET_TOTAL_COST_IN_WEEK_FOR_SUPPLIER_TYPE_FOR_STORE = 15;
        public static ICommand CreateCommand(int commandType, Action<int, int> callback)
        {
            switch (commandType)
            {
                case LOAD_DATA:
                    return new LoadDataCommand(callback);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders)
        {
            switch (commandType)
            {
                case GET_STORES:
                    return new GetStoresCommand(orders);
                case GET_SUPPLIERS:
                    return new GetSuppliersCommand(orders);
                case GET_SUPPLIER_TYPES:
                    return new GetSupplierTypesCommand(orders);
                case GET_DATES:
                    return new GetDatesCommand(orders);
                case GET_TOTAL_COST_ALL_ORDERS:
                    return new GetTotalCostAllOrdersCommand(orders);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders, Store store)
        {
            switch (commandType)
            {
                case GET_TOTAL_COST_FOR_STORE:
                    return new GetTotalCostForStoreCommand(orders, store);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders, Date date)
        {
            switch (commandType)
            {
                case GET_TOTAL_COST_IN_WEEK:
                    return new GetTotalCostInWeekCommand(orders, date);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders, Date date, string supplierType)
        {
            switch (commandType)
            {
                case GET_TOTAL_COST_IN_WEEK_FOR_SUPPLIER_TYPE:
                    return new GetTotalCostInWeekForSupplierTypeCommand(orders, date, supplierType);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders, Store store, string supplierType)
        {
            switch (commandType)
            {
                case GET_TOTAL_COST_FOR_SUPPLIER_TYPE_FOR_STORE:
                    return new GetTotalCostForSupplierTypeForStoreCommand(orders, store, supplierType);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders, Date date, Store store, string supplierType)
        {
            switch (commandType)
            {
                case GET_TOTAL_COST_IN_WEEK_FOR_SUPPLIER_TYPE_FOR_STORE:
                    return new GetTotalCostInWeekForSupplierTypeForStoreCommand(orders, date, store, supplierType);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders, string sup)
        {
            switch (commandType)
            {
                case GET_TOTAL_COST_FOR_SUPPLIER:
                    return new GetTotalCostForSupplierCommand(orders, sup);
                case GET_TOTAL_COST_FOR_SUPPLIER_TYPE:
                    return new GetTotalCostForSupplierTypeCommand(orders, sup);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, HashSet<Order> orders, Date date, Store store)
        {
            switch (commandType)
            {
                case GET_TOTAL_COST_IN_WEEK_FOR_STORE:
                    return new GetTotalCostInWeekForStoreCommand(orders, date, store);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, string selectedFolderPath)
        {
            switch (commandType)
            {
                case SET_FOLDER_PATH:
                    return new SetFolderPathCommand(selectedFolderPath);
                default:
                    return new NullObjectCommand();
            }
        }
    }
}
