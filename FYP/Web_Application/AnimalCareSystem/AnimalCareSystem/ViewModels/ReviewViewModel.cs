using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ViewModels
{
    public class ReviewViewModel
    {
        public string ReviewingUserForename { get; set; }
        public DateTime DateOfReview { get; set; }
        public bool Recommended { get; set; }
        public string Description { get; set; }
        public string Title { get; set; }
    }
}
