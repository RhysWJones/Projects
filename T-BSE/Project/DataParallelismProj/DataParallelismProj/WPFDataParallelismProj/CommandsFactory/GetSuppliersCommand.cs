using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetSuppliersCommand : ICommand
    {
        private HashSet<Order> orders;
        private SupplierHandler supplierHandler;

        public GetSuppliersCommand(HashSet<Order> orders)
        {
            this.orders = orders;
            supplierHandler = new SupplierHandler();
        }

        public async Task<object> Execute()
        {
            return await supplierHandler.GetSuppliers(orders);
        }
    }
}