using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostForSupplierTypeCommand : ICommand
    {
        private HashSet<Order> orders;
        private string supplierType;
        private OrderHandler orderHandler;

        public GetTotalCostForSupplierTypeCommand(HashSet<Order> orders, string supplierType)
        {
            this.orders = orders;
            this.supplierType = supplierType;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostForSupplierType(orders, supplierType);
        }
    }
}