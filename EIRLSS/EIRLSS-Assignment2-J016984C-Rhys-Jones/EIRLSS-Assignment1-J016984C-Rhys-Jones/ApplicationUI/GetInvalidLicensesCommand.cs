using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetInvalidLicensesCommand : ICommand
    {
        private FileHandler FileHandler;
        public GetInvalidLicensesCommand()
        {
            FileHandler = new FileHandler();
        }

        public async Task<object> Execute()
        {
            return FileHandler.GetAllInvalidLicenses();
        }
    }
}
