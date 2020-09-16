using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers
{
    public class BookingHandler
    {
        ApplicationDbContext DbContext;

        public BookingHandler(ApplicationDbContext dbContext)
        {
            DbContext = dbContext;
        }

        public async Task<List<Booking>> GetAllBookingsForVehicle(long vehicleId)
        {
            List<Booking> bookingsForVehicle = await DbContext.Booking.Where(booking => booking.Vehicle.Id == vehicleId)
                .Include(booking => booking.User)
                .OrderByDescending(booking => booking.StartDate)
                .ToListAsync();

            return bookingsForVehicle;
        }

        public async Task<List<Booking>> GetAllBookingsForUser(string userId)
        {
            List<Booking> bookingsForUser = await DbContext.Booking.Where(booking => booking.User.Id == userId && (booking.EndDate > DateTime.Today || booking.Collected == false))
                .Include(booking => booking.Vehicle)
                .OrderByDescending(booking => booking.StartDate)
                .ToListAsync();

            return bookingsForUser;
        }

        public async Task<List<Booking>> GetCoincidingBookings(DateTime requestedStartDate, DateTime requestedEndDate)
        {
            List<Booking> coincidingBookings = await DbContext.Booking
                .Where(booking => (booking.StartDate.Date <= requestedStartDate.Date && booking.EndDate.Date >= requestedStartDate.Date) ||
                 (booking.StartDate.Date < requestedEndDate.Date && requestedEndDate.Date < booking.EndDate.Date) ||
                 (requestedStartDate.Date < booking.StartDate.Date && booking.StartDate.Date < requestedEndDate.Date))
                .Include(booking => booking.User)
                .Include(booking => booking.Vehicle)
                .ToListAsync();

            return coincidingBookings;
        }

        public async Task<int> AddBooking(Booking newBooking, List<Equipment> chosenEquipmentList)
        {
            newBooking.User = await DbContext.User.FindAsync(newBooking.User.Id);
            newBooking.Vehicle = await DbContext.Vehicle.FindAsync(newBooking.Vehicle.Id);
            await DbContext.Booking.AddAsync(newBooking);

            bool equipmentBookingsAdded = await CreateEquipmentBookings(newBooking, chosenEquipmentList);

            if(equipmentBookingsAdded == false)
            {
                return 0;
            }

            var result = await DbContext.SaveChangesAsync();

            return result;
        }

        public async Task<int> UpdateBooking(Booking editedBooking, List<Equipment> chosenEquipmentList)
        {
            int equipmentBookingsCleared = 0;
            Booking uneditedBooking = await GetBooking(editedBooking.Id);
            bool equipmentEdited = false;

            if(uneditedBooking != null)
            {
                if (uneditedBooking.StartDate.Date != editedBooking.StartDate.Date)
                {
                    uneditedBooking.StartDate = editedBooking.StartDate;
                }

                if (uneditedBooking.StartHalfDay != editedBooking.StartHalfDay)
                {
                    uneditedBooking.StartHalfDay = editedBooking.StartHalfDay;
                }

                if (uneditedBooking.EndDate.Date != editedBooking.EndDate.Date)
                {
                    uneditedBooking.EndDate = editedBooking.EndDate;
                }

                if(uneditedBooking.EndHalfDay != editedBooking.EndHalfDay)
                {
                    uneditedBooking.EndHalfDay = editedBooking.EndHalfDay;
                }

                if (uneditedBooking.LateReturn != editedBooking.LateReturn)
                {
                    uneditedBooking.LateReturn = editedBooking.LateReturn;
                }

                if (uneditedBooking.Collected != editedBooking.Collected)
                {
                    uneditedBooking.Collected = editedBooking.Collected;
                }

                if (uneditedBooking.Price != editedBooking.Price)
                {
                    uneditedBooking.Price = editedBooking.Price;
                }

                if (uneditedBooking.Price != editedBooking.Price)
                {
                    uneditedBooking.Price = editedBooking.Price;
                }
                
                if(chosenEquipmentList.Count != uneditedBooking.EquipmentBookings.Count)
                {
                    equipmentBookingsCleared = await ClearBookingEquipmentBookings(uneditedBooking.EquipmentBookings);
                    if (equipmentBookingsCleared < 1)
                    {
                        return 0;
                    }
                }
                else
                {
                    foreach(EquipmentBooking equipmentBooking in uneditedBooking.EquipmentBookings)
                    {
                        if(!chosenEquipmentList.Contains(equipmentBooking.Equipment))
                        {
                            equipmentEdited = true;
                        }
                    }

                    if(equipmentEdited)
                    {
                        equipmentBookingsCleared = await ClearBookingEquipmentBookings(uneditedBooking.EquipmentBookings);
                        if (equipmentBookingsCleared < 1)
                        {
                            return 0;
                        }
                    }
                }

                DbContext.Booking.Update(uneditedBooking);
                await CreateEquipmentBookings(uneditedBooking, chosenEquipmentList);
                return await DbContext.SaveChangesAsync();

            }
            return 0;
        }

        public async Task<Booking> GetBooking(long bookingId)
        {
            Booking booking = await DbContext.Booking.Include(b => b.Vehicle)
                .Include(b => b.User)
                .SingleOrDefaultAsync(b => b.Id == bookingId);

            booking.EquipmentBookings = await GetBookingEquipment(booking);

            return booking;
        }

        public async Task<List<EquipmentBooking>> GetBookingEquipment(Booking booking)
        {
            List<EquipmentBooking> equipmentBookingsForBooking = await DbContext
                .EquipmentBooking
                .Where(eb => eb.Booking.Id == booking.Id)
                .Include(eb => eb.Equipment)
                .ToListAsync();

            return equipmentBookingsForBooking;
        }

        public async Task<bool> CreateEquipmentBookings(Booking booking, List<Equipment> equipmentList)
        {
            try
            {
                for (int i = 0; i < equipmentList.Count; i++)
                {
                    equipmentList[i] = await DbContext.Equipment.FindAsync(equipmentList[i].Id);
                    EquipmentBooking equipmentBooking = new EquipmentBooking();
                    equipmentBooking.Booking = booking;
                    equipmentBooking.Equipment = equipmentList[i];
                    await DbContext.EquipmentBooking.AddAsync(equipmentBooking);
                }
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
            
        }

        public async Task<int> ClearBookingEquipmentBookings(List<EquipmentBooking> equipmentBookings)
        {
            DbContext.EquipmentBooking.RemoveRange(equipmentBookings);
            return await DbContext.SaveChangesAsync();
        }

        public async Task<int> DeleteBooking(long bookingId)
        {
            Booking booking = await GetBooking(bookingId);
            await ClearBookingEquipmentBookings(booking.EquipmentBookings);
            DbContext.Booking.Remove(booking);
            return await DbContext.SaveChangesAsync();
        }

        public async Task<int> CollectBooking(long bookingId)
        {
            Booking booking = await GetBooking(bookingId);
            booking.Collected = true;
            DbContext.Booking.Update(booking);
            return await DbContext.SaveChangesAsync();
        }
    }
}
