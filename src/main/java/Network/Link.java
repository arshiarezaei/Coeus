package Network;

import java.net.Inet4Address;

public class Link {

    protected final Inet4Address node1Address;
    protected final Inet4Address node2Address;
    protected final Integer node1Port;
    protected final Integer node2Port;
    protected final Integer capacity;
    protected Double delay;
    protected Double loss;
    protected Integer availableCapacity;

    public Link(Inet4Address node1Address, Inet4Address node2Address,
                Integer node1Port, Integer node2Port, Integer capacity,
                Double delay, Double loss) {
        this.node1Address = node1Address;
        this.node2Address = node2Address;
        this.node1Port = node1Port;
        this.node2Port = node2Port;
        this.capacity = capacity;
        this.delay = delay;
        this.loss = loss;
        this.availableCapacity = capacity;
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

    public Integer getAvailableCapacity() {
        return availableCapacity;
    }
    public Integer consumeLink(Integer amount){
        // TODO: handle link over-subscription
        availableCapacity -= amount;
        return availableCapacity;
    }
    public Integer releaseLink(Integer amount){
        availableCapacity += amount;
        return availableCapacity;
    }
}
