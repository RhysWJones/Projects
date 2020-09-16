using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.DTO
{
    class Supplier
    {
        public String SupplierName { get; set; }
        public String SupplierType { get; set; }

        public Supplier()
            : this("", "")
        {

        }

        public Supplier(String supplierName, String supplierType)
        {
            this.SupplierName = supplierName;
            this.SupplierType = supplierType;
        }
    }
}
