using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class EquipmentBooking
    {
        public int Id { get; set; }
        public Booking Booking { get; set; }
        public Equipment Equipment { get; set; }
        public int Count { get; set; }

        public EquipmentBooking()
        {
        }

        public EquipmentBooking(Booking booking, Equipment equipment)
        {
            Booking = booking;
            Equipment = equipment;
        }

        public EquipmentBooking(int id, Booking booking, Equipment equipment)
        {
            Id = id;
            Booking = booking;
            Equipment = equipment;
        }
    }
}
