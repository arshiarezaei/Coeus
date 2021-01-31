package Network;

import java.net.Inet4Address;

public class Host extends Node {

    private final Integer hostId;
    private Switch connectedSwitch;

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

    public void setConnectedSwitch(Switch connectedSwitch) {
        if(this.connectedSwitch==null){
            this.connectedSwitch = connectedSwitch;
        }
    }
}
