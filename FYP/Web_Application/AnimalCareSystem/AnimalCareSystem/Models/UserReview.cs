using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Models
{
    public class UserReview
    {
        [Required]
        public int Id { get; set; }
        [Required]
        public ApplicationUser ReviewingUser { get; set; }
        [Required]
        public ApplicationUser ReceivingUser { get; set; }
        [DataType(DataType.MultilineText)]
        public string Description { get; set; }
        public string Title { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime Date { get; set; }
        [Required]
        public bool Recommended { get; set; }

        public UserReview()
        {

        }
    }
}
