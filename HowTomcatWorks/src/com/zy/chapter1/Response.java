package com.zy.chapter1;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class Response implements ServletResponse {
    private OutputStream outputStream;
    private final int BUFFER_SIZE = 1024;
    Request request;
    PrintWriter printWriter;
    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fileInputStream = null;
        try {
            String uri = request.getUri();
            if ("/1.zip".equalsIgnoreCase(uri)){
                String name = "/Users/meng/Downloads/1.zip";
                File file = new File(name);
                long length = file.length()/10;
                fileInputStream = new FileInputStream(name);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                String header = "HTTP/1.1 200 OK\r\n"+
                        "Content-Type: application/zip\r\n" +
                        "Content-Length: "+length+"\r\n"+
                        "\r\n";
                outputStream.write(header.getBytes(StandardCharsets.UTF_8));
                int read ;
                while ((read = bufferedInputStream.read(bytes))>0){
                    outputStream.write(bytes,0,read);
                }
            }
            File file = new File(HttpServer.WEB_ROOT, uri);
            if (file.exists()){
                fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

                int read ;
                while ((read = bufferedInputStream.read(bytes))>0){
                    outputStream.write(bytes,0,read);
                }
            }else {
                String notFond = "HTTP/1.1 404 File Not Found\r\n"+
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 1000\r\n"+
                        "\r\n"+
                        "<h1>File Not Found</h1>" + HttpServer.WEB_ROOT;
                outputStream.write(notFond.getBytes(StandardCharsets.UTF_8));
            }
        }catch (Exception ex){

        }finally {
            if (fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        printWriter = new PrintWriter(outputStream,true);

        return printWriter;
    }

    @Override
    public void setContentLength(int i) {

    }

    @Override
    public void setContentType(String s) {

    }

    @Override
    public void setBufferSize(int i) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
