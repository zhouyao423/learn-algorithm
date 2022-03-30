package com.zy.chapter2;

import com.zy.chapter1.Request;
import com.zy.chapter1.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer1 {
    public static final String WEB_ROOT = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        HttpServer1 httpServer1 = new HttpServer1();
        httpServer1.await();
    }

    private void await() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080,1, InetAddress.getByName("127.0.0.1"));
        while (true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            Request request = new Request(inputStream);
            request.parse();

            Response response = new Response(outputStream);
            response.setRequest(request);

            if (request.getUri().startsWith("/servlet")){
                ServletProcessor1 servletProcessor1 = new ServletProcessor1();
                servletProcessor1.process(request,response);
            }else {
                StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
                staticResourceProcessor.process(request,response);
            }
            socket.close();
        }
    }
}
