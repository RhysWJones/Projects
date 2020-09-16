using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Models
{
    public class ServiceType
    {
        [Required]
        public int Id { get; set; }
        [Required]
        [DataType(DataType.Text)]
        public string Name { get; set; }

        public ServiceType(string name)
        {
            Name = name;
        }

        public ServiceType()
        {

        }
    }
}
