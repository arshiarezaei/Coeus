package Network;

import java.net.Inet4Address;

public class BidirectionalLink extends Link{

    public BidirectionalLink(Inet4Address node1Address, Inet4Address node2Address,
                             Integer node1Port, Integer node2Port, Integer capacity,
                             Double delay, Double loss) {
        super(node1Address, node2Address, node1Port, node2Port, capacity, delay, loss);
    }

    public BidirectionalLink(Inet4Address node1Address, Inet4Address node2Address,
                             Integer node1Port, Integer node2Port, Integer capacity) {
        super(node1Address, node2Address, node1Port, node2Port, capacity);
    }

    public Inet4Address getNode1Address() {
        return node1Address;
    }

    public Inet4Address getNode2Address() {
        return node2Address;
    }

    public Integer getNode1Port() {
        return node1Port;
    }

    public Integer getNode2Port() {
        return node2Port;
    }
}
