package com.senpai.bankkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ClockShould {

    @Test
    public void
    get_today_string() {
        Clock clock = new Clock();

        assertThat(clock.today(), is("11/04/2014"));
    }

}