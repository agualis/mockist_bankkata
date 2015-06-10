package com.senpai.bankkata;

import org.joda.time.LocalDate;
import org.joda.time.format.*;

import java.lang.Comparable;

import static com.senpai.bankkata.Clock.DATE_FORMAT;

public class Transaction implements Comparable<Transaction>{
    private String date;
    protected int amount;

    public Transaction(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public String date() {
        return date;
    }

    public int amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (amount != that.amount) return false;
        return !(date != null ? !date.equals(that.date) : that.date != null);

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }

    @Override
    public int compareTo(Transaction t2) {
        final DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT);
        final LocalDate date1 = dtf.parseLocalDate(this.date);
        final LocalDate date2 = dtf.parseLocalDate(t2.date);
        if (date1.isBefore(date2)) {
            return 1;
        }
        return -1;
    }

}
