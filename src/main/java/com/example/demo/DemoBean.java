package com.example.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by madhukar on 17/05/19.
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class DemoBean {
    @LogExecutionTime
    public void testQuickFind() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
            String numOfLines = reader.readLine();
            Integer intNumOfLines = Integer.parseInt(numOfLines);
            QuickFind qf = new QuickFind(intNumOfLines);
            for (int i = 0; i < intNumOfLines ; i++) {
                String numbers = reader.readLine();
                String[] pairs = numbers.split(" ");
                int p = Integer.parseInt(pairs[0]);
                int q = Integer.parseInt(pairs[1]);
                if (!qf.connected(p, q)) {
                    qf.union(p, q);
                    System.out.println(" Connecting == " + p +","+ q);
                } else {
                    System.out.println(" Already connected == " + p +","+ q);
                }
            }
            System.out.println("Are 4, 5 connected? ==> " +qf.connected(4, 5));
            System.out.println("Printing Array" );
            qf.printArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void testQuickUnion() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
            String numOfLines = reader.readLine();
            Integer intNumOfLines = Integer.parseInt(numOfLines);
            QuickUnion qf = new QuickUnion(intNumOfLines);
            for (int i = 0; i < intNumOfLines ; i++) {
                String numbers = reader.readLine();
                String[] pairs = numbers.split(" ");
                int p = Integer.parseInt(pairs[0]);
                int q = Integer.parseInt(pairs[1]);
                if (!qf.connected(p, q)) {
                    qf.union(p, q);
                    System.out.println(" Connecting == " + p +","+ q);
                } else {
                    System.out.println(" Already connected == " + p +","+ q);
                }
            }
            System.out.println("Are 4, 5 connected? ==> " +qf.connected(4, 5));
            System.out.println("Printing Array" );
            qf.printArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void testWeightedQuickUnion() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
            String numOfLines = reader.readLine();
            Integer intNumOfLines = Integer.parseInt(numOfLines);
            WeightedQuickUnion qf = new WeightedQuickUnion(intNumOfLines);
            for (int i = 0; i < intNumOfLines ; i++) {
                String numbers = reader.readLine();
                String[] pairs = numbers.split(" ");
                int p = Integer.parseInt(pairs[0]);
                int q = Integer.parseInt(pairs[1]);
                if (!qf.connected(p, q)) {
                    qf.union(p, q);
                    System.out.println(" Connecting == " + p +","+ q);
                } else {
                    System.out.println(" Already connected == " + p +","+ q);
                }
            }
            System.out.println("Are 4, 5 connected? ==> " +qf.connected(4, 5));
            System.out.println("Printing Array" );
            qf.printArray();
            System.out.println("Max of connected comp ==> "+ qf.find(7));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
