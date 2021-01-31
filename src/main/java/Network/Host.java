package Network;

import java.net.Inet4Address;

public class Host extends Node {

    private final Integer hostId;

    public Host(Inet4Address ip, String name,Integer hostId) {
        super(ip, name);
        this.hostId = hostId;
    }


    public Integer getHostId() {
        return hostId;
    }

    @Override
    public String toString() {
        return "h"+ hostId ;
    }
}
