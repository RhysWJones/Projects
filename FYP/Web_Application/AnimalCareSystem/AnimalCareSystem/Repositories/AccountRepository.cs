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
    public class AccountRepository : IRepository
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private ApplicationDbContext _dbContext;

        public AccountRepository(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager, ApplicationDbContext dbContext)
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _dbContext = dbContext;
        }

        public async Task<object> Create(object obj)
        {
            KeyValuePair<string, object> requestData = (KeyValuePair<string, object>)obj;

            switch (requestData.Key)
            {
                case "register":
                    RegisterViewModel registerViewModel = (RegisterViewModel)requestData.Value;
                    ApplicationUser newUser = await RegisterNewUser(registerViewModel);
                    return newUser;

                default:
                    return null;
            }
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
                case "login":
                    LoginViewModel loginViewModel = (LoginViewModel)requestData.Value;
                    SignInResult result = await Login(loginViewModel);
                    return result;

                case "getEmailConfirmationToken":
                    ApplicationUser user = (ApplicationUser)requestData.Value;
                    string emailConfirmationToken = await GetEmailConfirmationToken(user);
                    return emailConfirmationToken;

                case "getUserById":
                    string userId = (string)requestData.Value;
                    user = await GetUserById(userId);
                    return user;

                default:
                    return null;
            }
        }

        public async Task<object> Update(object obj)
        {
            KeyValuePair<string, object> requestData = (KeyValuePair<string, object>)obj;

            switch (requestData.Key)
            {
                case "confirmEmail":
                    Dictionary<string, object> confirmEmailDictionary = (Dictionary<string, object>)requestData.Value;
                    ApplicationUser user = (ApplicationUser)confirmEmailDictionary["user"];
                    string confirmationCode = (string)confirmEmailDictionary["code"];
                    IdentityResult result = await ConfirmEmail(user, confirmationCode);
                    return result;

                default:
                    return null;
            }
        }

        public async Task<ApplicationUser> RegisterNewUser(RegisterViewModel registerViewModel)
        {
            ApplicationUser newUser = ConvertToUser(registerViewModel);

            if (newUser != null)
            {
                IdentityResult registrationResult = (IdentityResult)await CommandFactory.CreateCommand(CommandFactory.REGISTER, newUser, _userManager, _signInManager).Execute();

                if (registrationResult.Succeeded)
                {
                    return newUser;
                }
            }

            return null;
        }

        public async Task<SignInResult> Login(LoginViewModel loginViewModel)
        {
            SignInResult loginResult = (SignInResult)await CommandFactory.CreateCommand(CommandFactory.LOGIN, loginViewModel.Email, loginViewModel.Password, loginViewModel.RememberMe, _signInManager).Execute();

            return loginResult;
        }

        public async Task<string> GetEmailConfirmationToken(ApplicationUser user)
        {
            string emailConfirmationToken = (string)await CommandFactory.CreateCommand(CommandFactory.GET_CONFIRMATION_EMAIL_TOKEN, user, _userManager).Execute();

            return emailConfirmationToken;
        }

        public async Task<ApplicationUser> GetUserById(string userId)
        {
            ApplicationUser user = (ApplicationUser)await CommandFactory.CreateCommand(CommandFactory.GET_USER_BY_ID, userId, _userManager, _dbContext).Execute();
            return user;
        }

        public async Task<IdentityResult> ConfirmEmail(ApplicationUser user, string confirmationCode)
        {
            IdentityResult result = (IdentityResult)await CommandFactory.CreateCommand(CommandFactory.CONFIRM_EMAIL, user, confirmationCode, _userManager).Execute();
            return result;
        }

        public ApplicationUser ConvertToUser(RegisterViewModel registerViewModel)
        {
            ApplicationUser newUser = new ApplicationUser();

            newUser.PhoneNumber = registerViewModel.PhoneNumber;
            newUser.Forename = registerViewModel.Forename;
            newUser.Surname = registerViewModel.Surname;
            newUser.AddressLine1 = registerViewModel.AddressLine1;
            newUser.AddressLine2 = registerViewModel.AddressLine2;
            newUser.City = registerViewModel.City;
            newUser.County = registerViewModel.County;
            newUser.Postcode = registerViewModel.Postcode;
            newUser.DateOfBirth = registerViewModel.DateOfBirth;
            newUser.Email = registerViewModel.Email;
            newUser.UserName = registerViewModel.Email;
            newUser.PasswordHash = registerViewModel.Password;

            return newUser;
        }

    }
}
