package com.marsrover.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-17
 */
final public class LandingPageController implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "Check Readme file for usage instructions: https://github.com/EnchanterIO/java-mastery/tree/master/mars-rover";

        httpExchange.sendResponseHeaders(200, response.length());

        OutputStream outputStream = httpExchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }
}
