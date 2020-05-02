package com.eto.pyp.test;
import com.eto.pyp.validpyp.*;
import com.eto.pyp.functions;
import com.eto.pyp.schedule.schedulepyp;
import com.eto.pyp.schedule.interval;


import java.io.IOException;
import java.util.*;

import org.junit.Before;
import org.junit.Test;


import junit.framework.TestSuite;

import static java.lang.Integer.parseInt;

/**
 *
 * @author CRISTHIAN
 */
public class validpypTest extends TestSuite {

    private static String licenseplate;
    private static String datepyp;
    private static String time;


    @Before
    public void data() {
        licenseplate = "PBK3414";
        datepyp = "23/04/2019";
        time = "18:30";
    }

    @Test
    public void validTest() throws IOException {


        System.out.println("------TEST------------- LICENSE PLATE VALIDATION PROGRAM FOR VEHICULAR TRAFFIC---------------");
        System.out.println("DATA ENTRY");
        System.out.println("\nData:  License-> "+licenseplate+" Date-> "+datepyp+" Time-> "+time);
        boolean flag1=validRules(datepyp,licenseplate,time);
        if (flag1)
            System.out.println("\nVehicular circulation ALLOWED ");
        else
            System.out.println("\nVehicular circulation NOT ALLOWED");

    }

    public boolean validRules(String date,String licenseplate, String time) {
        int isvaliday=0;
        String[] fields=date.split("/");
        String day=functions.getDay(parseInt(fields[0]),parseInt(fields[1]),parseInt(fields[2]));
        String ldigit=functions.validateLastDigit(licenseplate);
        Map<String,schedulepyp> schedule= functions.buildSchedule();
        if (schedule.get(ldigit).getNameDay().equals(day))
            isvaliday=1;
        if (isvaliday==1)
            return functions.validInterval(time);
        else
            return true;
    }
}
