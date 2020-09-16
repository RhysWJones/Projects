using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers
{
    public class EquipmentHandler
    {
        ApplicationDbContext DbContext;

        public EquipmentHandler(ApplicationDbContext dbContext)
        {
            DbContext = dbContext;
        }

        public async Task<List<Equipment>> GetAllEquipment()
        {
            List<Equipment> Equipment = await DbContext.Equipment.ToListAsync();

            return Equipment;
        }

        public async Task<Equipment> GetEquipmentById(long equipmentId)
        {
            Equipment equipment = await DbContext.Equipment.Where(e => e.Id == equipmentId).FirstOrDefaultAsync();
            return equipment;
        }

        public async Task<bool> CheckEquipmentAvailability(Equipment equipment, List<Booking> bookings)
        {
            bool available = false;
            List<EquipmentBooking> conflictingEquipmentBookings = new List<EquipmentBooking>();
            equipment = await GetEquipmentById(equipment.Id);

            foreach (Booking booking in bookings)
            {
                EquipmentBooking ConflictingEquipmentBooking = await DbContext.EquipmentBooking.Where(eb => eb.Booking.Id == booking.Id).FirstOrDefaultAsync();
                if(ConflictingEquipmentBooking != null)
                {
                    conflictingEquipmentBookings.Add(ConflictingEquipmentBooking);
                }
            }
            if(conflictingEquipmentBookings.Count < equipment.Count)
            {
                available = true;
            }
            return available;
        }
    }
}
