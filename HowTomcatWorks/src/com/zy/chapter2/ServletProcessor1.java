package com.zy.chapter2;

import com.zy.Constants;
import com.zy.chapter1.Request;
import com.zy.chapter1.Response;

import javax.servlet.Servlet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor1 {
    public void process(Request request, Response response) throws IOException {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/")+1);
        URLClassLoader classLoader = null;
        URLStreamHandler urlStreamHandler = null;
        URL[] urls = new URL[1];
        File classPath = new File(Constants.WEB_ROOT);
        String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
        urls[0] = new URL(null,repository,urlStreamHandler);
        classLoader = new URLClassLoader(urls);

        try {
            Class<?> myClass = classLoader.loadClass(servletName);
            Servlet servlet = (Servlet) myClass.newInstance();
            servlet.service(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
