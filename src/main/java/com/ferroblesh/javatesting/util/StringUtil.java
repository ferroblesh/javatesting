package com.ferroblesh.javatesting.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        String result = "";

        if(times < 0)
            throw new IllegalArgumentException("Ilegal arguments");

        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}
