import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetOptions {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8998), 0);
        // server.createContext("/rating", new RatingHandler());
        server.createContext("/file", new FileHandler());
        server.start();
    }
    
    static class FileHandler implements HttpHandler {
        @Override
            public void handle(HttpExchange exchange) throws IOException {
                if ("GET".equals(exchange.getRequestMethod())) {
                    
                    // Read the content of the file
                    String content = new String(Files.readAllBytes(Paths.get("Answers.txt")));
                    exchange.sendResponseHeaders(200, content.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(content.getBytes());
                    os.close();
                } else {
                    String response = "Not supported";
                    exchange.sendResponseHeaders(405, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            }
    }

    
    // static class FileHandler implements HttpHandler {
    //     @Override
    //     public void handle(HttpExchange exchange) throws IOException {
    //         if ("GET".equals(exchange.getRequestMethod())) {
    //             String query = exchange.getRequestURI().getQuery();
    //             String[] queryParams = query.split("=");
    //             if (queryParams.length == 2 && queryParams[0].equals("filename")) {
    //                 String filename = queryParams[1];
    //                 try {
    //                     // Read the content of the file
    //                     String content = new String(Files.readAllBytes(Paths.get(filename)));
    //                     exchange.sendResponseHeaders(200, content.getBytes().length);
    //                     OutputStream os = exchange.getResponseBody();
    //                     os.write(content.getBytes());
    //                     os.close();
    //                 } catch (IOException e) {
    //                     e.printStackTrace();
    //                     String response = "File not found or error reading file.";
    //                     exchange.sendResponseHeaders(404, response.getBytes().length);
    //                     OutputStream os = exchange.getResponseBody();
    //                     os.write(response.getBytes());
    //                     os.close();
    //                 }
    //             } else {
    //                 String response = "Invalid request";
    //                 exchange.sendResponseHeaders(400, response.getBytes().length);
    //                 OutputStream os = exchange.getResponseBody();
    //                 os.write(response.getBytes());
    //                 os.close();
    //             }
    //         } else {
    //             String response = "Not supported";
    //             exchange.sendResponseHeaders(405, response.getBytes().length);
    //             OutputStream os = exchange.getResponseBody();
    //             os.write(response.getBytes());
    //             os.close();
    //         }
    //     }
    // }
}
