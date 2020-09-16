using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    internal class GetDatesCommand : ICommand
    {
        private HashSet<Order> orders;
        private DateHandler dateHandler;

        public GetDatesCommand(HashSet<Order> orders)
        {
            this.orders = orders;
            dateHandler = new DateHandler();
        }

        public async Task<object> Execute()
        {
            return await dateHandler.GetDates(orders);
        }
    }
}