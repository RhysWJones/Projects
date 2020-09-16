using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class EditBookingViewModel
    {
        [Required]
        public long BookingId { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime StartDate { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime EndDate { get; set; }
        public Boolean StartHalfDay { get; set; }
        public Boolean EndHalfDay { get; set; }
        public Boolean LateReturn { get; set; }
        public Boolean Collected { get; set; }
        public decimal Price { get; set; }
        public List<EquipmentCheckboxSelectViewModel> ChosenEquipmentList { get; set; }
        public long VehicleId { get; set; }
        public string VehicleName { get; set; }
        public decimal VehicleCostPerDay { get; set; }
        public string UserForename { get; set; }
        public string UserSurname { get; set; }
    }
}
