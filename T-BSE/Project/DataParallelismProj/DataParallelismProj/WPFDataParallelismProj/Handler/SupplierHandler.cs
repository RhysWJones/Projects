using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;

namespace WPFDataParallelismProj.Handler
{
    class SupplierHandler
    {
        public async Task<String[]> GetSuppliers(HashSet<Order> orders)
        {
            String[] suppliers = new String[0];
            await Task.Run(() =>
            {
                suppliers = orders.GroupBy(order => order.Supplier.SupplierName)
                    .Select(order => order.Key).ToArray();
            });
            return suppliers;
        }

        public async Task<String[]> GetSupplierTypes(HashSet<Order> orders)
        {
            String[] supplierTypes = new String[0];
            await Task.Run(() =>
            {
                supplierTypes = orders.GroupBy(order => order.Supplier.SupplierType)
                .Select(order => order.Key).ToArray();
            });
            return supplierTypes;
        }
    }
}
