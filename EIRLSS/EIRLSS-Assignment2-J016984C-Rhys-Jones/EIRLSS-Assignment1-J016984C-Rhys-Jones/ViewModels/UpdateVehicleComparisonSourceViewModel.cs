using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class UpdateVehicleComparisonSourceViewModel
    {
        [Required]
        public string VehicleComparisonSource { get; set; }
        [Required]
        public int VehicleId { get; set; }
    }
}
