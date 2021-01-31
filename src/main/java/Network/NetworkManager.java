package Network;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.junit.AfterClass;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.Inet4Address;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import static org.junit.Assert.assertTrue;


public class NetworkManager {

    private static Set<Switch> switches = new HashSet<>();
    private static Set<Host> hosts = new HashSet<>();
    private static Set<Link> linkSet = new HashSet<>();


    public static void constructTopology(){
        //TODO:
        // reads a file which contains nodes and links information
        readSwitchesFromFile();
        readHostsFromFile();
        LinkedList<Link> newLinks = readLinksFromFile();
        linkSet.addAll(newLinks);
        visualizeNetwork();
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
            Scanner hostsFile = new Scanner(new File("host.txt"));
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
    private static LinkedList<Link> readLinksFromFile(){
        LinkedList<Link> newLinks = new LinkedList<>();
        try {
            Scanner linksFile = new Scanner(new File("links.txt"));
            while (linksFile.hasNextLine()) {
                String line = linksFile.nextLine();
                line = line.replaceAll("<","");
                line = line.replaceAll(">","");
//                System.out.println(line);
                String[] linkProperties = line.split("-");
//                for (String s:linkProperties) {
//                    System.out.println(s);
//                }
                // first node properties
                Integer firsNodeSwitchId = Integer.valueOf(linkProperties[0].replace("s",""));
                Integer firstNodePort = Integer.valueOf(linkProperties[1].replace("eth",""));
                Inet4Address firstNodeIp = findSwitchWithId(firsNodeSwitchId).getIp();
                // second node properties
                Integer secondNodePort = Integer.valueOf(linkProperties[3].replace("eth",""));
                String secondNodeType = linkProperties[2];
                Integer secondNodeId = Integer.valueOf(secondNodeType.substring(1));
                Inet4Address secondNodeIp=null;
                Switch switch1 = findSwitchWithId(firsNodeSwitchId);
                if(secondNodeType.startsWith("s")){
                    // node is a switch
                    secondNodeIp = findSwitchWithId(secondNodeId).getIp();
                }else if(secondNodeType.startsWith("h")){
                    // node is a host
                    secondNodeIp = findHostWithId(secondNodeId).getIp();
                }

//                System.out.println("first node "+firsNodeSwitchId+" first node port"+firstNodePort+
//                        " second node "+secondNodeType+" "+secondNodeIp+" second node port"+secondNodePort);
                BidirectionalLink newLink = new BidirectionalLink(firstNodeIp,secondNodeIp,firstNodePort,secondNodePort,1000);
                switch1.addNewBidirectionalLink(newLink,firstNodePort);
                newLinks.add(newLink);
                if(secondNodeType.startsWith("s")){
                    findSwitchWithId(secondNodeId).addNewBidirectionalLink(newLink,secondNodePort);
                }
            }
            }catch(Exception e){
                System.out.println(e);
            }finally{
                return newLinks;
            }
        }
        private static Switch findSwitchWithId(Integer id){
            for (Switch s:switches) {
                if (s.getSwitchId().equals(id)){
                    return s;
                }
            }
            return  null;
        }
    private static Host findHostWithId(Integer id){
        for (Host s:hosts) {
            if (s.getHostId().equals(id)){
                return s;
            }
        }
        return  null;
    }

    @AfterClass
    private static void visualizeNetwork(){
         SimpleDirectedGraph<Node,BidirectionalLink> networkGraph = new SimpleDirectedGraph(BidirectionalLink.class);
        Integer i = 0;
         for (Switch s:switches) {
            networkGraph.addVertex(s);

        }
        for (Host h:hosts) {
            networkGraph.addVertex(h);
        }
        JGraphXAdapter<Node, BidirectionalLink> graphAdapter = new JGraphXAdapter<>(networkGraph);
        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());
        File imgFile = new File("graph.png");
        try {
            imgFile.createNewFile();
        }catch (Exception e){
            System.out.println("s");
        }
        BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);


        try {
            ImageIO.write(image, "PNG", imgFile);
        }catch (Exception e){
            System.out.println("visualizer exception");
            System.out.println(e);
        }


        assertTrue(imgFile.exists());
    }
}
