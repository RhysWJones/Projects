#pragma checksum "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "ebd46a3eca70bb49791af7a4f500226bf4c55455"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Account_ConfirmEmail), @"mvc.1.0.view", @"/Views/Account/ConfirmEmail.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\_ViewImports.cshtml"
using AnimalCareSystem;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\_ViewImports.cshtml"
using AnimalCareSystem.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\_ViewImports.cshtml"
using Microsoft.AspNetCore.Identity;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"ebd46a3eca70bb49791af7a4f500226bf4c55455", @"/Views/Account/ConfirmEmail.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"9d79fc17c5224fc78fea522f9686621b472a2265", @"/Views/_ViewImports.cshtml")]
    public class Views_Account_ConfirmEmail : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<dynamic>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 1 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
  
    ViewData["Title"] = "Confirm email";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<h1>");
#nullable restore
#line 5 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
Write(ViewData["Title"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</h1>\r\n");
#nullable restore
#line 6 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
 if (TempData["emailconfirmed"] != null)
{

#line default
#line hidden
#nullable disable
            WriteLiteral("    <p>");
#nullable restore
#line 8 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
  Write(TempData["emailconfirmed"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</p>\r\n");
#nullable restore
#line 9 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
}

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n");
#nullable restore
#line 11 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
 if (TempData["emailconfirmerror"] != null)
{

#line default
#line hidden
#nullable disable
            WriteLiteral("    <p>");
#nullable restore
#line 13 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
  Write(TempData["emailconfirmerror"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</p>\r\n");
#nullable restore
#line 14 "H:\UNI-LEVEL_6\FYP\FYP_Implementation\Web_Application\AnimalCareSystem\AnimalCareSystem\Views\Account\ConfirmEmail.cshtml"
}

#line default
#line hidden
#nullable disable
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<dynamic> Html { get; private set; }
    }
}
#pragma warning restore 1591
