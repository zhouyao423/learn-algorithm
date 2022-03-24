import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {

    private ThreadPool threadPool = new ThreadPool();

    public SimpleHttpServer(){

    }

    public static void main(String[] args) throws IOException {
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        simpleHttpServer.start();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket;
        while ((socket = serverSocket.accept())!=null){
            threadPool.execute(new HttpHandler(socket));
        }
    }

    private class HttpHandler implements Runnable{
        Socket socket;
        public HttpHandler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            BufferedReader br =null;
            PrintWriter bw = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                 inputStream = socket.getInputStream();
                br = new BufferedReader(new InputStreamReader(inputStream));
                String s =null;
                while ((s = br.readLine())!=null){
                    System.out.println(s);
                    break;
                }
                 outputStream = socket.getOutputStream();
                bw = new PrintWriter(outputStream);
                bw.println("HTTP/1.1 200 OK");
                bw.println("Server: Johnny");
                bw.println("Content-Type: text/html");
                bw.println("");
                bw.println(Thread.currentThread().getName());
                bw.flush();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                bw.close();
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
