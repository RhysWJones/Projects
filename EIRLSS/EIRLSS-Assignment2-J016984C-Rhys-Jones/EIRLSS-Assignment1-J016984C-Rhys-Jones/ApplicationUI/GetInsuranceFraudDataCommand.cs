using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetInsuranceFraudDataCommand : ICommand
    {
        private AccessDbHandler AccessDbHandler;

        public GetInsuranceFraudDataCommand()
        {
            AccessDbHandler = new AccessDbHandler();
        }

        public async Task<object> Execute()
        {
            return AccessDbHandler.GetInsuranceFraudData();
        }
    }
}
