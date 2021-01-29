package Network;

public class Rule {

    private final String srcIP;
    private final String dstIp;
    private final String outPort;
    private final String flowMod;

    public Rule(String srcIP, String dstIp, String outPort, String flowMod) {
        this.srcIP = srcIP;
        this.dstIp = dstIp;
        this.outPort = outPort;
        this.flowMod = flowMod;
    }
}
