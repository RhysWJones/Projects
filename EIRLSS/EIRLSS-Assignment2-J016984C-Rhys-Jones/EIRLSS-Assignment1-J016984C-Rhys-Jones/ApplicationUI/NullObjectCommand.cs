using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class NullObjectCommand : ICommand
    {
        public async Task<object> Execute()
        {
            return this;
        }
    }
}
