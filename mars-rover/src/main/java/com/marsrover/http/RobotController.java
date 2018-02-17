package com.marsrover.http;

import com.marsrover.Application;
import com.marsrover.controller.IllegalApplicationInstructionsException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Lukas Lukac <services@trki.sk>
 * @since 2018-02-17
 */
final public class RobotController implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (!isValidRequestMethod(httpExchange.getRequestMethod())) {
            renderResponse(
                httpExchange,
                405,
                "Only PUT requests with Robot instructions as body are allowed!"
            );

            return;
        }

        int responseCode = 200;
        String response;

        try {
            response = Application.run(
                readApplicationInput(httpExchange.getRequestBody())
            );
        } catch (IllegalApplicationInstructionsException exception) {
            // In case the submitted instructions have wrong format
            response = exception.getMessage();
            responseCode = 400;
        } catch (IOException exception) {
            // In case there is an internal server error in reading HTTP request
            response = "Application is currently down.";
            responseCode = 500;
        }

        renderResponse(httpExchange, responseCode, response);
    }

    private boolean isValidRequestMethod(String method) {
        return method.toLowerCase().equals("put");
    }

    private void renderResponse(HttpExchange exchange, int responseCode, String response) throws IOException {
        exchange.sendResponseHeaders(responseCode, response.length());

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(response.getBytes());
        outputStream.close();
    }

    private String readApplicationInput(InputStream inputStream) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        StringBuilder input = new StringBuilder();
        char[] buffer = new char[2048];
        int read;

        while ((read = reader.read(buffer)) != -1) {
            input.append(buffer, 0, read);
        }

        inputStream.close();

        return input.toString();
    }
}
