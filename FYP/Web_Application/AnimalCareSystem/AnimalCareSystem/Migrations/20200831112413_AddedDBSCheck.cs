using Microsoft.EntityFrameworkCore.Migrations;

namespace AnimalCareSystem.Migrations
{
    public partial class AddedDBSCheck : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "DBSCheckFileSource",
                table: "AspNetUsers",
                nullable: true);

            migrationBuilder.AddColumn<bool>(
                name: "DBSChecked",
                table: "AspNetUsers",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "DBSCheckFileSource",
                table: "AspNetUsers");

            migrationBuilder.DropColumn(
                name: "DBSChecked",
                table: "AspNetUsers");
        }
    }
}
