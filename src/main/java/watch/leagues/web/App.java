package watch.leagues.web;

import static spark.Spark.get;
import static spark.SparkBase.port;

import java.util.Date;

import spark.Spark;

public class App {
    
    /***
     * Application entry point.
     * 
     * @param String args
     */
    public static void main(String[] args) {
        listenToAssignedPort();
        renderPublicAssets();
        
        get("/ping", (request, response) -> "OK " + new Date().toString());
    }
    
    /**
     * Makes the application listen to the port assigned to it by the hosting
     *  service in question, such as Heroku. If no port number is found in
     *  the environment, then the default Spark port (4567) will be set.
     *  
     */
    private static void listenToAssignedPort() {
        ProcessBuilder builder = new ProcessBuilder();
        String value = builder.environment().get("PORT");
        Integer port = 4567; //Default port set by Spark.
        
        if (value != null) {
            port = Integer.valueOf(value);
        }
        
        port(port);
    }
    
    /**
     * Sets the location of all public assets in the application, 
     *  such as HTML, CSS and JS files. This function will serve all static 
     *  files under "/public" in classpath, if the request URL isn't 
     *  addressed by others routes. When using Maven, the "/public" folder is 
     *  assumed to be in "/main/resources".
     *  
     */
    private static void renderPublicAssets() {
        Spark.staticFileLocation("/public");
    }
}