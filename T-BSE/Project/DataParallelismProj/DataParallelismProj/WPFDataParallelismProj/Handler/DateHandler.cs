using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;

namespace WPFDataParallelismProj.Handler
{
    class DateHandler
    {
        public async Task<Date[]> GetDates(HashSet<Order> orders)
        {
            Date[] dates = new Date[0];
            await Task.Run(() =>
            {
                dates = orders.GroupBy(order => order.Date)
                    .Select(order => order.Key).ToArray();
            });
            return dates;
        }
    }
}
