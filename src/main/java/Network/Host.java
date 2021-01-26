package Network;

import java.net.Inet4Address;

public class Host extends Node {

    private final Integer hostId;
    private static Integer firstAvailableHostId = 1;

    public Host(Inet4Address ip, String name) {
        super(ip, name);
        hostId = firstAvailableHostId;
        firstAvailableHostId+=1;
    }

    public Host(Inet4Address ip) {
        super(ip,"h"+firstAvailableHostId);
        hostId = firstAvailableHostId;
        firstAvailableHostId+=1;
    }

    public Integer getHostId() {
        return hostId;
    }

}
