package com.interview.connections.common.utility;

public class Response {

    public static void yes() {
        System.out.println("yes");
        System.exit(0);
    }

    public static void no() {
        System.out.println("no");
        System.exit(0);
    }

    public static void error(String error){
        System.out.println(error);
        System.exit(0);
    }

}
