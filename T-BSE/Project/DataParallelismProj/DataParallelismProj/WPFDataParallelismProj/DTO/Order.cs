using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPFDataParallelismProj.DTO
{
    class Order
    {
        public Store Store { get; set; }
        public Supplier Supplier { get; set; }
        public double Price { get; set; }

        public Date Date { get; set; }

        public Order()
            : this(new Store(), new Date(), new Supplier(), 0.0)
        {

        }

        public Order(Store store, Date date, Supplier supplier, double price)
        {
            Store = store;
            Supplier = supplier;
            Price = price;
            Date = date;
        }
    }
}
