using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Models
{
    public class VehicleType
    {
        public long Id { get; set; }
        public String Size { get; set; }

        public VehicleType()
        {

        }

        public VehicleType(long id, string size)
        {
            this.Id = id;
            Size = size;
        }
    }
}
