using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class Transmission
    {
        public long Id { get; set; }
        public String Type { get; set; }

        public Transmission()
        {

        }

        public Transmission(long id, string type)
        {
            this.Id = id;
            this.Type = type;
        }
    }
}
