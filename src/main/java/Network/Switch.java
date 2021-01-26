package Network;

import java.net.Inet4Address;

public class Switch extends Node {

    private final Integer switchId;
    private final String DPId;
    private static Integer firstAvailableSwitchId = 1;

    public Switch(Inet4Address ip, String name,String DPId) {
        super(ip, name);
        this.switchId = firstAvailableSwitchId;
        this.DPId = DPId;
        firstAvailableSwitchId+=1;
    }

    public Switch(Inet4Address ip,String DPId) {
        super(ip,"s"+firstAvailableSwitchId);
        this.switchId = firstAvailableSwitchId;
        this.DPId = DPId;
        firstAvailableSwitchId+=1;
    }

    public Integer getSwitchId() {
        return switchId;
    }

}
