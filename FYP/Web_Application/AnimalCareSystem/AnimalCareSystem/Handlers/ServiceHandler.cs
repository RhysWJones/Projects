using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Handlers
{
    public class ServiceHandler
    {
        private ApplicationDbContext _dbContext;

        public ServiceHandler(ApplicationDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<List<ServiceType>> GetServiceTypes()
        {
            List<ServiceType> serviceTypes = await _dbContext.ServiceType.ToListAsync();
            return serviceTypes;
        }
    }
}
