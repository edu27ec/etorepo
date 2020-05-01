package com.eto.pyp;

import com.eto.pyp.schedule.schedulepyp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class validpyp {

    public static void validatepyp(BufferedReader br) throws IOException {
        br.close();
    }

    public static boolean validRules(String date,String licenseplate, String time) {
       // schedulepyp schd=new schedulepyp(null,null);
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

    public static void main(String[] args) throws IOException {

        String licenseplate;
        String datepyp;
        String time;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("-----------------LICENSE PLATE VALIDATION PROGRAM FOR VEHICULAR TRAFFIC---------------");
        System.out.println("DATA ENTRY");
        System.out.println("LICENSE PLATE:  ");
        licenseplate=br.readLine();
        System.out.println("Vehicle circulation date: ");
        datepyp = br.readLine();
        System.out.println("Circulation time: ");
        time = br.readLine();
        boolean flag1=validRules(datepyp,licenseplate,time);
        if (flag1)
            System.out.println("Vehicular circulation allowed ");
        else
            System.out.println("Vehicular circulation not allowed");

        br.close();
    }
}
