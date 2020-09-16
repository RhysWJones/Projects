using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;

namespace AnimalCareSystem.Handlers
{
    public class AccountHandler
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private ApplicationDbContext _dbContext;

        public AccountHandler()
        {
        }

        public AccountHandler(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager)
        {
            _userManager = userManager;
            _signInManager = signInManager;
        }

        public AccountHandler(SignInManager<ApplicationUser> signInManager)
        {
            _signInManager = signInManager;
        }

        public AccountHandler(UserManager<ApplicationUser> userManager, ApplicationDbContext dbContext)
        {
            _userManager = userManager;
            _dbContext = dbContext;
        }

        public AccountHandler(UserManager<ApplicationUser> userManager)
        {
            _userManager = userManager;
        }

        public AccountHandler(ApplicationDbContext dbContext)
        {
            _dbContext = dbContext;
        }

        public async Task<List<ApplicationUser>> GetUsersByCity(string city)
        {
            List<ApplicationUser> usersInCity = await _dbContext.User.Where(user => user.City == city).ToListAsync();
            return usersInCity;
        }

        public async Task<int> UpdateUser(ApplicationUser editedUser)
        {
            _dbContext.User.Update(editedUser);
            return await _dbContext.SaveChangesAsync();
        }

        public async Task<IdentityResult> ConfirmEmail(ApplicationUser user, string confirmationCode)
        {
            IdentityResult result = await _userManager.ConfirmEmailAsync(user, confirmationCode);
            return result;
        }

        public async Task<ApplicationUser> GetUserById(string userId)
        {
            ApplicationUser user = await _dbContext.User.Where(user => user.Id == userId)
                .Include(user => user.ReceivedReviews).ThenInclude(userReview => userReview.ReviewingUser)
                .Include(user => user.ServiceRates).ThenInclude(serviceRates => serviceRates.ServiceType)
                .FirstOrDefaultAsync();

            //ApplicationUser user = await _userManager.FindByIdAsync(userId);
            return user;
        }

        public async Task<string> GetEmailConfirmationToken(ApplicationUser user)
        {
            string emailConfirmationToken = await _userManager.GenerateEmailConfirmationTokenAsync(user);
            return emailConfirmationToken;
        }

        public async Task<IdentityResult> RegisterUser(ApplicationUser newUser)
        {
            IdentityResult result = await _userManager.CreateAsync(newUser, newUser.PasswordHash);
            await _userManager.AddClaimAsync(newUser, new Claim("Forename", newUser.Forename));
            await _userManager.AddToRoleAsync(newUser, "User");
            return result;
        }

        public async Task<SignInResult> Login(string email, string password, bool rememberMe)
        {
            SignInResult result = await _signInManager.PasswordSignInAsync(email, password, rememberMe, lockoutOnFailure: false);
            return result;
        }
    }
}
