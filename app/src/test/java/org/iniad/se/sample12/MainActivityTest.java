package org.iniad.se.sample12;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class MainActivityTest {
    MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
    }

    @Test
    public void testCalc1() {
        String x = "1.0";
        String y = "2.0";
        assertThat(activity.calc(x, y), is(3.0));
    }

    @Test(expected=NumberFormatException.class)
    public void testCalc2() {
        String x = "A";
        String y = "2.0";
        activity.calc(x, y);
    }

    @Test(expected=NumberFormatException.class)
    public void testCalc3() {
        String x = "1.0";
        String y = "B";
        activity.calc(x, y);
    }
}