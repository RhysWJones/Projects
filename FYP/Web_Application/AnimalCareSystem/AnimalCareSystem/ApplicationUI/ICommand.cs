using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public interface ICommand
    {
        Task<Object> Execute();
    }
}
