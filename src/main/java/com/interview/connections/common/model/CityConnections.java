package com.interview.connections.common.model;

import com.interview.connections.common.utility.Response;

public class CityConnections {
    String cityOne;
    String cityTwo;

    public CityConnections(String cityOne,String cityTwo){
        if(cityOne.isBlank() || cityTwo.isBlank()){
           throw new IllegalArgumentException("city name is empty in one of the connections");
        }
        this.cityOne = cityOne.trim().toLowerCase();
        this.cityTwo = cityTwo.trim().toLowerCase();
    }

    public String getCityOne(){
        return cityOne;
    }

    public String getCityTwo(){
        return cityTwo;
    }
}

