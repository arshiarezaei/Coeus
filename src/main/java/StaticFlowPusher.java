
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;


public class StaticFlowPusher {

    private static String controllerAddress ;
    private static HttpPost postRequestToSendRules;
    private static CloseableHttpClient httpClient;


    static {
        postRequestToSendRules = new HttpPost();
        postRequestToSendRules.setHeader("Accept", "application/json");
        postRequestToSendRules.setHeader("Content-type", "application/json");
        httpClient = HttpClients.createDefault();
    }

    public StaticFlowPusher(String controllerAddress) {
        String path = "/wm/staticentrypusher/json";
        int port = 8080;
        String uriPath = "http://"+controllerAddress+":"+port+path;
        StaticFlowPusher.controllerAddress = uriPath;
//        System.out.println(uriPath);
        postRequestToSendRules = new HttpPost(URI.create(uriPath));
    }

    public void sendRolesToController(String[] s) {
        StringEntity entity;
        CloseableHttpResponse response = null;
        try {
            for (String string:s) {
                entity = new StringEntity(string);
                postRequestToSendRules.setEntity(entity);
                response = httpClient.execute(postRequestToSendRules);
            }
            response.close();
        }catch (Exception e){
            System.out.println("Exception in staticFlowPusher->sendRolesToController");
            e.printStackTrace();
            System.out.println("-----");
        }

    }


}
