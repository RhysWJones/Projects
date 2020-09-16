using Microsoft.EntityFrameworkCore.Migrations;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Migrations
{
    public partial class AddUserLicenseNumber : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "LicenseNumber",
                table: "AspNetUsers",
                maxLength: 16,
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "LicenseNumber",
                table: "AspNetUsers");
        }
    }
}
