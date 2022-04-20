package endpoints;

/*
 * Code taken from 
 * http://crunchify.com/how-to-get-ping-status-of-any-http-end-point-in-java/
 */
import utils.HttpUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;



public class Endpoints {

  private static String[] endpointList = {
    "https://lazzoro.dk/ca2/api/joke/rand",
    "https://lazzoro.dk/ca2/api/animal/rand"
  };
  
  //Public so URL's can be reused in the parallel part
  public static String[] getEndpointList(){
    return endpointList;
  }
  
  //Public so it can be reused in the  parallel part
  public static String getStatus(String url) {
    try {
      return HttpUtils.fetchData(url);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "error";
  }
}
