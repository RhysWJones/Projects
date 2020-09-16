using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WPFDataParallelismProj.Handler;

namespace WPFDataParallelismProj.CommandsFactory
{
    class SetFolderPathCommand : ICommand
    {
        private FileHandler fileHandler;
        private string selectedFolderPath;

        public SetFolderPathCommand(string selectedFolderPath)
        {
            fileHandler = FileHandler.GetInstance();
            this.selectedFolderPath = selectedFolderPath;
        }

        public async Task<object> Execute()
        {
            return await fileHandler.SetFolderPath(selectedFolderPath);
        }
    }
}
