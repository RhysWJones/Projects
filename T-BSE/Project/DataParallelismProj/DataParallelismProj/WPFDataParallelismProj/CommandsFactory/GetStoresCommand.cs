using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetStoresCommand : ICommand
    {
        private StoreHandler storeHandler;
        private HashSet<Order> orders;

        public GetStoresCommand(HashSet<Order> orders)
        {
            this.orders = orders;
            storeHandler = new StoreHandler();
        }
        public async Task<object> Execute()
        {
            return await storeHandler.GetStores(orders);
        }
    }
}
