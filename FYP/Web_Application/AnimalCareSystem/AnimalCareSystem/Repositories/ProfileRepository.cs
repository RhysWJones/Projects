using AnimalCareSystem.ApplicationUI;
using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using AnimalCareSystem.ViewModels;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.Repositories
{
    public class ProfileRepository : IRepository
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private ApplicationDbContext _dbContext;

        public ProfileRepository(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager, ApplicationDbContext dbContext)
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _dbContext = dbContext;
        }

        public async Task<object> Create(object obj)
        {
            throw new NotImplementedException();
        }

        public async Task<object> Delete(object obj)
        {
            throw new NotImplementedException();
        }

        public async Task<object> Get(object obj)
        {
            KeyValuePair<string, object> requestData = (KeyValuePair<string, object>)obj;

            switch (requestData.Key)
            {
                case "getUserProfile":
                    string userId = (string)requestData.Value;
                    ApplicationUser user = await GetUserById(userId);
                    UserProfileViewModel userProfileViewModel = BuildUserProfileViewModel(user);
                    return userProfileViewModel;

                case "editProfile":
                    userId = (string)requestData.Value;
                    user = await GetUserById(userId);
                    UserProfileEditViewModel userProfileEditViewModel = await BuildProfileEditViewModel(user);
                    return userProfileEditViewModel;

                default:
                    return null;
            }
        }

        public async Task<object> Update(object obj)
        {
            KeyValuePair<string, object> requestData = (KeyValuePair<string, object>)obj;

            switch (requestData.Key)
            {
                case "editProfile":
                    UserProfileEditViewModel userProfileEditViewModel = (UserProfileEditViewModel)requestData.Value;
                    ApplicationUser uneditedUser = await GetUserById(userProfileEditViewModel.UserId);
                    int updateResult = await UpdateUserProfile(userProfileEditViewModel, uneditedUser);
                    return updateResult;

                default:
                    return null;
            }
        }

        public async Task<int> UpdateUserProfile(UserProfileEditViewModel userProfileEditViewModel, ApplicationUser uneditedUser)
        {
            if(userProfileEditViewModel.ProfilePhoto != null)
            {
                string fileName = "";
                string filePath = "";
                fileName = Path.GetFileName(userProfileEditViewModel.ProfilePhoto.FileName);
                filePath = Path.Combine(Directory.GetCurrentDirectory(), "wwwroot\\Images\\User_Images\\", fileName);
                try
                {
                    using (FileStream fileStream = new FileStream(filePath, FileMode.Create))
                    {
                        await userProfileEditViewModel.ProfilePhoto.CopyToAsync(fileStream);
                    }
                    uneditedUser.PhotoFolderSource = Path.Combine("~/Images/User_Images/", fileName);
                }
                catch (Exception e)
                {
                    return 0;
                }
            }

            if (uneditedUser.Description != userProfileEditViewModel.Description)
            {
                uneditedUser.Description = userProfileEditViewModel.Description;
            }
            
            if(userProfileEditViewModel.Carer == true)
            {
                foreach (ServiceRateViewModel serviceRateViewModel in userProfileEditViewModel.ServiceRates)
                {
                    ServiceRate serviceRateTest = uneditedUser.ServiceRates.FirstOrDefault(rate => rate.ServiceType.Id == serviceRateViewModel.ServiceType.Id);

                    if (serviceRateTest == null)
                    {
                        ServiceRate newServiceRate = new ServiceRate();
                        ServiceType serviceType = new ServiceType();

                        newServiceRate.Rate = serviceRateViewModel.Rate;
                        newServiceRate.User = uneditedUser;

                        newServiceRate.ServiceType = serviceType;
                        newServiceRate.ServiceType.Id = serviceRateViewModel.ServiceType.Id;
                        newServiceRate.ServiceType.Name = serviceRateViewModel.ServiceType.Name;

                        uneditedUser.ServiceRates.Add(newServiceRate);
                    }
                    else
                    {
                        serviceRateTest.Rate = serviceRateViewModel.Rate;
                    }

                    foreach (ServiceRate serviceRate in uneditedUser.ServiceRates)
                    {
                        if (serviceRate.ServiceType.Id == serviceRateViewModel.ServiceType.Id)
                        {
                            serviceRate.Rate = serviceRateViewModel.Rate;
                        }
                    }
                }
            }

            int updateResult = (int)await CommandFactory.CreateCommand(CommandFactory.UPDATE_USER, uneditedUser, _dbContext).Execute();
            return updateResult;
        }

        public async Task<UserProfileEditViewModel> BuildProfileEditViewModel(ApplicationUser user)
        {
            UserProfileEditViewModel userProfileEditViewModel = new UserProfileEditViewModel();

            userProfileEditViewModel.UserId = user.Id;
            userProfileEditViewModel.Description = user.Description;
            userProfileEditViewModel.Carer = user.Carer;

            if (user.Carer)
            {

                List<ServiceRateViewModel> serviceRateViewModelList = new List<ServiceRateViewModel>();

                List<ServiceType> serviceTypes = (List<ServiceType>)await CommandFactory.CreateCommand(CommandFactory.GET_SERVICE_TYPES, _dbContext).Execute();

                foreach (ServiceType service in serviceTypes)
                {
                    ServiceTypeViewModel serviceTypeViewModel = new ServiceTypeViewModel();
                    ServiceRateViewModel serviceRateViewModel = new ServiceRateViewModel();

                    ServiceRate serviceRate = user.ServiceRates.FirstOrDefault(rate => rate.ServiceType.Id == service.Id);

                    //if (!user.ServiceRates.Any(rate => rate.ServiceType == service))
                    if (serviceRate == null)
                    {
                        serviceTypeViewModel.Id = service.Id;
                        serviceTypeViewModel.Name = service.Name;

                        serviceRateViewModel.ServiceType = serviceTypeViewModel;
                        serviceRateViewModel.Rate = 0;
                    }
                    else
                    {
                        serviceTypeViewModel.Id = service.Id;
                        serviceTypeViewModel.Name = service.Name;

                        serviceRateViewModel.ServiceType = serviceTypeViewModel;
                        serviceRateViewModel.Rate = serviceRate.Rate;
                    }
                    serviceRateViewModelList.Add(serviceRateViewModel);
                }

                userProfileEditViewModel.ServiceRates = serviceRateViewModelList;
            }
            return userProfileEditViewModel;
        }

        public async Task<ApplicationUser> GetUserById(string userId)
        {
            ApplicationUser user = (ApplicationUser)await CommandFactory.CreateCommand(CommandFactory.GET_USER_BY_ID, userId, _userManager, _dbContext).Execute();
            return user;
        }

        public UserProfileViewModel BuildUserProfileViewModel(ApplicationUser user)
        {
            UserProfileViewModel userProfileViewModel = new UserProfileViewModel();
            List<ReviewViewModel> reviewViewModelList = new List<ReviewViewModel>();
            List<ServiceRateViewModel> serviceRateViewModelList = new List<ServiceRateViewModel>();

            userProfileViewModel.UserId = user.Id;
            userProfileViewModel.Forename = user.Forename;
            userProfileViewModel.Surname = user.Surname;
            userProfileViewModel.IdentificationVerified = user.IdentificationVerified;
            userProfileViewModel.AddressVerified = user.AddressVerified;
            userProfileViewModel.DBSChecked = user.DBSChecked;
            userProfileViewModel.BoardingLicenseVerified = user.BoardingLicenseVerified;
            userProfileViewModel.Description = user.Description;
            userProfileViewModel.PhotoFolderSource = user.PhotoFolderSource;
            userProfileViewModel.City = user.City;

            int recommendationsCount = 0;
            foreach (UserReview review in user.ReceivedReviews)
            {
                ReviewViewModel reviewViewModel = new ReviewViewModel();
                reviewViewModel.Title = review.Title;
                reviewViewModel.Description = review.Description;
                reviewViewModel.DateOfReview = review.Date;
                reviewViewModel.ReviewingUserForename = review.ReviewingUser.Forename;
                reviewViewModel.Recommended = review.Recommended;

                if (review.Recommended)
                {
                    recommendationsCount = recommendationsCount + 1;
                }

                reviewViewModelList.Add(reviewViewModel);
            }

            foreach (ServiceRate serviceRate in user.ServiceRates)
            {
                ServiceRateViewModel serviceRateViewModel = new ServiceRateViewModel();

                serviceRateViewModel.ServiceName = serviceRate.ServiceType.Name;
                serviceRateViewModel.Rate = serviceRate.Rate;

                serviceRateViewModelList.Add(serviceRateViewModel);
            }

            userProfileViewModel.NumberOfRecommendations = recommendationsCount;
            userProfileViewModel.Carer = user.Carer;
            userProfileViewModel.Reviews = reviewViewModelList.OrderByDescending(review => review.DateOfReview).ToList();
            userProfileViewModel.ServiceRates = serviceRateViewModelList;

            return userProfileViewModel;
        }
    }
}
