using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPFDataParallelismProj.CommandsFactory
{
    interface ICommand
    {
        Task<Object> Execute();
    }
}
