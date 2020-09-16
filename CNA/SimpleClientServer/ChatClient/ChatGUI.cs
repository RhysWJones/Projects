using System;
using System.Text;
using System.Threading;
using System.Net.Sockets;
using System.Windows.Forms;
using System.IO;
using Packets;
using System.Runtime.Serialization.Formatters.Binary;

namespace ChatClient
{
    public partial class ChatGUI : Form
    {
        private Thread thread { get; set; }
        private TcpClient _tcpClient;
        private NetworkStream _stream;
        private BinaryReader _reader;
        private const string hostname = "127.0.0.1";
        private const int port = 4444;
        private BinaryWriter _writer;

        public ChatGUI()
        {
            InitializeComponent();
            _tcpClient = new TcpClient();

            if (Connect(hostname, port))
            {
                richTextBox1.Text += ("Connected... \n");
                try
                {
                    Run();
                }
                catch (NotConnectedException e)
                {
                    richTextBox1.Text += ("Client not Connected \n");
                }
            }
            else
            {
                richTextBox1.Text += ("Failed to connect to: " + hostname + ":" + port + "\n");
            }
            Console.Read();
        }

        public bool Connect(string hostname, int port)
        {
            try
            {

                _tcpClient.Connect(hostname, port);
                _stream = _tcpClient.GetStream();
                _writer = new BinaryWriter(_stream, Encoding.UTF8);
                _reader = new BinaryReader(_stream, Encoding.UTF8);
            }
            catch (Exception e)
            {
                richTextBox1.Text += ("Exception: " + e.Message);
                return false;
            }

            return true;
        }

        public void Run()
        {
            if (!_tcpClient.Connected) throw new NotConnectedException();

            nicknameForm();

            thread = new Thread(new ThreadStart(ProcessServerResponse));
            thread.Start();
        }

        private void ProcessServerResponse()
        {
            try
            {
                BinaryFormatter formatter = new BinaryFormatter();

                // Read the number of incoming bytes
                int noOfIncomingBytes;
                while ((noOfIncomingBytes = _reader.ReadInt32()) != 0)
                {
                    // Read the bytes for noOfIncomingBytes amount
                    byte[] bytes = _reader.ReadBytes(noOfIncomingBytes);

                    //Store the bytes in a MemoryStream
                    MemoryStream memoryStream = new MemoryStream(bytes);

                    Packet packet = formatter.Deserialize(memoryStream) as Packet;

                    switch (packet.type)
                    {
                        case PacketType.CHATMESSAGE:
                            string message = ((ChatMessagePacket)packet).message;
                            addMessage(message);
                            break;
                    }
                }
            }
            catch { }
        }

        public void addMessage(String value)
        {
            if (InvokeRequired)
            {
                //This is only called if AddMessage() is called from another thread than the GUI thread.
                richTextBox1.Invoke((MethodInvoker)delegate { richTextBox1.Text += value + "\n"; });
                return;
            }
            //This is only called if you are calling this method from the thread the richTextBox belongs to.
            richTextBox1.Text = value;
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
            catch (IOException ioe)
            {
                thread.Abort();
                _tcpClient.Close();
            }
        }

        private void nicknameForm()
        {
            Nickname nicknameEntry = new Nickname(_writer);
            nicknameEntry.ShowDialog();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            thread.Abort();
            _tcpClient.Close();
        }

        private void sendMessageButton_Click(object sender, EventArgs e)
        {
            string userInput = textBox1.Text;
            ChatMessagePacket chatMessage = new ChatMessagePacket(userInput);
            textBox1.Text = "";
            if (userInput.Trim() != String.Empty)
            {
                try
                {
                    Send(chatMessage);
                }
                catch (Exception exc)
                {
                    richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
                }
            }
        }

        //Buy Buttons
        private void buyApple_Click(object sender, EventArgs e)
        {
            string productType = "apple";
            BuyProductPacket product = new BuyProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
            buyApple.Enabled = false;
        }

        private void buyPear_Click(object sender, EventArgs e)
        {
            string productType = "pear";
            BuyProductPacket product = new BuyProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void buyBanana_Click(object sender, EventArgs e)
        {
            string productType = "banana";
            BuyProductPacket product = new BuyProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void buyPlum_Click(object sender, EventArgs e)
        {
            string productType = "plum";
            BuyProductPacket product = new BuyProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void buyOrange_Click(object sender, EventArgs e)
        {
            string productType = "orange";
            BuyProductPacket product = new BuyProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void buyPeach_Click(object sender, EventArgs e)
        {
            string productType = "peach";
            BuyProductPacket product = new BuyProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        //Sell buttons
        private void sellApple_Click(object sender, EventArgs e)
        {
            string productType = "apple";
            SellProductPacket product = new SellProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void sellPear_Click(object sender, EventArgs e)
        {
            string productType = "pear";
            SellProductPacket product = new SellProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void sellBanana_Click(object sender, EventArgs e)
        {
            string productType = "banana";
            SellProductPacket product = new SellProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void sellPlum_Click(object sender, EventArgs e)
        {
            string productType = "plum";
            SellProductPacket product = new SellProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void sellOrange_Click(object sender, EventArgs e)
        {
            string productType = "orange";
            SellProductPacket product = new SellProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }

        private void sellPeach_Click(object sender, EventArgs e)
        {
            string productType = "peach";
            SellProductPacket product = new SellProductPacket(productType);
            try
            {
                Send(product);
            }
            catch (Exception exc)
            {
                richTextBox1.Text += ("Unexpected Error: " + exc.Message + "\n");
            }
        }
    }
}
