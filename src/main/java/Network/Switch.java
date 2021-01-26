package Network;

import java.net.Inet4Address;

public class Switch extends Node {

    private final Integer switchId;
    private static Integer firstAvailableSwitchId = 1;

    public Switch(Inet4Address ip, String name) {
        super(ip, name);
        this.switchId = firstAvailableSwitchId;
        firstAvailableSwitchId+=1;
    }

    public Switch(Inet4Address ip) {
        super(ip,"s"+firstAvailableSwitchId);
        this.switchId = firstAvailableSwitchId;
        firstAvailableSwitchId+=1;
    }

    public Integer getSwitchId() {
        return switchId;
    }

}
