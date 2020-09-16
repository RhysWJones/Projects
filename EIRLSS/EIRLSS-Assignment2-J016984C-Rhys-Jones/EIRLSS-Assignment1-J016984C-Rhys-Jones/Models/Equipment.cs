using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class Equipment
    {
        public long Id { get; set; }
        public String Name { get; set; }
        public Decimal Price { get; set; }
        public int Count { get; set; }
        public List<EquipmentBooking> EquipmentBookings { get; set; }

        public Equipment()
        {

        }

        public Equipment(long id, string name, decimal price, List<EquipmentBooking> equipmentBookings)
        {
            Id = id;
            Name = name;
            Price = price;
            EquipmentBookings = equipmentBookings;
        }
    }
}
