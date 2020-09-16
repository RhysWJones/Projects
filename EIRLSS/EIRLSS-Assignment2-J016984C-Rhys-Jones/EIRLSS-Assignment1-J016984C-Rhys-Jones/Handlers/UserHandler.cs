using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers
{
    public class UserHandler
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private ApplicationDbContext DbContext;
        public UserHandler(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager)
        {
            _userManager = userManager;
            _signInManager = signInManager;
        }
        public UserHandler(UserManager<ApplicationUser> userManager, ApplicationDbContext dbContext)
        {
            DbContext = dbContext;
            _userManager = userManager;
        }

        public UserHandler(SignInManager<ApplicationUser> signInManager)
        {
            _signInManager = signInManager;
        }

        public async Task<IdentityResult> RegisterUser(ApplicationUser newUser)
        {
            IdentityResult result = await _userManager.CreateAsync(newUser, newUser.PasswordHash);
            var claim = await _userManager.AddClaimAsync(newUser, new Claim("Forename", newUser.Forename));
            var role = await _userManager.AddToRoleAsync(newUser, "User");

            if (result.Succeeded)
            {
                await _signInManager.SignInAsync(newUser, isPersistent: false);
            }
            return result;
        }
        
        public async Task<SignInResult> Login(string email, string passwordHash, bool rememberMe)
        {
            SignInResult result = await _signInManager.PasswordSignInAsync(email, passwordHash, rememberMe, lockoutOnFailure: false);
            return result;
        }

        public async Task<int> BlacklistUser(string userId)
        {
            ApplicationUser user = await GetUser(userId);
            user.Blacklisted = true;
            DbContext.User.Update(user);
            return await DbContext.SaveChangesAsync();
        }

        public async Task<ApplicationUser> GetUser(string userId)
        {
            return await _userManager.FindByIdAsync(userId);
        }

        public async Task<int> UpdateUser(ApplicationUser updatedUser)
        {
            ApplicationUser uneditedUser = await GetUser(updatedUser.Id);

            if(uneditedUser != null)
            {
                if(uneditedUser.IdentificationFolderSource != updatedUser.IdentificationFolderSource)
                {
                    uneditedUser.IdentificationFolderSource = updatedUser.IdentificationFolderSource;
                }

                DbContext.User.Update(updatedUser);
                return await DbContext.SaveChangesAsync();
            }
            return 0;
        }
    }
}
