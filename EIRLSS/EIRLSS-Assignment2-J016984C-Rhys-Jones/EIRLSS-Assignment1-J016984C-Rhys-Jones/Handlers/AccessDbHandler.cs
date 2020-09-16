using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using System;
using System.Collections.Generic;
using System.Data.Odbc;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers
{
    public class AccessDbHandler
    {
        public static List<FraudulentClaim> GetInsuranceFraudData()
        {
            string filePath = Path.Combine(Directory.GetCurrentDirectory(), "Files", "ABI_DRIVER_FRAUD1.accdb");
            string connectionString = @"Driver={Microsoft Access Driver (*.mdb, *.accdb)}; Dbq=" + filePath + ";";

            string queryString = "SELECT * FROM fraudulent_claim_data;";

            object[] columns = new object[7];
            FraudulentClaim fraudulentClaim;
            List<FraudulentClaim> listOfFraudulentClaims = new List<FraudulentClaim>();
            try
            {
                using (OdbcConnection connection = new OdbcConnection(connectionString))
                {
                    OdbcCommand command = new OdbcCommand(queryString, connection);

                    connection.Open();

                    OdbcDataReader reader = command.ExecuteReader();
                    while (reader.Read())
                    {
                        int numberOfColumns = reader.GetValues(columns);

                        fraudulentClaim = new FraudulentClaim();
                        fraudulentClaim.ID = (int)columns[0];
                        fraudulentClaim.FamilyName = (string)columns[1];
                        fraudulentClaim.Forenames = (string)columns[2];
                        fraudulentClaim.DateOfBirth = (DateTime)columns[3];
                        fraudulentClaim.AddressOfClaim = (string)columns[4];
                        fraudulentClaim.DateOfClaim = (DateTime)columns[5];
                        fraudulentClaim.InsurerCode = (int)columns[6];

                        listOfFraudulentClaims.Add(fraudulentClaim);
                    }

                    reader.Close();
                }

                return listOfFraudulentClaims;
            }
            catch(Exception e)
            {
                return null;
            }
            
        }
    }
}
