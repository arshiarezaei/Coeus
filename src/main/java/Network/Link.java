package Network;

import java.net.Inet4Address;

public class Link {

    private final Inet4Address node1Address;
    private final Inet4Address node2Address;
    private final Integer port1;
    private final Integer port2;
    private final Integer capacity;
    private Double delay;
    private Double loss;
    private Integer availableCapacity;

    public Link(Inet4Address node1Address, Inet4Address node2Address,
                Integer port1, Integer port2, Integer capacity,
                Double delay, Double loss) {
        this.node1Address = node1Address;
        this.node2Address = node2Address;
        this.port1 = port1;
        this.port2 = port2;
        this.capacity = capacity;
        this.delay = delay;
        this.loss = loss;
        this.availableCapacity = capacity;
    }

    public Inet4Address getNode1Address() {
        return node1Address;
    }

    public Inet4Address getNode2Address() {
        return node2Address;
    }

    public Integer getPort1() {
        return port1;
    }

    public Integer getPort2() {
        return port2;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Double getDelay() {
        return delay;
    }

    public Double getLoss() {
        return loss;
    }
}
