using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class SendEmailCommand : ICommand
    {
        private EmailHandler EmailHandler;
        private ApplicationUser User;
        private IFormFileCollection FileCollection;

        public SendEmailCommand(IFormFileCollection fileCollection, ApplicationUser user)
        {
            EmailHandler = new EmailHandler();
            User = user;
            FileCollection = fileCollection;
        }

        public async Task<object> Execute()
        {
            return EmailHandler.SendEmailToDVLA(FileCollection, User);
        }
    }
}
