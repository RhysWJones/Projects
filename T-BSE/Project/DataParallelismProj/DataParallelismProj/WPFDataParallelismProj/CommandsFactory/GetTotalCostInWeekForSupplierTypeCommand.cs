using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostInWeekForSupplierTypeCommand : ICommand
    {
        private HashSet<Order> orders;
        private Date date;
        private string supplierType;
        private OrderHandler orderHandler;

        public GetTotalCostInWeekForSupplierTypeCommand(HashSet<Order> orders, Date date, string supplierType)
        {
            this.orders = orders;
            this.date = date;
            this.supplierType = supplierType;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostInWeekForSupplierType(orders, date, supplierType);
        }
    }
}