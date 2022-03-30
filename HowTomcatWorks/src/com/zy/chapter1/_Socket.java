package com.zy.chapter1;

import java.io.*;
import java.net.Socket;

public class _Socket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("59.110.244.59", 80);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
            printWriter.println("GET /community/index.html HTTP/1.1");
            printWriter.println("Content-Type: application/json");
            printWriter.println("Connection: Keep-Alive");
            printWriter.println("");
            printWriter.println("page=1&size=40&type=json");
            printWriter.flush();

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String read = null;
            while ((read = reader.readLine()) != null) {
                System.out.println(read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
