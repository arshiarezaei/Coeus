package Flow;

import java.net.Inet4Address;
import java.util.LinkedList;

public class Flow {

    private final Integer flowId;
    private final Integer demand;
    private final Inet4Address srcIp;
    private final Inet4Address dstIp;
    private LinkedList<Inet4Address> currentPath = new LinkedList<>();//captures SwitchIps
    private LinkedList<Inet4Address> newPath = new LinkedList<>();
    private boolean isActive;
    private static  Integer firstAvailableFlowId;

    public Flow(Integer flowId, Integer demand, Inet4Address srcIp,
                Inet4Address dstIp, LinkedList<Inet4Address> currentPath,boolean isActive) {
        this.flowId = firstAvailableFlowId;
        this.demand = demand;
        this.srcIp = srcIp;
        this.dstIp = dstIp;
        this.currentPath = currentPath;
        this.isActive = isActive;
        firstAvailableFlowId+=1;
    }

    public Flow(Inet4Address srcIp, Inet4Address dstIp,Integer demand) {
        this.flowId = firstAvailableFlowId;
        this.demand = demand;
        this.srcIp = srcIp;
        this.dstIp = dstIp;
        this.isActive=false;
        firstAvailableFlowId+=1;
    }

    public Integer getFlowId() {
        return flowId;
    }

    public Integer getDemand() {
        return demand;
    }

    public Inet4Address getSrcIp() {
        return srcIp;
    }

    public Inet4Address getDstIp() {
        return dstIp;
    }

    public LinkedList<Inet4Address> getCurrentPath() {
        return currentPath;
    }

    public LinkedList<Inet4Address> getNewPath() {
        return newPath;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setNewPath(LinkedList<Inet4Address> newPath) {
        this.newPath = newPath;
    }

}
