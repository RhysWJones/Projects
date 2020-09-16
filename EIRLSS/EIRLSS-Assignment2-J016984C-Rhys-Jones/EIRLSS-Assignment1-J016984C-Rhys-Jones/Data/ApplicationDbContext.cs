using System;
using System.Collections.Generic;
using System.Text;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Data
{
    public class ApplicationDbContext : IdentityDbContext
    {
        public DbSet<ApplicationUser> User { get; set; }
        public DbSet<Vehicle> Vehicle { get; set; }
        public DbSet<VehicleType> VehicleType { get; set; }
        public DbSet<Transmission> Transmission { get; set; }
        public DbSet<Fuel> Fuel { get; set; }
        public DbSet<Equipment> Equipment { get; set; }
        public DbSet<Booking> Booking { get; set; }
        public DbSet<EquipmentBooking> EquipmentBooking { get; set; }

        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
            Database.EnsureCreated();
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<IdentityUser>().ToTable("AspNetUsers");
            //modelBuilder.Entity<ApplicationUser>().ToTable("AspNetUsers");
            modelBuilder.Entity<Vehicle>().ToTable("Vehicles");
            modelBuilder.Entity<VehicleType>().ToTable("VehicleType");
            modelBuilder.Entity<Transmission>().ToTable("Transmission");
            modelBuilder.Entity<Fuel>().ToTable("Fuel");
            modelBuilder.Entity<Equipment>().ToTable("Equipment");
            modelBuilder.Entity<Booking>().ToTable("Bookings");
            modelBuilder.Entity<EquipmentBooking>().ToTable("EquipmentBookings");

            modelBuilder.Entity<Booking>().Property(b => b.Price).HasColumnType("money");
            modelBuilder.Entity<Equipment>().Property(e => e.Price).HasColumnType("money");
            modelBuilder.Entity<Vehicle>().Property(v => v.CostPerDay).HasColumnType("money");
        }
    }
}
