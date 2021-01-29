package Network;

import java.net.Inet4Address;

public class UniDirectionalLink extends Link{

    public UniDirectionalLink(Inet4Address srcIp, Inet4Address dstIp,
                              Integer srcPort, Integer dstPort,
                              Integer capacity, Double delay, Double loss) {
        super(srcIp, dstIp, srcPort, dstPort, capacity, delay, loss);
    }

    public Inet4Address getSrcIp(){
        return  node1Address;
    }
    public Inet4Address getDstIp(){
        return node2Address;
    }
    public Integer getSrcPort(){
        return node1Port;
    }
    public Integer getDstPort(){
        return node2Port;
    }

}
