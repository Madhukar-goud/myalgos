package com.example.demo;

import com.example.demo.kafka.TestKafkaProducer;
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
		TestKafkaProducer testKafkaProducer = ctx.getBean(TestKafkaProducer.class);
		testKafkaProducer.sendMessage("Testing 4");
		testKafkaProducer.sendMessage("Testing 5");
		testKafkaProducer.sendMessage("Testing 6");

	}
}
