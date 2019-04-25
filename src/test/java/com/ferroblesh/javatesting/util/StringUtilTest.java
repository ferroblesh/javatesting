package com.ferroblesh.javatesting.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringUtilTest {

    @Test
    public void testRepeat(){

        assertEquals("holaholahola",StringUtil.repeat("hola", 3));
        assertEquals("hola" , StringUtil.repeat("hola", 1));

    }

}