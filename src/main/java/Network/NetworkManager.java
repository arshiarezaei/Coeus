package Network;
import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class NetworkManager {

    private Set<Switch> switches = new HashSet<>();
    private Set<Host> hosts = new HashSet<>();
    private Set<Link> linkSet = new HashSet<>();


    public void constructTopology(){
        //TODO:
        // reads a file which contains nodes and links information
    }
    public Switch addNewSwitch(){
        //TODO:
        return null;
    }
    public Host addNewHost(){
        //TODO:
        return null;
    }
    public Link addLinkBetweenSwitchAndHost(Inet4Address switchAddress,Inet4Address hostAddress){
        //TODO:
        return null;
    }
    public Link addLinkBetweenTwoSwitches(Inet4Address switch1,Inet4Address switch2){
        //TODO:
        return null;
    }

}
