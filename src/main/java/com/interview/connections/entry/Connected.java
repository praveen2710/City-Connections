package com.interview.connections.entry;

import com.interview.connections.common.utility.Response;
import com.interview.connections.services.CityConnectionFinder;
import com.interview.connections.services.CityGraphGenerator;
import com.interview.connections.services.FileLoader;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Connected {

    public static void main(String[] args){
        if(validateInput(args)){
            try {
                if(process(args)){
                    Response.yes();
                }else{
                    Response.no();
                }
            }catch (IOException | IllegalArgumentException e){
                Response.error(e.getMessage());
            } catch (Exception e){
                Response.error("unexpected Error");
            }
        }else {
            Response.error("Unexpected number of arguments expected <filename> <cityname1> <cityname2>");
        }
    }

    private static boolean process(String[] args) throws IOException {
        final String dataFile = args[0];
        final String cityOne = args[1].toLowerCase();
        final String cityTwo = args[2].toLowerCase();

        // no further processing needed as source and dest are same;
        if(cityOne.equals(cityTwo)){
            return  true;
        }
        Stream<String> connections = FileLoader.loadFile(dataFile);
        HashMap<String, Set<String>> connectionsGraph = CityGraphGenerator.buildInputGraphStream(connections,cityOne,cityTwo);
        return CityConnectionFinder.isConnectionPresent(connectionsGraph,cityOne,cityTwo);

    }

    /**
     * Added a basic check to ensure we are getting expected number of inputs
     * @param args expected filename cityone citytwo
     * @return true if expected input is provided false otherwise
     */
    private static boolean validateInput(String[] args){
        if(args.length == 3){
            for(String arg:args){
                if(arg.isBlank()){
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
