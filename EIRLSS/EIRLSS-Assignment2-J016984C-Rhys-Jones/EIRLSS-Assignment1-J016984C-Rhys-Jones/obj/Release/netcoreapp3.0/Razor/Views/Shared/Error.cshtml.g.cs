#pragma checksum "F:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_1_J016984C_Rhys_Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\Error.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "e9b428d6abbdcb72b73ff607f90df9da0f39adf7"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared_Error), @"mvc.1.0.view", @"/Views/Shared/Error.cshtml")]
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
#line 1 "F:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_1_J016984C_Rhys_Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\_ViewImports.cshtml"
using EIRLSS_Assignment1_J016984C_Rhys_Jones;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "F:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_1_J016984C_Rhys_Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\_ViewImports.cshtml"
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"e9b428d6abbdcb72b73ff607f90df9da0f39adf7", @"/Views/Shared/Error.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"1756811d5024b337bc2c0b28793162543b200703", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared_Error : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<ErrorViewModel>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "F:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_1_J016984C_Rhys_Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\Error.cshtml"
  
    ViewData["Title"] = "Error";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<h1 class=\"text-danger\">Error.</h1>\r\n<h2 class=\"text-danger\">An error occurred while processing your request.</h2>\r\n\r\n");
#nullable restore
#line 9 "F:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_1_J016984C_Rhys_Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\Error.cshtml"
 if (Model.ShowRequestId)
{

#line default
#line hidden
#nullable disable
            WriteLiteral("    <p>\r\n        <strong>Request ID:</strong> <code>");
#nullable restore
#line 12 "F:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_1_J016984C_Rhys_Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\Error.cshtml"
                                      Write(Model.RequestId);

#line default
#line hidden
#nullable disable
            WriteLiteral("</code>\r\n    </p>\r\n");
#nullable restore
#line 14 "F:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_1_J016984C_Rhys_Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\Error.cshtml"
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
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<ErrorViewModel> Html { get; private set; }
    }
}
#pragma warning restore 1591
