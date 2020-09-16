using AnimalCareSystem.ApplicationUI;
using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using AnimalCareSystem.ViewModels;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Repositories
{
    public class SearchRepository : IRepository
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private ApplicationDbContext _dbContext;

        public SearchRepository(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager, ApplicationDbContext dbContext)
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _dbContext = dbContext;
        }

        public Task<object> Create(object obj)
        {
            throw new NotImplementedException();
        }

        public Task<object> Delete(object obj)
        {
            throw new NotImplementedException();
        }

        public async Task<object> Get(object obj)
        {
            KeyValuePair<string, object> requestData = (KeyValuePair<string, object>)obj;

            switch (requestData.Key)
            {
                case "userSearchResults":
                    UserSearchViewModel userSearchViewModel = (UserSearchViewModel)requestData.Value;
                    UserSearchResultsListViewModel searchResults = (UserSearchResultsListViewModel)await SearchForUsers(userSearchViewModel);
                    return searchResults;
                default:
                    return null;
            }
        }

        public Task<object> Update(object obj)
        {
            throw new NotImplementedException();
        }

        public async Task<UserSearchResultsListViewModel> SearchForUsers(UserSearchViewModel userSearchViewModel)
        {
            UserSearchResultsListViewModel userSearchResults = new UserSearchResultsListViewModel();
            List<UserSearchResultsViewModel> userSearchResultList = new List<UserSearchResultsViewModel>();
            userSearchResults.Users = userSearchResultList;


            if (userSearchViewModel.City != null)
            {
                string city = userSearchViewModel.City;
                List<ApplicationUser> usersByCity = (List<ApplicationUser>)await CommandFactory.CreateCommand(CommandFactory.GET_USERS_BY_CITY, city, _dbContext).Execute();

                foreach(ApplicationUser user in usersByCity)
                {
                    UserSearchResultsViewModel userSearchResultsViewModel = new UserSearchResultsViewModel();
                    int numberOfRecommendations = 0;

                    userSearchResultsViewModel.UserId = user.Id;
                    userSearchResultsViewModel.Forename = user.Forename;
                    userSearchResultsViewModel.Surname = user.Surname;
                    userSearchResultsViewModel.IdentificationVerified = user.IdentificationVerified;
                    userSearchResultsViewModel.AddressVerified = user.AddressVerified;
                    userSearchResultsViewModel.DBSChecked = user.DBSChecked;
                    userSearchResultsViewModel.BoardingLicenseVerified = user.BoardingLicenseVerified;

                    if(user.ReceivedReviews != null)
                    {
                        foreach (UserReview userReview in user.ReceivedReviews)
                        {
                            if (userReview.Recommended)
                            {
                                numberOfRecommendations = numberOfRecommendations + 1;
                            }
                        }
                    }

                    userSearchResultsViewModel.NumberOfRecommendations = numberOfRecommendations;
                    userSearchResultsViewModel.PhotoFolderSource = user.PhotoFolderSource;

                    userSearchResults.Users.Add(userSearchResultsViewModel);
                }
            }

            return userSearchResults;
        }
    }
}
