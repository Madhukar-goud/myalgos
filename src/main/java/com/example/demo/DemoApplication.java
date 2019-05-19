package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		DemoBean demoBean = ctx.getBean(DemoBean.class);
		demoBean.testQuickFind();
		demoBean.testQuickUnion();
		demoBean.testWeightedQuickUnion();
	}
}
