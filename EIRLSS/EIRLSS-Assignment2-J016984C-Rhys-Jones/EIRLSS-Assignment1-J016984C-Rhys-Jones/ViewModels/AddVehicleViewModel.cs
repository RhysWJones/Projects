using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;
using System.Web.Mvc;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class AddVehicleViewModel
    {
        [Required]
        public String Manufacturer { get; set; }

        [Required]
        public String Model { get; set; }

        [Required]
        [Range(3,5, ErrorMessage = "The number of doors cannot be below 3 or above 5.")]
        public int Doors { get; set; }

        [Required]
        [Range(2, 7, ErrorMessage = "The number of seats cannot be below 2 or above 7.")]
        public int Seats { get; set; }

        [Required]
        public String Colour { get; set; }

        [Required]
        [Range(20.00, Double.MaxValue, ErrorMessage = "Cost per day must be a minimum of 20.00.")]
        public decimal CostPerDay { get; set; }

        [Required(ErrorMessage = "A vehicle type is required")]
        public int VehicleTypeId { get; set; }

        [Required(ErrorMessage = "A fuel type is required")]
        public int FuelId { get; set; }

        [Required(ErrorMessage = "A tranmission type is required")]
        public int TransmissionId { get; set; }

        [Required(ErrorMessage = "A vehicle image file is required")]
        public IFormFile vehicleImageFile { get; set; }
    }
}
