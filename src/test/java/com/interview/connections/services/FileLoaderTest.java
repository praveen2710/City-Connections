package com.interview.connections.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

class FileLoaderTest {

    @Test()
    void loadFileFileNotFound() {
        String fileNotExists="src/test/resources/not_present.txt";
        Assertions.assertThrows(FileNotFoundException.class,()->
            FileLoader.loadFile(fileNotExists));
    }

    @Test
    void loadFileFileExists() throws IOException {
        String filePath = "src/test/resources/validCities.txt";
        Stream<String> res = FileLoader.loadFile(filePath);
        Assertions.assertNotNull(res);
    }


    @Test
    void loadFileMalformedFile() throws IOException {
        String filePath = "src/test/resources/malformedCities.txt";
        Stream<String> res = FileLoader.loadFile(filePath);
        Assertions.assertNotNull(res);
    }
}