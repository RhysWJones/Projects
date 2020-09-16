using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetAllEquipmentCommand : ICommand
    {
        private EquipmentHandler EquipmentHandler;

        public GetAllEquipmentCommand(ApplicationDbContext dbContext)
        {
            EquipmentHandler = new EquipmentHandler(dbContext);
        }

        public async Task<object> Execute()
        {
            return await EquipmentHandler.GetAllEquipment();
        }
    }
}
