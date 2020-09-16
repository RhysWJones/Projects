using WPFDataParallelismProj.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Concurrent;

namespace WPFDataParallelismProj.Handler
{
    class StoreHandler
    {
        public async Task<Store[]> GetStores(HashSet<Order> orders)
        {
            Store[] stores = new Store[0];
            await Task.Run(() =>
            {
                stores = orders.GroupBy(order => order.Store)
                    .Select(order => order.Key).ToArray();
            });
            return stores;
        }
    }
}
