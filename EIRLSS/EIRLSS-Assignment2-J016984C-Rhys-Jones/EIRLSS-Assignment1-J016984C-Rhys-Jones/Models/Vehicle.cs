using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class Vehicle
    {
        public long Id { get; set; }
        public String Manufacturer { get; set; }
        public String Model { get; set; }
        public int Doors { get; set; } 
        public int Seats { get; set; }
        public String Colour { get; set; }
        [DataType(DataType.Currency)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:c}")]
        [Display(Name = "GB£")]
        public decimal CostPerDay { get; set; }
        public VehicleType VehicleType { get; set; }
        public Fuel Fuel { get; set; }
        public Transmission Transmission { get; set; }
        public String VehicleImageSource { get; set; }
        public String VehicleComparisonSourceURL { get; set; }
        
        public Vehicle()
        {
        }

        public Vehicle(long id, string manufacturer, string model, int doors, int seats, string colour, VehicleType vehicleType, Fuel fuel, Transmission transmission, decimal costPerDay, String vehicleImageSource)
        {
            Id = id;
            Manufacturer = manufacturer;
            Model = model;
            Doors = doors;
            Seats = seats;
            Colour = colour;
            VehicleType = vehicleType;
            Fuel = fuel;
            Transmission = transmission;
            CostPerDay = costPerDay;
            VehicleImageSource = vehicleImageSource;
        }

        public Vehicle(long id, string manufacturer, string model, int doors, int seats, string colour, VehicleType vehicleType, Fuel fuel, Transmission transmission, decimal costPerDay)
        {
            Id = id;
            Manufacturer = manufacturer;
            Model = model;
            Doors = doors;
            Seats = seats;
            Colour = colour;
            VehicleType = vehicleType;
            Fuel = fuel;
            Transmission = transmission;
            CostPerDay = costPerDay;
        }
    }
}
