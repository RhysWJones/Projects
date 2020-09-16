using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Packets
{
    [Serializable]
    public class BuyProductPacket : Packet
    {
        public String productType { get; protected set; }

        public BuyProductPacket(String productType)
        {
            this.type = PacketType.BUYPRODUCT;
            this.productType = productType;
        }
    }
}
