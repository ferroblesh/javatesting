package com.ferroblesh.javatesting.discounts;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void return_total_zero_when_there_are_prices() {

        PriceCalculator calculator = new PriceCalculator();

        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices() {

        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(10.2);
        calculator.addPrice(15.5);

        assertThat(calculator.getTotal(), is(25.7));

    }

    @Test
    public void apply_discount_to_prices() {

        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);

        calculator.setDiscount(25);

        assertThat(calculator.getTotal(), is(150.0));
    }
}