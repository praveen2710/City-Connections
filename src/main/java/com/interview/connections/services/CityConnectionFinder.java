package com.interview.connections.services;

import java.util.*;

public class CityConnectionFinder {
    public static boolean isConnectionPresent(Map<String, Set<String>> connections,String cityOne,String cityTwo){
        if(!connections.containsKey(cityOne) || !connections.containsKey(cityTwo)){
            return false;
        }
        if(connections.get(cityOne).contains(cityTwo) || connections.get(cityTwo).contains(cityOne)){
            return true;
        }
        Set<String> visitedCities = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add(cityOne);
        visitedCities.add(cityOne);
        while (!queue.isEmpty()){
            String curCity = queue.poll();
            if(curCity.equalsIgnoreCase(cityTwo)){
                return true;
            }
            for(String adjCities:connections.get(curCity)){
                if(visitedCities.contains(adjCities)){
                    continue;
                }
                queue.add(adjCities);
                visitedCities.add(curCity);
            }
        }

        return false;
    }
}
