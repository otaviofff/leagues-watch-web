package watch.leagues.web;

import static spark.Spark.get;

import java.util.Date;

import spark.Spark;

public class App {
    
    /***
     * Application entry point.
     * 
     * It will serve all static files are under "/public" in classpath, 
     *   if the request URL isn't addressed by others routes. When using Maven, 
     *   the "/public" folder is assumed to be in "/main/resources".
     * 
     * @param String args
     */
    public static void main(String[] args) {
        Spark.staticFileLocation("/public");
        get("/ping", (request, response) -> "OK " + new Date().toString());
    }
}