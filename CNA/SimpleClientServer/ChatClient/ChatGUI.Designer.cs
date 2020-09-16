namespace ChatClient
{
    partial class ChatGUI
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.sendMessageButton = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.buyApple = new System.Windows.Forms.Button();
            this.buyPear = new System.Windows.Forms.Button();
            this.buyBanana = new System.Windows.Forms.Button();
            this.buyPlum = new System.Windows.Forms.Button();
            this.buyOrange = new System.Windows.Forms.Button();
            this.buyPeach = new System.Windows.Forms.Button();
            this.sellApple = new System.Windows.Forms.Button();
            this.sellPear = new System.Windows.Forms.Button();
            this.sellBanana = new System.Windows.Forms.Button();
            this.sellPlum = new System.Windows.Forms.Button();
            this.sellOrange = new System.Windows.Forms.Button();
            this.sellPeach = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // sendMessageButton
            // 
            this.sendMessageButton.BackColor = System.Drawing.Color.Transparent;
            this.sendMessageButton.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.sendMessageButton.Location = new System.Drawing.Point(251, 260);
            this.sendMessageButton.Name = "sendMessageButton";
            this.sendMessageButton.Size = new System.Drawing.Size(75, 20);
            this.sendMessageButton.TabIndex = 0;
            this.sendMessageButton.Text = "Send";
            this.sendMessageButton.UseVisualStyleBackColor = false;
            this.sendMessageButton.Click += new System.EventHandler(this.sendMessageButton_Click);
            // 
            // textBox1
            // 
            this.textBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBox1.Location = new System.Drawing.Point(12, 260);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(233, 20);
            this.textBox1.TabIndex = 1;
            // 
            // richTextBox1
            // 
            this.richTextBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.richTextBox1.Location = new System.Drawing.Point(12, 12);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.ReadOnly = true;
            this.richTextBox1.Size = new System.Drawing.Size(314, 242);
            this.richTextBox1.TabIndex = 2;
            this.richTextBox1.Text = "";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.SystemColors.Control;
            this.label1.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(332, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(57, 22);
            this.label1.TabIndex = 3;
            this.label1.Text = "Apple";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.SystemColors.Control;
            this.label2.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(332, 45);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 22);
            this.label2.TabIndex = 4;
            this.label2.Text = "Pear";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.SystemColors.Control;
            this.label3.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(332, 78);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(73, 22);
            this.label3.TabIndex = 5;
            this.label3.Text = "Banana";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.BackColor = System.Drawing.SystemColors.Control;
            this.label4.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(332, 111);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(52, 22);
            this.label4.TabIndex = 6;
            this.label4.Text = "Plum";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.BackColor = System.Drawing.SystemColors.Control;
            this.label5.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(332, 144);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(72, 22);
            this.label5.TabIndex = 7;
            this.label5.Text = "Orange";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.SystemColors.Control;
            this.label6.Font = new System.Drawing.Font("Times New Roman", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(332, 177);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(60, 22);
            this.label6.TabIndex = 8;
            this.label6.Text = "Peach";
            // 
            // buyApple
            // 
            this.buyApple.Location = new System.Drawing.Point(410, 12);
            this.buyApple.Name = "buyApple";
            this.buyApple.Size = new System.Drawing.Size(75, 23);
            this.buyApple.TabIndex = 9;
            this.buyApple.Text = "Buy";
            this.buyApple.UseVisualStyleBackColor = true;
            this.buyApple.Click += new System.EventHandler(this.buyApple_Click);
            // 
            // buyPear
            // 
            this.buyPear.Location = new System.Drawing.Point(410, 45);
            this.buyPear.Name = "buyPear";
            this.buyPear.Size = new System.Drawing.Size(75, 23);
            this.buyPear.TabIndex = 10;
            this.buyPear.Text = "Buy";
            this.buyPear.UseVisualStyleBackColor = true;
            this.buyPear.Click += new System.EventHandler(this.buyPear_Click);
            // 
            // buyBanana
            // 
            this.buyBanana.Location = new System.Drawing.Point(410, 79);
            this.buyBanana.Name = "buyBanana";
            this.buyBanana.Size = new System.Drawing.Size(75, 23);
            this.buyBanana.TabIndex = 11;
            this.buyBanana.Text = "Buy";
            this.buyBanana.UseVisualStyleBackColor = true;
            this.buyBanana.Click += new System.EventHandler(this.buyBanana_Click);
            // 
            // buyPlum
            // 
            this.buyPlum.Location = new System.Drawing.Point(410, 111);
            this.buyPlum.Name = "buyPlum";
            this.buyPlum.Size = new System.Drawing.Size(75, 23);
            this.buyPlum.TabIndex = 12;
            this.buyPlum.Text = "Buy";
            this.buyPlum.UseVisualStyleBackColor = true;
            this.buyPlum.Click += new System.EventHandler(this.buyPlum_Click);
            // 
            // buyOrange
            // 
            this.buyOrange.Location = new System.Drawing.Point(410, 144);
            this.buyOrange.Name = "buyOrange";
            this.buyOrange.Size = new System.Drawing.Size(75, 23);
            this.buyOrange.TabIndex = 13;
            this.buyOrange.Text = "Buy";
            this.buyOrange.UseVisualStyleBackColor = true;
            this.buyOrange.Click += new System.EventHandler(this.buyOrange_Click);
            // 
            // buyPeach
            // 
            this.buyPeach.Location = new System.Drawing.Point(410, 177);
            this.buyPeach.Name = "buyPeach";
            this.buyPeach.Size = new System.Drawing.Size(75, 23);
            this.buyPeach.TabIndex = 14;
            this.buyPeach.Text = "Buy";
            this.buyPeach.UseVisualStyleBackColor = true;
            this.buyPeach.Click += new System.EventHandler(this.buyPeach_Click);
            // 
            // sellApple
            // 
            this.sellApple.Location = new System.Drawing.Point(491, 12);
            this.sellApple.Name = "sellApple";
            this.sellApple.Size = new System.Drawing.Size(75, 23);
            this.sellApple.TabIndex = 15;
            this.sellApple.Text = "Sell";
            this.sellApple.UseVisualStyleBackColor = true;
            this.sellApple.Click += new System.EventHandler(this.sellApple_Click);
            // 
            // sellPear
            // 
            this.sellPear.Location = new System.Drawing.Point(491, 45);
            this.sellPear.Name = "sellPear";
            this.sellPear.Size = new System.Drawing.Size(75, 23);
            this.sellPear.TabIndex = 16;
            this.sellPear.Text = "Sell";
            this.sellPear.UseVisualStyleBackColor = true;
            this.sellPear.Click += new System.EventHandler(this.sellPear_Click);
            // 
            // sellBanana
            // 
            this.sellBanana.Location = new System.Drawing.Point(491, 79);
            this.sellBanana.Name = "sellBanana";
            this.sellBanana.Size = new System.Drawing.Size(75, 23);
            this.sellBanana.TabIndex = 17;
            this.sellBanana.Text = "Sell";
            this.sellBanana.UseVisualStyleBackColor = true;
            this.sellBanana.Click += new System.EventHandler(this.sellBanana_Click);
            // 
            // sellPlum
            // 
            this.sellPlum.Location = new System.Drawing.Point(491, 111);
            this.sellPlum.Name = "sellPlum";
            this.sellPlum.Size = new System.Drawing.Size(75, 23);
            this.sellPlum.TabIndex = 18;
            this.sellPlum.Text = "Sell";
            this.sellPlum.UseVisualStyleBackColor = true;
            this.sellPlum.Click += new System.EventHandler(this.sellPlum_Click);
            // 
            // sellOrange
            // 
            this.sellOrange.Location = new System.Drawing.Point(491, 144);
            this.sellOrange.Name = "sellOrange";
            this.sellOrange.Size = new System.Drawing.Size(75, 23);
            this.sellOrange.TabIndex = 19;
            this.sellOrange.Text = "Sell";
            this.sellOrange.UseVisualStyleBackColor = true;
            this.sellOrange.Click += new System.EventHandler(this.sellOrange_Click);
            // 
            // sellPeach
            // 
            this.sellPeach.Location = new System.Drawing.Point(491, 177);
            this.sellPeach.Name = "sellPeach";
            this.sellPeach.Size = new System.Drawing.Size(75, 23);
            this.sellPeach.TabIndex = 20;
            this.sellPeach.Text = "Sell";
            this.sellPeach.UseVisualStyleBackColor = true;
            this.sellPeach.Click += new System.EventHandler(this.sellPeach_Click);
            // 
            // ChatGUI
            // 
            this.AcceptButton = this.sendMessageButton;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(779, 292);
            this.Controls.Add(this.sellPeach);
            this.Controls.Add(this.sellOrange);
            this.Controls.Add(this.sellPlum);
            this.Controls.Add(this.sellBanana);
            this.Controls.Add(this.sellPear);
            this.Controls.Add(this.sellApple);
            this.Controls.Add(this.buyPeach);
            this.Controls.Add(this.buyOrange);
            this.Controls.Add(this.buyPlum);
            this.Controls.Add(this.buyBanana);
            this.Controls.Add(this.buyPear);
            this.Controls.Add(this.buyApple);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.richTextBox1);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.sendMessageButton);
            this.Name = "ChatGUI";
            this.Text = "Stock Exchange";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.Form1_FormClosing);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button sendMessageButton;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.RichTextBox richTextBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button buyApple;
        private System.Windows.Forms.Button buyPear;
        private System.Windows.Forms.Button buyBanana;
        private System.Windows.Forms.Button buyPlum;
        private System.Windows.Forms.Button buyOrange;
        private System.Windows.Forms.Button buyPeach;
        private System.Windows.Forms.Button sellApple;
        private System.Windows.Forms.Button sellPear;
        private System.Windows.Forms.Button sellBanana;
        private System.Windows.Forms.Button sellPlum;
        private System.Windows.Forms.Button sellOrange;
        private System.Windows.Forms.Button sellPeach;
    }
}

