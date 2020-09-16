using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers
{
    public class FileHandler
    {
        private String DVLAFilePath = Path.Combine(Directory.GetCurrentDirectory(), "Files", "dvla.csv");
        public FileHandler()
        {

        }

        public List<String> GetAllInvalidLicenses()
        {
            try
            {
                String[] invalidLicenses = File.ReadAllLines(DVLAFilePath);
                List<String> listOfInvalidLicenses = new List<String>(invalidLicenses);
                listOfInvalidLicenses.RemoveAt(0);

                return listOfInvalidLicenses;
            }
            catch(Exception e)
            {
                return null;
            }
            
        }

    }
}
