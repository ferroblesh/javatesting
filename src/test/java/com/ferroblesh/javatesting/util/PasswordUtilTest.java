package com.ferroblesh.javatesting.util;

import org.junit.Test;

import static com.ferroblesh.javatesting.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weakWhenHasLessThan8Letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weakWhenHasOnlyLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("asdf"));
    }

    @Test
    public void mediumWhenHasLettersAndNumbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("asdf1234"));
    }

    @Test
    public void strongWhenHasLettersNumbersAndSymbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("asdf1234$$"));
    }
}