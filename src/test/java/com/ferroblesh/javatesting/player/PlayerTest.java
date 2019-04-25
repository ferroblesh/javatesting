package com.ferroblesh.javatesting.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {


    @Test
    public void loosesWhenDiceNumberIsTooLow() {

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);

        Player player = new Player(dice, 5);
        assertFalse(player.play());

    }

    @Test
    public void winWhenDiceNumberIsBig() {

        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 5);
        assertFalse(player.play());

    }
}