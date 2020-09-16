 using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class Booking
    {
        public long Id { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public Boolean LateReturn { get; set; }
        public Boolean StartHalfDay { get; set; }
        public Boolean EndHalfDay { get; set; }
        public Boolean Collected { get; set; }
        public decimal Price { get; set; }
        public ApplicationUser User { get; set; }
        public Vehicle Vehicle { get; set; }
        public List<EquipmentBooking> EquipmentBookings { get; set; }

        public Booking()
        {

        }

        public Booking(long id, DateTime startDate, DateTime endDate, bool lateReturn, bool startHalfDay, bool endHalfDay, bool collected, ApplicationUser user, Vehicle vehicle, List<EquipmentBooking> equipmentBookings)
        {
            Id = id;
            StartDate = startDate;
            EndDate = endDate;
            LateReturn = lateReturn;
            StartHalfDay = startHalfDay;
            EndHalfDay = endHalfDay;
            Collected = collected;
            User = user;
            Vehicle = vehicle;
            EquipmentBookings = equipmentBookings;
        }
    }
}
