package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		//DemoBean demoBean = ctx.getBean(DemoBean.class);
//		demoBean.testQuickFind();
//		demoBean.testQuickUnion();
//		demoBean.testWeightedQuickUnion();
		//String currentPath = System.getProperty("user.dir");
		//CheckForFile.findFilePath( "QuickUnion.java");
		ConsecutiveLines consecutiveLines = ctx.getBean(ConsecutiveLines.class);
		consecutiveLines.loadData();
	}
}
