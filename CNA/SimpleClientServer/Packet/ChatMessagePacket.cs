using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Packets
{
    [Serializable]
    public class ChatMessagePacket : Packet
    {
        public String message { get; protected set; }

        public ChatMessagePacket(String message)
        {
            this.type = PacketType.CHATMESSAGE;
            this.message = message;
        }
    }
}
