using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostAllOrdersCommand : ICommand
    {
        private HashSet<Order> orders;
        private OrderHandler orderHandler;

        public GetTotalCostAllOrdersCommand(HashSet<Order> orders)
        {
            this.orders = orders;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostAllOrders(orders);
        }
    }
}