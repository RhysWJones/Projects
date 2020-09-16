using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DataParallelismProj
{
    public partial class FilePathForm : Form
    {
        public String SelectedPath { get; set; }
        public FilePathForm()
        {
            InitializeComponent();
        }

        private void SubmitButton_Click(object sender, EventArgs e)
        {
            SelectedPath = textBox1.Text;
            this.Close();
        }

        private void BrowseButton_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog FBD = new FolderBrowserDialog();
            FBD.ShowDialog();
            textBox1.Text = FBD.SelectedPath;
        }
    }
}
