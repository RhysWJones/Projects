using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostForStoreCommand : ICommand
    {
        private HashSet<Order> orders;
        private OrderHandler orderHandler;
        private Store store;

        public GetTotalCostForStoreCommand(HashSet<Order> orders, Store store)
        {
            this.orders = orders;
            this.store = store;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostForStore(orders, store);
        }
    }
}