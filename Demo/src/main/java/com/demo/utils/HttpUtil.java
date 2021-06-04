package com.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpUtil {

    private String value;

    public HttpUtil(){

    }

    public HttpUtil(String value){
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpUtil of(BufferedReader br){
        StringBuilder sb  = new StringBuilder();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HttpUtil(sb.toString());
    }
}
