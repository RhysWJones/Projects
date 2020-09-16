using Microsoft.EntityFrameworkCore.Migrations;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Migrations
{
    public partial class UpdateUserBlacklist : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<bool>(
                name: "Blacklisted",
                table: "AspNetUsers",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Blacklisted",
                table: "AspNetUsers");
        }
    }
}
