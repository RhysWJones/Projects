using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers
{
    public class VehicleHandler
    {
        private ApplicationDbContext DbContext;

        public VehicleHandler(ApplicationDbContext dbContext)
        {
            DbContext = dbContext;
        }

        public async Task<List<VehicleType>> GetVehicleTypes()
        {
            List<VehicleType> vehicleTypes = await DbContext.VehicleType.ToListAsync();

            return vehicleTypes;
        }

        public async Task<List<Transmission>> GetTransmissionTypes()
        {
            List<Transmission> transmissionTypes = await DbContext.Transmission.ToListAsync();

            return transmissionTypes;
        }

        public async Task<List<Fuel>> GetFuelTypes()
        {
            List<Fuel> fuelTypes = await DbContext.Fuel.ToListAsync();

            return fuelTypes;
        }

        public async Task<int> AddVehicle(Vehicle newVehicle)
        {
            int result;
            newVehicle.VehicleType = await DbContext.VehicleType.FindAsync(newVehicle.VehicleType.Id);
            newVehicle.Transmission = await DbContext.Transmission.FindAsync(newVehicle.Transmission.Id);
            newVehicle.Fuel = await DbContext.Fuel.FindAsync(newVehicle.Fuel.Id);

            await DbContext.Vehicle.AddAsync(newVehicle);
            result = await DbContext.SaveChangesAsync();

            return result;
        }

        public async Task<List<Vehicle>> GetVehicles()
        {
            List<Vehicle> vehicles = await DbContext.Vehicle.Include(vehicle => vehicle.VehicleType)
            .Include(vehicle => vehicle.Fuel)
            .Include(vehicle => vehicle.Transmission)
            .ToListAsync();

            return vehicles;
        }

        public async Task<Vehicle> GetVehicle(long vehicleId)
        {
            
            Vehicle vehicle = await DbContext.Vehicle.Where(vehicle => vehicle.Id == vehicleId)
            .Include(vehicle => vehicle.VehicleType)
            .Include(vehicle => vehicle.Fuel)
            .Include(vehicle => vehicle.Transmission)
            .FirstOrDefaultAsync();

            return vehicle;
        }

        public async Task<int> UpdateVehicleComparisonSource(int vehicleId, string comparisonSourceURL)
        {
            Vehicle vehicleToEdit = await GetVehicle(vehicleId);

            vehicleToEdit.VehicleComparisonSourceURL = comparisonSourceURL;

            DbContext.Vehicle.Update(vehicleToEdit);
            return await DbContext.SaveChangesAsync();
        }

        public async Task<int> UpdateVehicleCostPerDay(long vehicleId, int newCostPerDay)
        {
            Vehicle vehicleToEdit = await GetVehicle(vehicleId);

            vehicleToEdit.CostPerDay = newCostPerDay;

            DbContext.Vehicle.Update(vehicleToEdit);
            return await DbContext.SaveChangesAsync();
        }
    }
}
