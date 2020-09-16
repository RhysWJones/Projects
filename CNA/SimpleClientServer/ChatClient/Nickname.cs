using Packets;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net.Sockets;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Windows.Forms;

namespace ChatClient
{
    public partial class Nickname : Form
    {
        private BinaryWriter _writer;

        public Nickname(BinaryWriter writer)
        {
            InitializeComponent();
            _writer = writer;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String inputNickname;
            inputNickname = textBox1.Text;
            NicknamePacket nickname = new NicknamePacket(inputNickname);

            if (!nickname.Equals(String.Empty))
            {
                Send(nickname);
                this.Close();
            }
            else
            {
                label2.Text = "Enter a name!!";
            }
        }

        public void Send(Packet data)
        {
            MemoryStream mem = new MemoryStream();
            BinaryFormatter bf = new BinaryFormatter();
            bf.Serialize(mem, data);
            byte[] buffer = mem.GetBuffer();

            try
            {
                _writer.Write(buffer.Length);
                _writer.Write(buffer);
                _writer.Flush();
            }
            catch { }
        }
    }
}
