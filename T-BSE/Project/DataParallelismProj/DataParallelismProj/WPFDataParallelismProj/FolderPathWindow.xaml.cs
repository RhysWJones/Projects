using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Forms;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WPFDataParallelismProj
{
    /// <summary>
    /// Interaction logic for FolderPathWindow.xaml
    /// </summary>
    public partial class FolderPathWindow : Window
    {
        public String SelectedPath { get; set; }

        public FolderPathWindow()
        {
            InitializeComponent();
        }

        private void Browse_Button_Click(object sender, RoutedEventArgs e)
        {
            FolderBrowserDialog FBD = new FolderBrowserDialog();
            FBD.ShowDialog();
            Folder_Path_TextBox.Text = FBD.SelectedPath;
        }

        private void Submit_Button_Click(object sender, RoutedEventArgs e)
        {
            SelectedPath = Folder_Path_TextBox.Text;
            this.Close();
        }
    }
}
