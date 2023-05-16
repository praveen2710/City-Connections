package com.interview.connections.services;

import com.interview.connections.common.utility.Response;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLoader {

    public static Stream<String> loadFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if(Files.notExists(path)){
            throw new FileNotFoundException("File with name:"+path+" does not exist");
        }
        return Files.lines(path);
    }


}
