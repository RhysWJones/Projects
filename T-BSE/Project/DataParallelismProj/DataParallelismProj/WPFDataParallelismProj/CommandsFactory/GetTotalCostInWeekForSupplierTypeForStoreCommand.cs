using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostInWeekForSupplierTypeForStoreCommand : ICommand
    {
        private HashSet<Order> orders;
        private Date date;
        private Store store;
        private string supplierType;
        private OrderHandler orderHandler;

        public GetTotalCostInWeekForSupplierTypeForStoreCommand(HashSet<Order> orders, Date date, Store store, string supplierType)
        {
            this.orders = orders;
            this.date = date;
            this.store = store;
            this.supplierType = supplierType;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostInWeekForSupplierTypeForStore(orders, date, store, supplierType);
        }
    }
}