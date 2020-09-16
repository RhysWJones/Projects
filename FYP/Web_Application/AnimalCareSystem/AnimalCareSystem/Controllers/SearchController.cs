using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using AnimalCareSystem.Repositories;
using AnimalCareSystem.ViewModels;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace AnimalCareSystem.Controllers
{
    [Route("search")]
    public class SearchController : Controller
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private readonly ApplicationDbContext _dbContext;
        private readonly SearchRepository _searchRepository;

        public SearchController(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager, ApplicationDbContext dbContext)
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _dbContext = dbContext;
            _searchRepository = new SearchRepository(userManager, signInManager, dbContext);

        }

        [HttpGet]
        public IActionResult UserSearch()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult UserSearch([Bind("City")] UserSearchViewModel userSearchViewModel)
        {
            if (ModelState.IsValid)
            {
                return RedirectToAction("UserSearchResults", "search", userSearchViewModel);
            }
            return View();
                
        }

        [HttpGet, Route("/results")]
        public async Task<IActionResult> UserSearchResults([FromQuery(Name = "City")] string city)
        {
            UserSearchViewModel userSearchViewModel = new UserSearchViewModel();
            userSearchViewModel.City = city;

            KeyValuePair<string, object> userSearchKeyValuePair = new KeyValuePair<string, object>("userSearchResults", userSearchViewModel);
            UserSearchResultsListViewModel userSearchResultsListViewModel = (UserSearchResultsListViewModel)await _searchRepository.Get(userSearchKeyValuePair);
            return View(userSearchResultsListViewModel);
        }
    }
}
