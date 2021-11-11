package com.example.demo;

import config.CurrentUserSession;
import config.Products;
import config.Users;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ConsecutiveLines {

    public void loadData() throws IOException {
        List<String> productStrList = Files.readAllLines(Paths.get("src/main/resources/Lines.txt"));

        String line1 = "";
        String line2 = "";
        int iCount = 0;
        for (String str : productStrList) {
            iCount++;
            line2 = str;
            if (line1.equals(line2)) {
                System.out.println("BOTH LINES ARE EQUAL" + line1 +" at count=="+ iCount);
            }
            line1 = line2;
        }
        System.out.println("DONE");
    }
}
