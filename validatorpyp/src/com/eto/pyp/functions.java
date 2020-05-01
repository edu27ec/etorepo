package com.eto.pyp;

import com.eto.pyp.schedule.interval;
import com.eto.pyp.schedule.schedulepyp;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

public class functions {

    public static String getDay(int day, int month, int year) {
        String NEM = "";
        int numday = -1;
        TimeZone timezone = TimeZone.getDefault();
        Calendar cal = new GregorianCalendar(timezone);
        cal.set(year, month-1, day);
        numday= cal.get(Calendar.DAY_OF_WEEK);
        switch (numday) {
            case 1:
                NEM = "SU";
                break;
            case 2:
                NEM = "MO";
                break;
            case 3:
                NEM = "TU";
                break;
            case 4:
                NEM = "WE";
                break;
            case 5:
                NEM = "TH";
                break;
            case 6:
                NEM = "FR";
                break;
            case 7:
                NEM = "SA";
                break;
        }

        return NEM;
    }

    public static String validateLastDigit(String licenseplace) {

        int size = licenseplace.length();
        return licenseplace.substring(size - 1, size);
    }

    public static Map<String, schedulepyp> buildSchedule() {

        schedulepyp schd=new schedulepyp(null,null);
        Map<String, schedulepyp> schedpyp = new HashMap<>();
        schedpyp.put("1",new schedulepyp("MO","1"));
        schedpyp.put("2",new schedulepyp("MO","2"));
        schedpyp.put("3",new schedulepyp("TU","3"));
        schedpyp.put("4",new schedulepyp("TU","4"));
        schedpyp.put("5",new schedulepyp("WE","5"));
        schedpyp.put("6",new schedulepyp("WE","6"));
        schedpyp.put("7",new schedulepyp("TH","7"));
        schedpyp.put("8",new schedulepyp("TH","8"));
        schedpyp.put("9",new schedulepyp("FR","9"));
        schedpyp.put("0",new schedulepyp("FR","0"));
        return schedpyp;

    }

    public static Boolean validInterval(String time) {
        boolean valid=true;
        SimpleDateFormat form = new SimpleDateFormat("HH:mm");
        Map<String, Calendar> sched = buildInterval(time);
        interval intervalpyp=new interval(null,null,null);
        Map<String, interval> interval = new HashMap<>();
        interval.put("morning",new interval("In the morning",sched.get("from1"),sched.get("to1")));
        interval.put("afternoon",new interval("In the afternoon",sched.get("from2"),sched.get("to2")));
        if (sched.get("time").compareTo(interval.get("morning").getFrom())>=0 && sched.get("time").compareTo(interval.get("morning").getTo())<=0)
            valid=false;
        else
            if (sched.get("time").compareTo(interval.get("afternoon").getFrom())>=0 && sched.get("time").compareTo(interval.get("afternoon").getTo())<=0)
            valid=false;
        return valid;

    }

    public static Map<String, Calendar> buildInterval(String time)
    {
        String[] params=time.split(":");
        Map<String, Calendar> sched = new HashMap<>();
        Calendar from1 = Calendar.getInstance();
        Calendar from2 = Calendar.getInstance();
        Calendar to1 = Calendar.getInstance();
        Calendar to2 = Calendar.getInstance();
        Calendar timepyp=Calendar.getInstance();

        from1.set(Calendar.HOUR_OF_DAY, 7);
        from1.set(Calendar.MINUTE, 0);
        from1.set(Calendar.SECOND, 0);
        to1.set(Calendar.HOUR_OF_DAY, 9);
        to1.set(Calendar.MINUTE, 30);
        to1.set(Calendar.SECOND, 0);
        from2.set(Calendar.HOUR_OF_DAY, 16);
        from2.set(Calendar.MINUTE, 0);
        from2.set(Calendar.SECOND, 0);
        to2.set(Calendar.HOUR_OF_DAY, 19);
        to2.set(Calendar.MINUTE, 30);
        to2.set(Calendar.SECOND, 0);
        timepyp.set(Calendar.HOUR_OF_DAY,  parseInt(params[0]));
        timepyp.set(Calendar.MINUTE, parseInt(params[1]));
        timepyp.set(Calendar.SECOND, 0);
        sched.put("from1",from1);
        sched.put("to1",to1);
        sched.put("from2",from2);
        sched.put("to2",to2);
        sched.put("time",timepyp);

        return sched;
    }


}
