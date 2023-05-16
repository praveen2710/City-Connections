package com.interview.connections.entry;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class ITConnectedTest {

    @Test
    public void ITConnectionExists() {
        String[] args = new String[]{"src/test/resources/validCities.txt","Boston","Hartford"};
        Connected.main(args);
    }

    @Test
    public void ITConnectionDoesNotExists(){
        String[] args = new String[]{"src/test/resources/validCities.txt","Boston","Tampa"};
        Connected.main(args);
    }

    @Test
    public void ITFileNotFound() {
        String[] args = new String[]{"src/test/resources/invalidCities.txt","Boston","Hartford"};
        Connected.main(args);
    }

    @Test
    public void ITMalformedFile() {
        String[] args = new String[]{"src/test/resources/malformedCities.txt","Boston","Hartford"};
        Connected.main(args);
    }

    @Test
    public void ITEmptyFile() {
        String[] args = new String[]{"src/test/resources/emptyCities.txt","Boston","Hartford"};
        Connected.main(args);
    }

    @Test
    public void ITWrongNumberOfArguments(){
        String[] args = new String[]{"src/test/resources/emptyCities.txt","Boston","Hartford","sbla"};
        Connected.main(args);
    }

}