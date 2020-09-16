using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class LoginCommand : ICommand
    {
        private String Email;
        private String PasswordHash;
        private UserHandler UserHandler;
        private bool RememberMe;
        

        public LoginCommand(string email, string passwordHash, bool rememberMe, SignInManager<ApplicationUser> signInManager)
        {
            Email = email;
            PasswordHash = passwordHash;
            RememberMe = rememberMe;
            UserHandler = new UserHandler(signInManager);
        }

        public async Task<object> Execute()
        {
            return await UserHandler.Login(Email, PasswordHash, RememberMe);
        }
    }
}
