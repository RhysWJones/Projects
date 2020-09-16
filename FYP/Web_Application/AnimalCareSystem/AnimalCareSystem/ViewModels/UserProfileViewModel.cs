using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ViewModels
{
    public class UserProfileViewModel
    {
        public bool IsPersonalProfile { get; set; }
        public string UserId { get; set; }
        public string Forename { get; set; }
        public string Surname { get; set; }
        public string City { get; set; }
        public bool IdentificationVerified { get; set; }
        public bool AddressVerified { get; set; }
        public bool DBSChecked { get; set; }
        public bool BoardingLicenseVerified { get; set; }
        public string Description { get; set; }
        public int NumberOfRecommendations { get; set; }
        public bool Carer { get; set; }
        public string PhotoFolderSource { get; set; }
        [Required]
        public string EmailSubject { get; set; }
        [Required]
        public string EmailBody { get; set; }
        public List<ReviewViewModel> Reviews { get; set; }
        public List<ServiceRateViewModel> ServiceRates { get; set; }
    }
}
