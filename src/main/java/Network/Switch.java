package Network;

import java.net.Inet4Address;
import java.util.*;


public class Switch extends Node {

    private final Integer switchId;
    private final String dpid;
    private final String macAddress;

    private Dictionary<Integer,UniDirectionalLink> inputLinks = new Hashtable<>();
    private Dictionary<Integer,UniDirectionalLink> outputLinks = new Hashtable<>();
    private Dictionary<Integer,BidirectionalLink> bidirectionalLinks = new Hashtable<>();

    private Set<Rule> flowTable = new HashSet<>();

    public Switch(Inet4Address ip, Integer switchId, String dpid, String macAddress) {
        super(ip,"s"+switchId);
        this.switchId = switchId;
        this.dpid = dpid;
        this.macAddress = macAddress;
    }

    public Integer getSwitchId() {
        return switchId;
    }

    public String getDpid() {
        return dpid;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public Set<Rule> getFlowTable() {
        return flowTable;
    }

    public void addNewInputLink(UniDirectionalLink link){
        // This switch is destination
        Integer port = link.getDstPort();
        inputLinks.put(port,link);
    }
    public void addNewOutputLink(UniDirectionalLink link){
        Integer port = link.getSrcPort();
        outputLinks.put(port,link);
    }

    public void addNewBidirectionalLink(BidirectionalLink link, Integer port){
        bidirectionalLinks.put(port,link);
    }

    public void removeLink(Integer port){
        //TODO: !
        inputLinks.remove(port);
        outputLinks.remove(port);
        bidirectionalLinks.remove(port);
    }

    public void addRulesToFlowTable(LinkedList<Rule> newRule){
        flowTable.addAll(newRule);
    }

    public void removeRuleFromFlowTable(Rule rule){
        flowTable.remove(rule);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "switchId=" + switchId +
                ", dpid='" + dpid + '\'' +
                ", macAddress='" + macAddress + '\'' +
                ", inputLinks=" + inputLinks +
                ", outputLinks=" + outputLinks +
                ", bidirectionalLinks=" + bidirectionalLinks +
                ", flowTable=" + flowTable +
                '}';
    }
}
