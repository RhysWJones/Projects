using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class ViewVehicleBookingsViewModel
    {
        public List<VehicleBookingsViewModel> VehicleBookingModels { get; set; }
        public int ChosenVehicleId { get; set; }
    }
}
