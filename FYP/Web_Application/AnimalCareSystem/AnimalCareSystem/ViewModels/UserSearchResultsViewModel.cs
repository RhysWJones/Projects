using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ViewModels
{
    public class UserSearchResultsViewModel
    {
        public string UserId { get; set; }
        public string Forename { get; set; }
        public string Surname { get; set; }
        public bool IdentificationVerified { get; set; }
        public bool AddressVerified { get; set; }
        public bool DBSChecked { get; set; }
        public bool BoardingLicenseVerified { get; set; }
        public int NumberOfRecommendations { get; set; }
        public string PhotoFolderSource { get; set; }

    }
}
