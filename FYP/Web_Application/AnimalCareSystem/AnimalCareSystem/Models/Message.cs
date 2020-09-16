using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Models
{
    public class Message
    {
        [Required]
        public int Id { get; set; }
        [Required]
        [DataType(DataType.MultilineText)]
        public string Content { get; set; }
        [Required]
        [DataType(DataType.DateTime)]
        public DateTime DateTimeSent { get; set; }
        [Required]
        public ApplicationUser ReceivingUser { get; set; }
        [Required]
        public ApplicationUser SendingUser { get; set; }

        public Message()
        {

        }
    }
}
