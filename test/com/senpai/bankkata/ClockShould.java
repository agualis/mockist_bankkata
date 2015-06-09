package com.senpai.bankkata;

import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClockShould {

    @Test
    public void
    return_todays_date_in_dd_MM_yyyy_format() {
        Clock clock = new TestableClock();

        String date = clock.todayAsString();

        assertThat(date, is("08/06/2015"));
    }

    private class TestableClock extends Clock {
        protected LocalDate today() {
            return new LocalDate("2015-06-08");
        }
    }
}