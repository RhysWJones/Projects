using Packets;
using System;
using System.IO;
using System.Net.Sockets;
using System.Runtime.Serialization.Formatters.Binary;
using System.Text;
using System.Threading;

namespace SimpleServerCS
{
    class Client
    {
        public Socket socket { get; set; }

        public String nickname { get; set; }

        private Thread thread { get; set; }

        public NetworkStream stream;
        public BinaryReader reader;
        public BinaryWriter writer;

        public Client(Socket socket)
        {
            this.socket = socket;
            stream = new NetworkStream(socket, true);
            reader = new BinaryReader(stream, Encoding.UTF8);
            writer = new BinaryWriter(stream, Encoding.UTF8);
        }

        public void Start()
        {
            thread = new Thread(new ThreadStart(SocketMethod));
            thread.Start();
        }

        public void Stop()
        {
            socket.Close();

            if (thread.IsAlive == true)
            {
                thread.Abort();
            }
        }

        private void SocketMethod()
        {
            SimpleServer.SocketMethod(this);
        }

        public void SendText(Client client, String receivedMessage)
        {
            if (!socket.Connected)
                return;

            string message = client.nickname + "==> " + receivedMessage;

            ChatMessagePacket chatMessagePacket = new ChatMessagePacket(message);
            Send(chatMessagePacket);
        }

        public void Send(Packet data)
        {
            MemoryStream mem = new MemoryStream();
            BinaryFormatter bf = new BinaryFormatter();
            bf.Serialize(mem, data);
            byte[] buffer = mem.GetBuffer();

            writer.Write(buffer.Length);
            writer.Write(buffer);
            writer.Flush();
        }
    }
}
