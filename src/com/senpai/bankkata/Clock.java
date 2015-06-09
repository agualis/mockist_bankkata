package com.senpai.bankkata;

import org.joda.time.LocalDate;

public class Clock {

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public String todayAsString() {
        return today().toString(DATE_FORMAT);
    }

    protected LocalDate today() {
        return new LocalDate();
    }
}
