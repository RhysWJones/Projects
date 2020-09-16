using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Packets
{
    [Serializable]
    public class SellProductPacket : Packet
    {
        public String productType { get; protected set; }

        public SellProductPacket(String productType)
        {
            this.type = PacketType.SELLPRODUCT;
            this.productType = productType;
        }
    }
}
