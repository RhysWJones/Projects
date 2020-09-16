using WPFDataParallelismProj.Handler;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPFDataParallelismProj.CommandsFactory
{
    class LoadDataCommand : ICommand
    {
        private FileHandler fileHandler;
        private Action<int, int> callback;

        public LoadDataCommand(Action<int, int> callback)
        {
            fileHandler = FileHandler.GetInstance();
            this.callback = callback;
        }

        public async Task<object> Execute()
        {
            return await fileHandler.LoadOrders(callback);
        }
    }
}
