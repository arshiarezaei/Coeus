package Network;

import java.net.Inet4Address;
import java.util.Dictionary;

abstract class Node {

    protected Inet4Address ip;
    protected String name;

    Node(Inet4Address ip, String name) {
        this.ip = ip;
        this.name = name;
    }

    Node(Inet4Address ip) {
        this.ip = ip;
        name = ip.getHostAddress();
    }

    public Inet4Address getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

}
