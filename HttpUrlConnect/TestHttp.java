package httpexample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class TestHttp {

   public static void getIpAddress() throws UnknownHostException, MalformedURLException {
      Scanner in =  new Scanner(System.in);
      
      String inputUrl;
      System.out.println("Please enter the url of the website: ");
      inputUrl = in.nextLine();
      
      URL url = new URL(inputUrl);
      String host = url.getHost();
      InetAddress address = InetAddress.getByName(host);
      String ipAddress = address.getHostAddress();

      System.out.println(ipAddress); // shows the ip address of the host

   }
   
   public static void ping() throws MalformedURLException, IOException {
      Scanner in =  new Scanner(System.in);
      
      String inputUrl;
      System.out.println("Please enter the url of the website: ");
      inputUrl = in.nextLine();
      
      URL url = new URL(inputUrl);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      String pingStatus = conn.getResponseMessage();
      
      System.out.println("[Response] - " + pingStatus); // shows the ping response of the host
      
   }
   
   public static void json() throws MalformedURLException, UnknownHostException, IOException {
      
      Scanner in =  new Scanner(System.in);
      
	  // get the url from the user
      String inputUrl;
      System.out.println("Please enter the url of the website: ");
      inputUrl = in.nextLine();
	  
	  // get the ip address from the host
      URL url = new URL(inputUrl);
      String host = url.getHost();
      InetAddress address = InetAddress.getByName(host);
      String ipAddress = address.getHostAddress();
	  
	  // get the ping response from the host
	  HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      String pingStatus = conn.getResponseMessage();
	  
	  // assign url, ip address and ping response to a json object and array.
	  JSONObject root =  new JSONObject();

	  root.put("URL", inputUrl);
          root.put("IP Address", ipAddress);
          root.put("Ping Status", pingStatus);
	  

	  System.out.println(root);

   }
   
   public static void main(String args[]){

       try {
           getIpAddress();
           ping();
           json();
       } catch (UnknownHostException ex) {
           Logger.getLogger(TestHttp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(TestHttp.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
   }
}