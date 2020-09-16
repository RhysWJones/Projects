using IronWebScraper;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ScreenScraper
{
    public class PriceMatchScraper : WebScraper
    {
        private string PriceMatchUrl;
        public string PriceString;
        public PriceMatchScraper(string priceMatchUrl)
        {
            PriceMatchUrl = priceMatchUrl;
        }
        public override void Init()
        {
            License.LicenseKey = "LicenseKey";
            this.LoggingLevel = WebScraper.LogLevel.All;
            string workingDirectory = Path.Combine(Directory.GetCurrentDirectory(), "Files\\ScrapedPriceData");
            this.WorkingDirectory = workingDirectory;
            this.Request(PriceMatchUrl, Parse);
        }

        public override void Parse(Response response)
        {
            foreach (var itemPrice in response.Css("[title~=GBP]"))
            {
                PriceString = itemPrice.TextContentClean;
            }
        }
    }
}
