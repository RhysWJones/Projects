using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class FraudulentClaim
    {
        public int ID { get; set; }
        public string FamilyName { get; set; }
        public string Forenames { get; set; }
        public DateTime DateOfBirth { get; set; }
        public string AddressOfClaim { get; set; }
        public DateTime DateOfClaim { get; set; }
        public int InsurerCode { get; set; }
    }
}
