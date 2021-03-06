﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class UserBookingsViewModel
    {
        public long BookingId { get; set; }
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{dd/MM/yyyy}")]
        [DataType(DataType.Date)]
        public DateTime StartDate { get; set; }
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{dd/MM/yyyy}")]
        [DataType(DataType.Date)]
        public DateTime EndDate { get; set; }

        public long UserId { get; set; }

        public bool IsCurrentlyOnRental { get; set; }

        public bool NotCollected { get; set; }

        public string VehicleBooked { get; set; }

        public decimal Price { get; set; }
    }
}
