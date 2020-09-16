using DataParallelismProj.Handler;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.CommandsFactory
{
    class GetAllSuppliersCommand : ICommand
    {
        OrderHandler orderHandler;
        public GetAllSuppliersCommand()
        {
            orderHandler = new OrderHandler();
        }
        public object Execute()
        {
            return orderHandler.GetAllSuppliers();
        }
    }
}
