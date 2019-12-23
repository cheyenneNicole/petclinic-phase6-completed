package com.example;

import com.example.business.StoreBusinessFlow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreClient {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(StoreClient.class, args);

        StoreBusinessFlow business = (StoreBusinessFlow) context.getBean("storeBusinessFlow");

        business.runBusiness();

    }
}
