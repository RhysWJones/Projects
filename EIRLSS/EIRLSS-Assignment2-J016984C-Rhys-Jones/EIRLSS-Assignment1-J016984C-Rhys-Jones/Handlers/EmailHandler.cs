using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using MailKit.Net.Smtp;
using MimeKit;
using Microsoft.AspNetCore.Http;
using System;
using System.IO;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers
{
    public class EmailHandler
    {
        private const String SmtpAddress = "smtp.gmail.com";
        private const int Port = 465;
        private const String Username = "BangerCoRentals@gmail.com";
        private const String Password = "T0tallyS3curePassw0rd";

        private byte[] FileByteArray;

        public EmailHandler()
        {
        }

        public bool SendEmailToDVLA(IFormFileCollection fileCollection, ApplicationUser user)
        {
            MimeMessage message = new MimeMessage();

            MailboxAddress fromEmailAddress = new MailboxAddress("BangerCo Car Rentals", "BangerCoRentals@gmail.com");
            MailboxAddress toEmailAddress = new MailboxAddress("DVLA", "rhyswj94@gmail.com");

            message.From.Add(fromEmailAddress);
            message.To.Add(toEmailAddress);

            message.Subject = "Invalid Driver: Attempted To Book Car Rental";

            BodyBuilder emailBodyBuilder = new BodyBuilder();
            emailBodyBuilder.TextBody = "An attempt was made to rent a vehicle by " + user.Forename + " " + user.Surname + " with driving license number " + user.LicenseNumber + " on " + DateTime.Now + "GMT" + ". Our registration number is 03716371. Please find all relevant documents attached.";
            
            try
            {
                foreach (IFormFile attachment in fileCollection)
                {
                    using (MemoryStream memoryStream = new MemoryStream())
                    {
                        attachment.CopyTo(memoryStream);
                        FileByteArray = memoryStream.ToArray();
                    }

                    emailBodyBuilder.Attachments.Add(attachment.FileName, FileByteArray, ContentType.Parse(attachment.ContentType));
                }

                message.Body = emailBodyBuilder.ToMessageBody();

                SmtpClient client = new SmtpClient();
                client.Connect(SmtpAddress, Port, true);
                client.Authenticate(Username, Password);

                client.Send(message);
                client.Disconnect(true);
                client.Dispose();
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
    }
}
