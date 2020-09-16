using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Models
{
    public class ApplicationUser : IdentityUser
    {
        /*IdentityUser has properties that will be used, this is why this class doesn't define them.
         * Id
         * Email 
         * NormalizedEmail
         * EmailConfirmed
         * PasswordHash
         * PhoneNumber
         */

        [PersonalData]
        [Required]
        [DataType(DataType.Text)]
        public string Forename { get; set; }
        [PersonalData]
        [Required]
        [DataType(DataType.Text)]
        public string Surname { get; set; }
        [PersonalData]
        [Required]
        public DateTime DateOfBirth { get; set; }
        [PersonalData]
        [Required]
        [DataType(DataType.Text)]
        public string AddressLine1 { get; set; }
        [PersonalData]
        [DataType(DataType.Text)]
        public string AddressLine2 { get; set; }
        [PersonalData]
        [Required]
        [DataType(DataType.Text)]
        public string City { get; set; }
        [PersonalData]
        [Required]
        [DataType(DataType.Text)]
        public string County { get; set; }
        [PersonalData]
        [Required]
        [DataType(DataType.PostalCode)]
        public string Postcode { get; set; }
        [DataType(DataType.Text)]
        public string PhotoFolderSource { get; set; }
        [DataType(DataType.Text)]
        public string IdentificationProofFileSource { get; set; }
        public bool IdentificationVerified { get; set; }
        [DataType(DataType.Text)]
        public string AddressProofFileSource { get; set; }
        public bool AddressVerified { get; set; }
        public string DBSCheckFileSource { get; set; }
        public bool DBSChecked { get; set; }
        public bool Carer { get; set; }
        [DataType(DataType.Text)]
        public string BoardingLicenseProofFileSource { get; set; }
        public bool BoardingLicenseVerified { get; set; }
        public bool Banned { get; set; }
        public bool Admin { get; set; }
        public string Description { get; set; }
        public List<ServiceRate> ServiceRates { get; set; }
        [InverseProperty("JobOwner")]
        public List<Job> JobsOwned { get; set; }
        [InverseProperty("Carer")]
        public List<Job> JobsAsCarer { get; set; }
        [InverseProperty("ReceivingUser")]
        public List<Message> ReceivedMessages { get; set; }
        [InverseProperty("SendingUser")]
        public List<Message> SentMessages { get; set; }
        [InverseProperty("ReviewingUser")]
        public List<UserReview> WrittenReviews { get; set; }
        [InverseProperty("ReceivingUser")]
        public List<UserReview> ReceivedReviews { get; set; }
        public List<UserReport> ReportsAgainstUser { get; set; }

        public ApplicationUser()
        {
            this.Carer = false;
            this.AddressVerified = false;
            this.IdentificationVerified = false;
            this.BoardingLicenseVerified = false;
            this.Banned = false;
            this.Admin = false;
            this.Description = "";
        }

        public ApplicationUser(string Id, string UserName, string NormalizedUserName, string Email, string NormalizedEmail, bool EmailConfirmed, string PasswordHash, string PhoneNumber, string forename, string surname, string addressLine1, string addressLine2, string postcode, DateTime dateOfBirth)
        {
            this.Id = Id;
            this.UserName = UserName;
            this.NormalizedUserName = NormalizedUserName;
            this.Email = Email;
            this.NormalizedEmail = NormalizedEmail;
            this.EmailConfirmed = EmailConfirmed;
            this.PasswordHash = PasswordHash;
            this.PhoneNumber = PhoneNumber;
            Forename = forename;
            Surname = surname;
            AddressLine1 = addressLine1;
            AddressLine2 = addressLine2;
            Postcode = postcode;
            DateOfBirth = dateOfBirth;
        }
    }
}
