package Network;
import java.io.File;
import java.net.Inet4Address;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class NetworkManager {

    private static Set<Switch> switches = new HashSet<>();
    private static Set<Host> hosts = new HashSet<>();
    private static Set<Link> linkSet = new HashSet<>();


    public static void constructTopology(){
        //TODO:
        // reads a file which contains nodes and links information
        readSwitchesFromFile();
        readHostsFromFile();
    }
    public static Switch addNewSwitch(Switch newSwitch){
        //TODO:
        switches.add(newSwitch);
        return newSwitch;
    }
    public static Host addNewHost(Host newHost){
        //TODO:
        hosts.add(newHost);
        return newHost;
    }
    public static Link addLinkBetweenSwitchAndHost(Inet4Address switchAddress,Inet4Address hostAddress){
        //TODO:
        return null;
    }
    public static Link addLinkBetweenTwoSwitches(Inet4Address switch1,Inet4Address switch2){
        //TODO:
        return null;
    }

    private static void readSwitchesFromFile(){
        try{
        Scanner switches = new Scanner(new File("switches.txt"));
        while (switches.hasNextLine()){
           String line = switches.nextLine();
            String switchProperties[] = line.split(" ");
            String name = switchProperties[0];
            Inet4Address ipAddress = (Inet4Address) Inet4Address.getByName(switchProperties[1]);
            String dpid = switchProperties[2];
            Integer switchId = Integer.valueOf(switchProperties[0].substring(1));
            Switch newSwitch = new Switch(ipAddress,switchId,dpid,dpid);
            addNewSwitch(newSwitch);
            System.out.println(newSwitch);
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private static void readHostsFromFile(){
        try{
            Scanner hostsFile = new Scanner(new File("hosts.txt"));
            while (hostsFile.hasNextLine()){
                String line = hostsFile.nextLine();
                String hostsProperties[] = line.split(" ");
                String name = hostsProperties[0];
                Inet4Address ipAddress = (Inet4Address) Inet4Address.getByName(hostsProperties[1]);
                String mac = hostsProperties[2];
                Integer hostId = Integer.valueOf(hostsProperties[0].substring(1));
                Host newHost = new Host(ipAddress,name,hostId);
                addNewHost(newHost);
                System.out.println(newHost);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
