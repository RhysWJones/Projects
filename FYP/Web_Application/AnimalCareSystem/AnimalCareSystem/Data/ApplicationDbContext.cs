using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;

using AnimalCareSystem.Models;

namespace AnimalCareSystem.Data
{
    public class ApplicationDbContext : IdentityDbContext
    {
        public DbSet<ApplicationUser> User { get; set; }
        public DbSet<Job> Job { get; set; }
        public DbSet<JobStatus> JobStatus { get; set; }
        public DbSet<Message> Message { get; set; }
        public DbSet<ServiceRate> ServiceRate { get; set; }
        public DbSet<ServiceType> ServiceType { get; set; }
        public DbSet<UserReport> UserReport { get; set; }
        public DbSet<UserReview> UserReview { get; set; }

        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {
            Database.EnsureCreated();
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
            modelBuilder.Entity<IdentityUser>().ToTable("AspNetUsers");
            modelBuilder.Entity<Job>().ToTable("Job");
            modelBuilder.Entity<JobStatus>().ToTable("JobStatus");
            modelBuilder.Entity<Message>().ToTable("Message");
            modelBuilder.Entity<ServiceRate>().ToTable("ServiceRate");
            modelBuilder.Entity<ServiceType>().ToTable("ServiceType");
            modelBuilder.Entity<UserReport>().ToTable("UserReport");
            modelBuilder.Entity<UserReview>().ToTable("UserReview");

            modelBuilder.Entity<IdentityUser>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);

            modelBuilder.Entity<Job>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);

            modelBuilder.Entity<JobStatus>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);

            modelBuilder.Entity<Message>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);

            modelBuilder.Entity<ServiceRate>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);

            modelBuilder.Entity<ServiceType>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);

            modelBuilder.Entity<UserReport>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);

            modelBuilder.Entity<UserReview>()
            .HasIndex(iu => iu.Id)
            .IsUnique(true);
        }
    }
}
