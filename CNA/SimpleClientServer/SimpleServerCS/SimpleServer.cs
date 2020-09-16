using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Net.Sockets;
using Packets;
using System.Runtime.Serialization.Formatters.Binary;
using System.Threading;
using System.Diagnostics;

namespace SimpleServerCS
{
    class SimpleServer
    {
        static Semaphore semaphoreObject;

        TcpListener _tcpListener;
        static List<Client> _clients = new List<Client>();

        public SimpleServer(string ipAddress, int port)
        {
            IPAddress ip = IPAddress.Parse(ipAddress);
            _tcpListener = new TcpListener(ip, port);
            semaphoreObject = new Semaphore(initialCount: 0, maximumCount: 1);
            semaphoreObject.Release();
        }

        public void Start()
        {
            _tcpListener.Start();

            Console.WriteLine("Listening...");

            while (true)
            {
                Socket socket = _tcpListener.AcceptSocket();
                Client client = new Client(socket);
                _clients.Add(client);
                client.Start();
            }
        }

        public void Stop()
        {
            foreach (Client client in _clients)
            {
                client.Stop();
            }

            _tcpListener.Stop();
        }

        public static void SocketMethod(Client client)
        {
            try
            {
                Socket socket = client.socket;
                NetworkStream stream = client.stream;
                BinaryReader reader = client.reader;
                BinaryFormatter formatter = new BinaryFormatter();

                int noOfIncomingBytes;
                while ((noOfIncomingBytes = reader.ReadInt32()) != 0)
                {
                    byte[] bytes = reader.ReadBytes(noOfIncomingBytes);

                    MemoryStream memoryStream = new MemoryStream(bytes);

                    Packet packet = formatter.Deserialize(memoryStream) as Packet;

                    switch (packet.type)
                    {
                        case PacketType.NICKNAME:
                            string nickName = ((NicknamePacket)packet).nickname;
                            client.nickname = nickName;
                            break;

                        case PacketType.CHATMESSAGE:
                            string message = ((ChatMessagePacket)packet).message;
                            foreach (Client c in _clients)
                            {
                                c.SendText(client, message);
                            }
                            break;

                        case PacketType.BUYPRODUCT:
                            String waitMessage = "Is buying... " + ((BuyProductPacket)packet).productType + "'s";
                            message = "Bought " + ((BuyProductPacket)packet).productType + "'s";

                            semaphoreObject.WaitOne();
                            foreach (Client c in _clients)
                            {
                                c.SendText(client, waitMessage);
                            }

                            Thread.Sleep(5000);

                            foreach (Client c in _clients)
                            {
                                c.SendText(client, message);
                            }
                            semaphoreObject.Release();
                            break;

                        case PacketType.SELLPRODUCT:
                            waitMessage = "Is selling... " + ((SellProductPacket)packet).productType + "'s";
                            message = "Sold " + ((SellProductPacket)packet).productType + "'s";

                            semaphoreObject.WaitOne();
                            foreach (Client c in _clients)
                            {
                                c.SendText(client, waitMessage);
                            }

                            Thread.Sleep(5000);

                            foreach (Client c in _clients)
                            {
                                c.SendText(client, message);
                            }
                            semaphoreObject.Release();
                            break;
                    }
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Error occured: " + e.Message);
            }
            finally
            {
                client.Stop();
            }
        }
    }
}
