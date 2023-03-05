//package com.example.springbootsample.config;
//
////import com.alibaba.fastjson.JSON;
////import com.alibaba.fastjson.JSONObject;
////import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.web.client.ResponseErrorHandler;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Scanner;
//
//@Configuration
//public class RestTemplateConfig {
//    @Bean
////    @LoadBalanced
//    @Primary
//    RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(requestFactory());
//        return restTemplate;
//    }
//
//    @Bean(name = "SimpleRestTemplate")
//    RestTemplate simpleRestTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory(requestFactory());
//        restTemplate.setErrorHandler(new MyErrorHandler());
//        return restTemplate;
//    }
//
//    @Bean
//    SimpleClientHttpRequestFactory requestFactory(){
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setConnectTimeout(10000);
//        requestFactory.setReadTimeout(120000);
//        return requestFactory;
//    }
//
//    public static class MyErrorHandler implements ResponseErrorHandler {
//        @Override
//        public void handleError(ClientHttpResponse response) throws IOException {
//            String responseAsString = toString(response.getBody());
////            JSONObject jsonObject = JSON.parseObject(responseAsString);
////            throw new CustomException(jsonObject.getString("message"));
//        }
//
//        @Override
//        public boolean hasError(ClientHttpResponse response) throws IOException {
//            return true; // delete it
////            HttpStatus status = response.getStatusCode();
////            return status.is4xxClientError() || status.is5xxServerError();
//        }
//        String toString(InputStream inputStream) {
//            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
//            return s.hasNext() ? s.next() : "";
//        }
//
//        static class CustomException extends RuntimeException {
//            public CustomException(String message) {
//                super(message);
//            }
//        }
//
//    }
//}
