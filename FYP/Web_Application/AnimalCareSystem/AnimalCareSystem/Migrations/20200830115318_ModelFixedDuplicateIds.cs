using Microsoft.EntityFrameworkCore.Migrations;

namespace AnimalCareSystem.Migrations
{
    public partial class ModelFixedDuplicateIds : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Message_AspNetUsers_ReceivingUserId1",
                table: "Message");

            migrationBuilder.DropForeignKey(
                name: "FK_Message_AspNetUsers_SendingUserId1",
                table: "Message");

            migrationBuilder.DropForeignKey(
                name: "FK_UserReview_AspNetUsers_ReceivingUserId1",
                table: "UserReview");

            migrationBuilder.DropForeignKey(
                name: "FK_UserReview_AspNetUsers_ReviewingUserId1",
                table: "UserReview");

            migrationBuilder.DropIndex(
                name: "IX_UserReview_ReceivingUserId1",
                table: "UserReview");

            migrationBuilder.DropIndex(
                name: "IX_UserReview_ReviewingUserId1",
                table: "UserReview");

            migrationBuilder.DropIndex(
                name: "IX_Message_ReceivingUserId1",
                table: "Message");

            migrationBuilder.DropIndex(
                name: "IX_Message_SendingUserId1",
                table: "Message");

            migrationBuilder.DropColumn(
                name: "ReceivingUserId1",
                table: "UserReview");

            migrationBuilder.DropColumn(
                name: "ReviewingUserId1",
                table: "UserReview");

            migrationBuilder.DropColumn(
                name: "ReceivingUserId1",
                table: "Message");

            migrationBuilder.DropColumn(
                name: "SendingUserId1",
                table: "Message");

            migrationBuilder.AlterColumn<string>(
                name: "ReviewingUserId",
                table: "UserReview",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AlterColumn<string>(
                name: "ReceivingUserId",
                table: "UserReview",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AddColumn<string>(
                name: "Title",
                table: "UserReview",
                nullable: true);

            migrationBuilder.AlterColumn<string>(
                name: "SendingUserId",
                table: "Message",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AlterColumn<string>(
                name: "ReceivingUserId",
                table: "Message",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.CreateIndex(
                name: "IX_UserReview_ReceivingUserId",
                table: "UserReview",
                column: "ReceivingUserId");

            migrationBuilder.CreateIndex(
                name: "IX_UserReview_ReviewingUserId",
                table: "UserReview",
                column: "ReviewingUserId");

            migrationBuilder.CreateIndex(
                name: "IX_Message_ReceivingUserId",
                table: "Message",
                column: "ReceivingUserId");

            migrationBuilder.CreateIndex(
                name: "IX_Message_SendingUserId",
                table: "Message",
                column: "SendingUserId");

            migrationBuilder.AddForeignKey(
                name: "FK_Message_AspNetUsers_ReceivingUserId",
                table: "Message",
                column: "ReceivingUserId",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Message_AspNetUsers_SendingUserId",
                table: "Message",
                column: "SendingUserId",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.NoAction);

            migrationBuilder.AddForeignKey(
                name: "FK_UserReview_AspNetUsers_ReceivingUserId",
                table: "UserReview",
                column: "ReceivingUserId",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_UserReview_AspNetUsers_ReviewingUserId",
                table: "UserReview",
                column: "ReviewingUserId",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.NoAction);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Message_AspNetUsers_ReceivingUserId",
                table: "Message");

            migrationBuilder.DropForeignKey(
                name: "FK_Message_AspNetUsers_SendingUserId",
                table: "Message");

            migrationBuilder.DropForeignKey(
                name: "FK_UserReview_AspNetUsers_ReceivingUserId",
                table: "UserReview");

            migrationBuilder.DropForeignKey(
                name: "FK_UserReview_AspNetUsers_ReviewingUserId",
                table: "UserReview");

            migrationBuilder.DropIndex(
                name: "IX_UserReview_ReceivingUserId",
                table: "UserReview");

            migrationBuilder.DropIndex(
                name: "IX_UserReview_ReviewingUserId",
                table: "UserReview");

            migrationBuilder.DropIndex(
                name: "IX_Message_ReceivingUserId",
                table: "Message");

            migrationBuilder.DropIndex(
                name: "IX_Message_SendingUserId",
                table: "Message");

            migrationBuilder.DropColumn(
                name: "Title",
                table: "UserReview");

            migrationBuilder.AlterColumn<int>(
                name: "ReviewingUserId",
                table: "UserReview",
                type: "int",
                nullable: false,
                oldClrType: typeof(string));

            migrationBuilder.AlterColumn<int>(
                name: "ReceivingUserId",
                table: "UserReview",
                type: "int",
                nullable: false,
                oldClrType: typeof(string));

            migrationBuilder.AddColumn<string>(
                name: "ReceivingUserId1",
                table: "UserReview",
                type: "nvarchar(450)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "ReviewingUserId1",
                table: "UserReview",
                type: "nvarchar(450)",
                nullable: true);

            migrationBuilder.AlterColumn<int>(
                name: "SendingUserId",
                table: "Message",
                type: "int",
                nullable: false,
                oldClrType: typeof(string));

            migrationBuilder.AlterColumn<int>(
                name: "ReceivingUserId",
                table: "Message",
                type: "int",
                nullable: false,
                oldClrType: typeof(string));

            migrationBuilder.AddColumn<string>(
                name: "ReceivingUserId1",
                table: "Message",
                type: "nvarchar(450)",
                nullable: true);

            migrationBuilder.AddColumn<string>(
                name: "SendingUserId1",
                table: "Message",
                type: "nvarchar(450)",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_UserReview_ReceivingUserId1",
                table: "UserReview",
                column: "ReceivingUserId1");

            migrationBuilder.CreateIndex(
                name: "IX_UserReview_ReviewingUserId1",
                table: "UserReview",
                column: "ReviewingUserId1");

            migrationBuilder.CreateIndex(
                name: "IX_Message_ReceivingUserId1",
                table: "Message",
                column: "ReceivingUserId1");

            migrationBuilder.CreateIndex(
                name: "IX_Message_SendingUserId1",
                table: "Message",
                column: "SendingUserId1");

            migrationBuilder.AddForeignKey(
                name: "FK_Message_AspNetUsers_ReceivingUserId1",
                table: "Message",
                column: "ReceivingUserId1",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Message_AspNetUsers_SendingUserId1",
                table: "Message",
                column: "SendingUserId1",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_UserReview_AspNetUsers_ReceivingUserId1",
                table: "UserReview",
                column: "ReceivingUserId1",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_UserReview_AspNetUsers_ReviewingUserId1",
                table: "UserReview",
                column: "ReviewingUserId1",
                principalTable: "AspNetUsers",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
