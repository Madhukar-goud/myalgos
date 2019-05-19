package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by madhukar on 17/05/19.
 */

@Component
public class Service {

    @LogExecutionTime
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }
}