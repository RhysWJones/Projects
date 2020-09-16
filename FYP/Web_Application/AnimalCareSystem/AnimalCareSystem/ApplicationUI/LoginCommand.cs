using AnimalCareSystem.Handlers;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class LoginCommand : ICommand
    {
        private string Email;
        private string Password;
        private bool RememberMe;
        private AccountHandler AccountHandler;

        public LoginCommand(string email, string password, bool rememberMe, SignInManager<ApplicationUser> signInManager)
        {
            Email = email;
            Password = password;
            RememberMe = rememberMe;
            AccountHandler = new AccountHandler(signInManager);
        }
        public async Task<object> Execute()
        {
            return await AccountHandler.Login(Email, Password, RememberMe);
        }
    }
}
