using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI;
using Microsoft.AspNetCore.Identity;
using System.Data.Odbc;
using Microsoft.AspNetCore.Http;
using System.IO;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly ApplicationDbContext DbContext;
        private HomeViewModel HomeViewModel;
        private UserManager<ApplicationUser> UserManager;

        public HomeController(ILogger<HomeController> logger, ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            _logger = logger;
            DbContext = dbContext;
            UserManager = userManager;
        }

        [HttpGet]
        public async Task<IActionResult> Index()
        {
            HomeViewModel = new HomeViewModel();

            HomeViewModel.Vehicles = (List<Vehicle>)await CommandFactory.CreateCommand(CommandFactory.GET_VEHICLES, DbContext).Execute();
            ApplicationUser currentUser = await UserManager.GetUserAsync(HttpContext.User);
            if(currentUser != null)
            {
                var today = DateTime.Today;
                HomeViewModel.Age = (today.Year - currentUser.DateOfBirth.Year);
            }

            return View(HomeViewModel);
        }

        

        [HttpGet, Route("privacy")]
        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
