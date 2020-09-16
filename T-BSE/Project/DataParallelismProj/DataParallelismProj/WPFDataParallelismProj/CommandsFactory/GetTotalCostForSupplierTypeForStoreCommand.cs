using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostForSupplierTypeForStoreCommand : ICommand
    {
        private HashSet<Order> orders;
        private Store store;
        private string supplierType;
        private OrderHandler orderHandler;

        public GetTotalCostForSupplierTypeForStoreCommand(HashSet<Order> orders, Store store, string supplierType)
        {
            this.orders = orders;
            this.store = store;
            this.supplierType = supplierType;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostForSupplierTypeForStore(orders, store, supplierType);
        }
    }
}