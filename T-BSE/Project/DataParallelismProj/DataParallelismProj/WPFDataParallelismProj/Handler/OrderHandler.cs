using WPFDataParallelismProj.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Concurrent;
using System.Threading;

namespace WPFDataParallelismProj.Handler
{
    class OrderHandler
    {
        public async Task<object> GetTotalCostAllOrders(HashSet<Order> orders)
        {
            double totalCost = 0;
            await Task.Run(() =>
            {
                //var priceArray = from o in orders select o.Price;
                totalCost = orders.Sum(o => o.Price);
            });
            return totalCost;
        }

        public async Task<object> GetTotalCostForStore(HashSet<Order> orders, Store store)
        {
            //HashSet<Order> storeOrders = (HashSet<Order>) from o in orders where o.Store.Equals(store) select o;
            double totalCostforStore = 0;

            await Task.Run(() =>
            {
                totalCostforStore = orders.Where(o => o.Store.Equals(store)).Sum(o => o.Price);
            });

            return totalCostforStore;
        }

        public async Task<object> GetTotalCostInWeekForSupplierTypeForStore(HashSet<Order> orders, Date date, Store store, string supplierType)
        {
            double totalCostInWeekForSupplierTypeForStore = 0;

            await Task.Run(() =>
            {
                totalCostInWeekForSupplierTypeForStore = orders.Where(o => o.Supplier.SupplierType.Equals(supplierType)
                && o.Store.Equals(store) && o.Date.Equals(date)).Sum(o => o.Price);
            });

            return totalCostInWeekForSupplierTypeForStore;
        }

        public async Task<object> GetTotalCostForSupplierTypeForStore(HashSet<Order> orders, Store store, string supplierType)
        {
            double totalCostForSupplierTypeForStore = 0;

            await Task.Run(() =>
            {
                totalCostForSupplierTypeForStore = orders.Where(o => o.Supplier.SupplierType.Equals(supplierType)
                && o.Store.Equals(store)).Sum(o => o.Price);
            });

            return totalCostForSupplierTypeForStore;
        }

        public async Task<object> GetTotalCostInWeekForSupplierType(HashSet<Order> orders, Date date, string supplierType)
        {
            double totalCostInWeekForSupplierType = 0;

            await Task.Run(() =>
            {
                totalCostInWeekForSupplierType = orders.Where(o => o.Supplier.SupplierType.Equals(supplierType) 
                && o.Date.Equals(date)).Sum(o => o.Price);
            });

            return totalCostInWeekForSupplierType;
        }

        public async Task<object> GetTotalCostForSupplierType(HashSet<Order> orders, string supplierType)
        {
            double totalCostForSupplierType = 0;

            await Task.Run(() =>
            {
                totalCostForSupplierType = orders.Where(o => o.Supplier.SupplierType.Equals(supplierType)).Sum(o => o.Price);
            });

            return totalCostForSupplierType;
        }

        public async Task<object> GetTotalCostForSupplier(HashSet<Order> orders, string supplier)
        {
            double totalCostForSupplier = 0;

            await Task.Run(() =>
            {
                totalCostForSupplier = orders.Where(o => o.Supplier.SupplierName.Equals(supplier)).Sum(o => o.Price);
            });

            return totalCostForSupplier;
        }

        public async Task<object> GetTotalCostInWeekForStore(HashSet<Order> orders, Date date, Store store)
        {
            double totalCostInWeekForStore = 0;

            await Task.Run(() =>
            {
                totalCostInWeekForStore = orders.Where(o => o.Date.Equals(date) 
                && o.Store.Equals(store)).Sum(o => o.Price);
            });

            return totalCostInWeekForStore;
        }

        public async Task<object> GetTotalCostInWeek(HashSet<Order> orders, Date date)
        {
            double totalCostForWeek = 0;

            await Task.Run(() =>
            {
                totalCostForWeek = orders.Where(o => o.Date.Equals(date)).Sum(o => o.Price);
            });

            return totalCostForWeek;
        }
    }
}
