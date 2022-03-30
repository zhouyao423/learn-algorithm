package com.zy.chapter2;

import com.zy.chapter1.Request;
import com.zy.chapter1.Response;

import java.io.IOException;

public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
