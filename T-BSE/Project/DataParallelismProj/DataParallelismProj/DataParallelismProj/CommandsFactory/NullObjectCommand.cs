using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataParallelismProj.CommandsFactory
{
    class NullObjectCommand : ICommand
    {
        public object Execute()
        {
            return this;
        }
    }
}
