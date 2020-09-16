using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Models
{
    public class ServiceRate
    {
        [Required]
        public int Id { get; set; }
        [Required]
        public ServiceType ServiceType { get; set; }
        [Required]
        public ApplicationUser User { get; set; }
        [DataType(DataType.Currency)]
        public int Rate { get; set; }

        public ServiceRate()
        {

        }
    }
}
