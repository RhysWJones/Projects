using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using DataParallelismProj.CommandsFactory;

namespace DataParallelismProj
{
    public partial class Form1 : Form
    {
        FilePathForm FPF = new FilePathForm();

        public Form1()
        {
            InitializeComponent();

            FPF.ShowDialog();
            richTextBox1.Text = FPF.SelectedPath;
        }

        private void Load_Data_Button_MouseClick(object sender, MouseEventArgs e)
        {
            Stopwatch stopWatch = new Stopwatch();
            stopWatch.Start();

            bool loaded = false;
            Task t1 = new Task(() =>
            {
                CommandFactory commandFactory = new CommandFactory();
                loaded = (bool)commandFactory.CreateCommand(3, FPF.SelectedPath).Execute();

                stopWatch.Stop();

                Invoke(new MethodInvoker(() =>
            {
                if (loaded)
                {
                    richTextBox1.Text += "\nLoaded successfully";
                    richTextBox1.Text += "\nTimeToLoad: " + stopWatch.Elapsed.TotalSeconds;
                    Application.DoEvents();
                }
            }));

            });

            t1.Start();

            //Task.WaitAny(t1);



            //if (loaded)
            //{
            //    richTextBox1.Text += "\nLoaded successfully";
            //}
            //richTextBox1.Text += "\nTimeToLoad: " + stopWatch.Elapsed.TotalSeconds;

            Load_Data_Button.Text = "Reload Data";
        }
    }
}
