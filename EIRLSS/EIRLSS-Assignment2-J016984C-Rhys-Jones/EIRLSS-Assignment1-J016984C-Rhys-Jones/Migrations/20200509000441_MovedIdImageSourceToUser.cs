using Microsoft.EntityFrameworkCore.Migrations;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Migrations
{
    public partial class MovedIdImageSourceToUser : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "IdentificationFolderSource",
                table: "Bookings");

            migrationBuilder.AddColumn<string>(
                name: "IdentificationFolderSource",
                table: "AspNetUsers",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "IdentificationFolderSource",
                table: "AspNetUsers");

            migrationBuilder.AddColumn<string>(
                name: "IdentificationFolderSource",
                table: "Bookings",
                type: "nvarchar(max)",
                nullable: true);
        }
    }
}
