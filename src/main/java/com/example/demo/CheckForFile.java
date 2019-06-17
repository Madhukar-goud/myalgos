package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CheckForFile {

    public static String pathWalker(String path, String fileName) {
        File root = new File( path );
        File[] list = root.listFiles();
        for ( File f : list ) {
            if (f.isDirectory()) {
                //log.info("File not found in {}, checking subfolders", path);
                pathWalker(f.getAbsolutePath(), fileName);
            } else if (f.getName().equals(fileName)){
                log.info("File found , Absolute path is {}", f.getAbsolutePath());
                log.info("File found , Absolute path is {}", f.getParent());
                return f.getAbsolutePath();
            }
        }
        log.info("FILE NOT FOUND in {}", path);
        return null;
    }

    public static String pathWalkerStreams(String path, String fileName) throws IOException {
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach(f -> {
                    if (f.endsWith(fileName)) {
                        log.info("FILE FOUND ==>" + f);
                    }
                });
        return null;
    }

    public static String findFilePath(String fileName) throws IOException {
        List<Path> list = Files.walk(Paths.get(System.getProperty("user.dir")))
                .filter(Files::isRegularFile)
                .filter(path -> path.endsWith(fileName))
                .collect(Collectors.toList());
        if (!list.isEmpty()) {
            log.info("PATH is ==> "+ list.get(0).getParent().toString());
            return list.get(0).getParent().toString();
        }
        log.info("FILE NOT FOUND");
        return null;
    }


}
