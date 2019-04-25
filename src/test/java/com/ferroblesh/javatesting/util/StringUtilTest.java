package com.ferroblesh.javatesting.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringUtilTest {

    @Test
    public void repeatStringOnce(){

        assertEquals("hola" , StringUtil.repeat("hola", 1));

    }

    @Test
    public void repeatStringMultipleTimes(){

        assertEquals("holaholahola",StringUtil.repeat("hola", 3));

    }

    @Test
    public void repeatStringZeroTimes(){

        assertEquals("",StringUtil.repeat("hola", 0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes(){

        assertEquals("",StringUtil.repeat("hola", -1));

    }

}