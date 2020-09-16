using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ViewModels
{
    public class UserSearchViewModel
    {
        [Required]
        [RegularExpression(@"^[a-zA-Z\s]*$", ErrorMessage = "A city should only contain letters.")]
        public string City { get; set; }
    }
}
