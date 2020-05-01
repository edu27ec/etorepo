package com.eto.pyp.schedule;

import java.util.Calendar;

public class interval {
    private String info;
    private Calendar from;
    private Calendar to;
    public interval(String info, Calendar from, Calendar to) {
        this.info = info;
        this.from = from;
        this.to = to;
    }

    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public Calendar getFrom() {
        return from;
    }
    public void setInfo(Calendar from) {
        this.from = from;
    }

    public Calendar getTo() {
        return to;
    }
    public void setTo(Calendar to) {
        this.to = to;
    }
}
