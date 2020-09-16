using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetTotalCostInWeekCommand : ICommand
    {
        private HashSet<Order> orders;
        private Date date;
        private OrderHandler orderHandler;

        public GetTotalCostInWeekCommand(HashSet<Order> orders, Date date)
        {
            this.orders = orders;
            this.date = date;
            orderHandler = new OrderHandler();
        }

        public async Task<object> Execute()
        {
            return await orderHandler.GetTotalCostInWeek(orders, date);
        }
    }
}