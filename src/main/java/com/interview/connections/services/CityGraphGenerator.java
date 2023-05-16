package com.interview.connections.services;

import com.interview.connections.common.model.CityConnections;
import com.interview.connections.common.utility.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CityGraphGenerator {

    public static HashMap<String, Set<String>> buildInputGraphStream(Stream<String> connections,String cityOne,String cityTwo){
        HashMap<String, Set<String>> output = new HashMap<>();
        connections
                .filter(k-> !k.isEmpty())
                .map(CityGraphGenerator::processLine)
                .takeWhile(cc -> {
                    // this will stop the stream as we found what we want and no need to process rest of stream
                    if (doesDirectConnectionExist(cc, cityOne, cityTwo)) {
                        output.computeIfAbsent(cc.getCityOne(), i -> new HashSet<>()).add(cc.getCityTwo());
                        return false;
                    }
                    return true;
                })
                .forEach(cc->{
                    output.computeIfAbsent(cc.getCityOne(), i -> new HashSet<>()).add(cc.getCityTwo());
                    output.computeIfAbsent(cc.getCityTwo(), j -> new HashSet<>()).add(cc.getCityOne());
                });
        if(output.isEmpty()){
            throw new IllegalArgumentException("no data found in the file please check the file");
        }
        return output;
    }

    private static CityConnections processLine(String line){
        String[] parts = line.split(",");
        if(parts.length != 2){
            throw new IllegalArgumentException("malformed data in the file please check file contents");
        }
        return new CityConnections(parts[0],parts[1]);
    }

    private static boolean doesDirectConnectionExist(CityConnections cc,String cityOne,String cityTwo){
        return (cc.getCityOne().equalsIgnoreCase(cityOne) || cc.getCityTwo().equalsIgnoreCase(cityOne))
                && (cc.getCityOne().equalsIgnoreCase(cityTwo) || cc.getCityTwo().equalsIgnoreCase(cityTwo));
    }

}
