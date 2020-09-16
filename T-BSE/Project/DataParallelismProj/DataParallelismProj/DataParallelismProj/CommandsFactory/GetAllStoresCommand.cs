using DataParallelismProj.Handler;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.CommandsFactory
{
    class GetAllStoresCommand : ICommand
    {
        StoreHandler storeHandler = null;
        public GetAllStoresCommand()
        {
            storeHandler = new StoreHandler();
        }
        public object Execute()
        {
            return storeHandler.GetAllStores();
        }
    }
}
