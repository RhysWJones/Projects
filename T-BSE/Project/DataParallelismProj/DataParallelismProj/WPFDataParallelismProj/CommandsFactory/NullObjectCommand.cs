using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPFDataParallelismProj.CommandsFactory
{
    class NullObjectCommand : ICommand
    {
        public async Task<object> Execute()
        {
            return this;
        }
    }
}
