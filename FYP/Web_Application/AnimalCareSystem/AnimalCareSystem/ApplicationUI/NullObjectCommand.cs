using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class NullObjectCommand : ICommand
    {
        public async Task<object> Execute()
        {
            return this;
        }
    }
}
