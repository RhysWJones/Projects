using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostInWeekForStoreCommand : ICommand
    {
        private HashSet<Order> orders;
        private Date date;
        private Store store;
        private OrderHandler orderHandler;

        public GetTotalCostInWeekForStoreCommand(HashSet<Order> orders, Date date, Store store)
        {
            this.orders = orders;
            this.date = date;
            this.store = store;
            orderHandler = new OrderHandler();
        }

        public Task<object> Execute()
        {
            return orderHandler.GetTotalCostInWeekForStore(orders, date, store);
        }
    }
}