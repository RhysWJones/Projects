#pragma checksum "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\_MessageDisplayPartial.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "7f0adae9221e5d0f29c28d7eec0da08c11e5646c"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Shared__MessageDisplayPartial), @"mvc.1.0.view", @"/Views/Shared/_MessageDisplayPartial.cshtml")]
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
#line 1 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\_ViewImports.cshtml"
using EIRLSS_Assignment1_J016984C_Rhys_Jones;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\_ViewImports.cshtml"
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"7f0adae9221e5d0f29c28d7eec0da08c11e5646c", @"/Views/Shared/_MessageDisplayPartial.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"1756811d5024b337bc2c0b28793162543b200703", @"/Views/_ViewImports.cshtml")]
    public class Views_Shared__MessageDisplayPartial : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<dynamic>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\r\n");
#nullable restore
#line 2 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\_MessageDisplayPartial.cshtml"
 if (TempData["successmessage"] != null)
{

#line default
#line hidden
#nullable disable
            WriteLiteral("    <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n        <h4 class=\"alert-heading\">Success!</h4>\r\n        <p class=\"mb-0\">");
#nullable restore
#line 6 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\_MessageDisplayPartial.cshtml"
                   Write(TempData["successmessage"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</p>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n    </div>\r\n");
#nullable restore
#line 11 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\_MessageDisplayPartial.cshtml"
}

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n\r\n");
#nullable restore
#line 14 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\_MessageDisplayPartial.cshtml"
 if (TempData["errormessage"] != null)
{

#line default
#line hidden
#nullable disable
            WriteLiteral("    <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\r\n        <h4 class=\"alert-heading\">Error!</h4>\r\n        <p class=\"mb-0\">");
#nullable restore
#line 18 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\_MessageDisplayPartial.cshtml"
                   Write(TempData["errormessage"]);

#line default
#line hidden
#nullable disable
            WriteLiteral("</p>\r\n        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n            <span aria-hidden=\"true\">&times;</span>\r\n        </button>\r\n    </div>\r\n");
#nullable restore
#line 23 "H:\UNI-LEVEL_6\EIRLSS\EIRLSS_Assignment_2_J016984C_Rhys_Jones\EIRLSS-Assignment2-J016984C-Rhys-Jones\EIRLSS-Assignment1-J016984C-Rhys-Jones\Views\Shared\_MessageDisplayPartial.cshtml"
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
