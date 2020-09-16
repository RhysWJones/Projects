using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels
{
    public class FileUploadViewModel
    {
        [Required(ErrorMessage = "A DVLA file is required")]
        public IFormFile DVLADataFile { get; set; }
    }
}
