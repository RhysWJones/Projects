using DataParallelismProj.Handler;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.CommandsFactory
{
    class LoadDataCommand : ICommand
    {
        FileHandler fileHandler;
        string selectedFolderPath;

        public LoadDataCommand(string selectedFolderPath)
        {
            this.fileHandler = new FileHandler();
            this.selectedFolderPath = selectedFolderPath;
        }

        public object Execute()
        {
            return fileHandler.LoadOrders(selectedFolderPath);
        }
    }
}
