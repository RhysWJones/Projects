using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ViewModels
{
    public class ServiceRateViewModel
    {
        public ServiceTypeViewModel ServiceType { get; set; }
        public string ServiceName { get; set; }
        [Range(0, 100)]
        public int Rate { get; set; }
    }
}
