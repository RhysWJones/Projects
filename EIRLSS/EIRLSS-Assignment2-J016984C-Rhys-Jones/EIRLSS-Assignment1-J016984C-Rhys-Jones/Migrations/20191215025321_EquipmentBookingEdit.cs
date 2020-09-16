using Microsoft.EntityFrameworkCore.Migrations;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Migrations
{
    public partial class EquipmentBookingEdit : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_EquipmentBookings_Bookings_BookingId1",
                table: "EquipmentBookings");

            migrationBuilder.DropForeignKey(
                name: "FK_EquipmentBookings_Equipment_EquipmentId1",
                table: "EquipmentBookings");

            migrationBuilder.DropIndex(
                name: "IX_EquipmentBookings_BookingId1",
                table: "EquipmentBookings");

            migrationBuilder.DropIndex(
                name: "IX_EquipmentBookings_EquipmentId1",
                table: "EquipmentBookings");

            migrationBuilder.DropColumn(
                name: "BookingId1",
                table: "EquipmentBookings");

            migrationBuilder.DropColumn(
                name: "EquipmentId1",
                table: "EquipmentBookings");

            migrationBuilder.AlterColumn<long>(
                name: "EquipmentId",
                table: "EquipmentBookings",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AlterColumn<long>(
                name: "BookingId",
                table: "EquipmentBookings",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AddColumn<int>(
                name: "Count",
                table: "EquipmentBookings",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.CreateIndex(
                name: "IX_EquipmentBookings_BookingId",
                table: "EquipmentBookings",
                column: "BookingId");

            migrationBuilder.CreateIndex(
                name: "IX_EquipmentBookings_EquipmentId",
                table: "EquipmentBookings",
                column: "EquipmentId");

            migrationBuilder.AddForeignKey(
                name: "FK_EquipmentBookings_Bookings_BookingId",
                table: "EquipmentBookings",
                column: "BookingId",
                principalTable: "Bookings",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_EquipmentBookings_Equipment_EquipmentId",
                table: "EquipmentBookings",
                column: "EquipmentId",
                principalTable: "Equipment",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_EquipmentBookings_Bookings_BookingId",
                table: "EquipmentBookings");

            migrationBuilder.DropForeignKey(
                name: "FK_EquipmentBookings_Equipment_EquipmentId",
                table: "EquipmentBookings");

            migrationBuilder.DropIndex(
                name: "IX_EquipmentBookings_BookingId",
                table: "EquipmentBookings");

            migrationBuilder.DropIndex(
                name: "IX_EquipmentBookings_EquipmentId",
                table: "EquipmentBookings");

            migrationBuilder.DropColumn(
                name: "Count",
                table: "EquipmentBookings");

            migrationBuilder.AlterColumn<int>(
                name: "EquipmentId",
                table: "EquipmentBookings",
                type: "int",
                nullable: false,
                oldClrType: typeof(long),
                oldNullable: true);

            migrationBuilder.AlterColumn<int>(
                name: "BookingId",
                table: "EquipmentBookings",
                type: "int",
                nullable: false,
                oldClrType: typeof(long),
                oldNullable: true);

            migrationBuilder.AddColumn<long>(
                name: "BookingId1",
                table: "EquipmentBookings",
                type: "bigint",
                nullable: true);

            migrationBuilder.AddColumn<long>(
                name: "EquipmentId1",
                table: "EquipmentBookings",
                type: "bigint",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_EquipmentBookings_BookingId1",
                table: "EquipmentBookings",
                column: "BookingId1");

            migrationBuilder.CreateIndex(
                name: "IX_EquipmentBookings_EquipmentId1",
                table: "EquipmentBookings",
                column: "EquipmentId1");

            migrationBuilder.AddForeignKey(
                name: "FK_EquipmentBookings_Bookings_BookingId1",
                table: "EquipmentBookings",
                column: "BookingId1",
                principalTable: "Bookings",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_EquipmentBookings_Equipment_EquipmentId1",
                table: "EquipmentBookings",
                column: "EquipmentId1",
                principalTable: "Equipment",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
