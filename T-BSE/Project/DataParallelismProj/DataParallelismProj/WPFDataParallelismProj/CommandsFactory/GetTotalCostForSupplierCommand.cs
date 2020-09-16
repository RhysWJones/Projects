using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostForSupplierCommand : ICommand
    {
        private HashSet<Order> orders;
        private string supplier;
        private OrderHandler orderHandler;

        public GetTotalCostForSupplierCommand(HashSet<Order> orders, string supplier)
        {
            this.orders = orders;
            this.supplier = supplier;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostForSupplier(orders, supplier);
        }
    }
}