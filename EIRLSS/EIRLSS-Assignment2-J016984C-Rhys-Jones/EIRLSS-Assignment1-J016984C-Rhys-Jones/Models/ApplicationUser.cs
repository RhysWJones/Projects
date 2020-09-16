using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class ApplicationUser : IdentityUser
    {
        /*IdentityUser has a number of properties some relevant ones are listed below
         * Id
         * UserName
         * NormalizedUserName
         * Email 
         * NormalizedEmail
         * EmailConfirmed
         * PasswordHash
         * PhoneNumber
         */
        [PersonalData]
        [Required]
        public String Forename { get; set; }
        [PersonalData]
        [Required]
        public String Surname { get; set; }
        [PersonalData]
        [Required]
        public String AddressLine1 { get; set; }
        [PersonalData]
        public String AddressLine2 { get; set; }
        [PersonalData]
        [Required]
        [RegularExpression(@"([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\s?[0-9][A-Za-z]{2})",
            ErrorMessage = "Postcode must match the standard UK postcode format.")] //Regex to match a valid UK postcode format found here: https://stackoverflow.com/questions/164979/regex-for-matching-uk-postcodes
        public String Postcode { get; set; }
        [PersonalData]
        [Required]
        public DateTime DateOfBirth { get; set; }
        [Required]
        [StringLength(16)]
        public String LicenseNumber { get; set; }
        [Required]
        public bool Blacklisted { get; set; }
        public String IdentificationFolderSource { get; set; }

        public ApplicationUser()
        {
            
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
