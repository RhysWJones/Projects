using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class RegisterViewModel
    {
        [Required]
        [EmailAddress]
        [Display(Name = "Email")]
        public string Email { get; set; }

        [PersonalData]
        [Required]
        [StringLength(100, ErrorMessage = "The {0} must be at least {2} and at max {1} characters long.", MinimumLength = 8)]
        [RegularExpression(@"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$",
            ErrorMessage = "Passwords are required to have at least one uppercase character, one numerical character and alphanumeric character from the following: @$!%*?&")] //Regex taken from here: https://stackoverflow.com/questions/19605150/regex-for-password-must-contain-at-least-eight-characters-at-least-one-number-a.
        [DataType(DataType.Password)]
        [Display(Name = "Password")]
        public string Password { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "Confirm password")]
        [Compare("Password", ErrorMessage = "The passwords do not match.")]
        public string ConfirmPassword { get; set; }

        [PersonalData]
        [Required]
        [RegularExpression(@"^\+?(?:\d\s?){10,12}$",
            ErrorMessage = "Invalid phone number.")] //Regex found here: https://stackoverflow.com/questions/44327236/regex-for-uk-phone-number.
        public string PhoneNumber { get; set; }

        [PersonalData]
        [Required]
        public string Forename { get; set; }

        [PersonalData]
        [Required]
        public string Surname { get; set; }

        [PersonalData]
        [Required]
        public string AddressLine1 { get; set; }

        [PersonalData]
        public string AddressLine2 { get; set; }

        [PersonalData]
        [Required]
        [RegularExpression(@"([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\s?[0-9][A-Za-z]{2})",
            ErrorMessage = "Invalid postcode.")] //Regex to match a valid UK postcode format found here: https://stackoverflow.com/questions/164979/regex-for-matching-uk-postcodes
        public string Postcode { get; set; }

        [PersonalData]
        [Required]
        [DataType(DataType.Date)]
        public DateTime DateOfBirth { get; set; }

        [PersonalData]
        [Required]
        [StringLength(16)]
        public string LicenseNumber { get; set; }

        
    }
}
