package com.interview.connections.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Stream;

class CityGraphGeneratorTest {

    /**
     * This test will ensure we stop processing of connections text file if we find two cities with direct connection since.
     * The way this has been tested is process conections text file twice and ensure the map size is different in direct connection vs not.
     */
    @Test
    public void testTwoCitiesDirectConnection() throws IOException {
        String filePath = "src/test/resources/validCities.txt";
        Path path = Paths.get(filePath);
        Stream<String> connections = Files.lines(path);
        HashMap<String, Set<String>> processPartialFile = CityGraphGenerator.buildInputGraphStream(connections,"San Diego".toLowerCase(),"Los Angeles".toLowerCase());
        Stream<String> connections2 = Files.lines(path);
        HashMap<String, Set<String>> processCompleteFile = CityGraphGenerator.buildInputGraphStream(connections2,"San Diego".toLowerCase(),"Tampa".toLowerCase());
        Assertions.assertNotEquals(processPartialFile.size(),processCompleteFile.size());
    }

    @Test
    public void testBuildingCompleteGraph() throws IOException {
        String filePath = "src/test/resources/validCities.txt";
        Path path = Paths.get(filePath);
        Stream<String> connections = Files.lines(path);
        HashMap<String, Set<String>> res = CityGraphGenerator.buildInputGraphStream(connections,"San Diego".toLowerCase(),"Tampa".toLowerCase());
        Assertions.assertNotNull(res);
    }

    @Test
    public void testMalformedFile() throws IOException {
        String filePath = "src/test/resources/malformedCities.txt";
        Path path = Paths.get(filePath);
        try(Stream<String> connections = Files.lines(path)) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> CityGraphGenerator.buildInputGraphStream(connections, "San Diego".toLowerCase(), "Tampa".toLowerCase()));
        }
    }

    @Test
    public void testEmptyCitiesFile() throws IOException {
        String filePath = "src/test/resources/malformedCities.txt";
        Path path = Paths.get(filePath);
        try(Stream<String> connections = Files.lines(path)) {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    CityGraphGenerator.buildInputGraphStream(connections, "San Diego".toLowerCase(), "Los Angeles".toLowerCase()));
        }
    }

}