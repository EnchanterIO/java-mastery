package com.marsrover;

import com.marsrover.http.LandingPageController;
import com.marsrover.http.RobotController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since  2018-02-15
 */
final public class HttpApplication {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java WebServer <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
            server.createContext("/", new LandingPageController());
            server.createContext("/robot/", new RobotController());
            server.start();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }
    }
}
