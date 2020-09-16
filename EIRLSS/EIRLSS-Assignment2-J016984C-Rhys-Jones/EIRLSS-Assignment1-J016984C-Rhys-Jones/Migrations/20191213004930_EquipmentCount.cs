using Microsoft.EntityFrameworkCore.Migrations;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Migrations
{
    public partial class EquipmentCount : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "Count",
                table: "Equipment",
                nullable: false,
                defaultValue: 0);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Count",
                table: "Equipment");
        }
    }
}
