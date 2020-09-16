using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.CommandsFactory
{
    class CommandFactory
    {
        const int GET_ALL_STORES = 1;
        const int GET_ALL_SUPPLIERS = 2;
        const int LOAD_DATA = 3;
        public ICommand CreateCommand(int commandType)
        {
            switch(commandType)
            {
                case GET_ALL_STORES:
                    return new GetAllStoresCommand();
                case GET_ALL_SUPPLIERS:
                    return new GetAllSuppliersCommand();
                default:
                    return new NullObjectCommand();
            }
        }

        public ICommand CreateCommand(int commandType, string selectedFolderPath)
        {
            switch (commandType)
            {
                case LOAD_DATA:
                    return new LoadDataCommand(selectedFolderPath);
                default:
                    return new NullObjectCommand();
            }
        }
    }
}
