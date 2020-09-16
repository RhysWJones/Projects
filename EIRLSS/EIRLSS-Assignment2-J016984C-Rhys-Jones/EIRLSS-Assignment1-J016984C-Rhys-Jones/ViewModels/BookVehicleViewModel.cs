using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class BookVehicleViewModel
    {
        [Required]
        public int ChosenVehicleId { get; set; }
        [Required]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:dd/MM/yyyy}")]
        [DataType(DataType.Date)]
        public DateTime StartDate { get; set; }
        [Required]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:dd/MM/yyyy}")]
        [DataType(DataType.Date)]
        public DateTime EndDate { get; set; }
        [Required]
        public Boolean StartHalfDay { get; set; }
        [Required]
        public Boolean EndHalfDay { get; set; }
        [Required]
        public string UserId { get; set; }
        [Required]
        public decimal TotalCost { get; set; }

        public List<EquipmentCheckboxSelectViewModel> ChosenEquipmentList { get; set; }
    }
}
