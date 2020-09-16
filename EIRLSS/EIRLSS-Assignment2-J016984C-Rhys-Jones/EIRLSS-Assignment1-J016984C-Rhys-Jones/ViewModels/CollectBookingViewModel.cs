using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class CollectBookingViewModel
    {
        [Required(ErrorMessage = "Booking ID is required.")]
        public int BookingId { get; set; }

        [Required(ErrorMessage = "Driving license number is required.")]
        public String DrivingLicenseNumber { get; set; }

        [Required(ErrorMessage = "An image of the front of the driving license is required.")]
        public IFormFile DrivingLicenseImageFront { get; set; }

        [Required(ErrorMessage = "An image of the back of the driving license is required.")]
        public IFormFile DrivingLicenseImageBack { get; set; }

        [Required(ErrorMessage = "An image of the person collecting the booking is required")]
        public IFormFile PersonCollectingImage { get; set; }
        [Required(ErrorMessage = "An image of the additional identification is required")]
        public IFormFile AdditionalIdentificationImage { get; set; }
    }
}
