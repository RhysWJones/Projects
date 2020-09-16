using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Repositories
{
    interface IRepository
    {
        Task<Object> Create(Object obj);
        Task<Object> Get(Object obj);
        Task<Object> Update(Object obj);
        Task<Object> Delete(Object obj);
    }
}
