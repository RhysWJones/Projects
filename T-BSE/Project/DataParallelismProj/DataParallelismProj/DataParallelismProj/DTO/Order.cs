using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.DTO
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
            this.Store = store;
            this.Supplier = supplier;
            this.Price = price;
        }
    }
}
