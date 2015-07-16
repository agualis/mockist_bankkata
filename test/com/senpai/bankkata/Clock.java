package com.senpai.bankkata;

import org.joda.time.LocalDate;

public class Clock {

    public String today() {
        return LocalDate.now().toString();
    }
}
