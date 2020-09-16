using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using WPFDataParallelismProj.DTO;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class GetSupplierTypesCommand : ICommand
    {
        private HashSet<Order> orders;
        private SupplierHandler supplierHandler;

        public GetSupplierTypesCommand(HashSet<Order> orders)
        {
            this.orders = orders;
            supplierHandler = new SupplierHandler();
        }

        public async Task<object> Execute()
        {
            return await supplierHandler.GetSupplierTypes(orders);
        }
    }
}