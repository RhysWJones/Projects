using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Packets
{
    [Serializable]
    public class NicknamePacket : Packet
    {
        public String nickname { get; protected set; }

        public NicknamePacket(String nickname)
        {
            this.type = PacketType.NICKNAME;
            this.nickname = nickname;
        }
    }
}
