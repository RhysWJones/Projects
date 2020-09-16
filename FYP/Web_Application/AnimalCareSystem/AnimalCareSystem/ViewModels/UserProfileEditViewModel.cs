using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ViewModels
{
    public class UserProfileEditViewModel
    {
        public string UserId { get; set; }
        public string Description { get; set; }
        public List<ServiceRateViewModel> ServiceRates { get; set; }
        public IFormFile ProfilePhoto { get; set; }
        public bool Carer { get; set; }
    }
}
