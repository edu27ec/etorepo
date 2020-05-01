package com.eto.pyp.schedule;

import java.util.Calendar;

public class schedulepyp
{

    private int id;
    private String nameDay;
    private String lastDigit;

    public schedulepyp(String nameDay, String lastDigit) {
        this.nameDay = nameDay;
        this.lastDigit = lastDigit;
    }

    public String getNameDay() { return nameDay;  }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public String getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(String lastDigit) {
        this.lastDigit = lastDigit;
    }
}
