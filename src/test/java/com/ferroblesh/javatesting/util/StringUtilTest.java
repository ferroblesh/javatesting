package com.ferroblesh.javatesting.util;

import org.junit.Test;

import static org.junit.Assert.*;


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

    @Test
    public void is_not_empty() {

        assertFalse(StringUtil.isEmpty("NotEmptyString"));

    }

    @Test
    public void is_empty() {

        assertTrue(StringUtil.isEmpty(""));

    }

    @Test
    public void null_is_empty() {

        assertTrue(StringUtil.isEmpty(null));

    }

    @Test
    public void string_with_spaces_is_empty() {

        assertTrue(StringUtil.isEmpty(" "));

    }
}