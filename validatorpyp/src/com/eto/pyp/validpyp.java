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
        System.out.println("License Plate: (ex: PCD3118) ");
        licenseplate=br.readLine();
        System.out.println("Vehicle circulation date DD/MM/YYYY  (ex: 20/04/2017)");
        datepyp = br.readLine();
        System.out.println("Circulation time  HH:MM (ex: 08:45)");
        time = br.readLine();
        boolean flag1=validRules(datepyp,licenseplate,time);
        System.out.println("\nData:  License-> "+licenseplate+" Date-> "+datepyp+" Time-> "+time);
        if (flag1)
            System.out.println("\nVehicular circulation ALLOWED ");
        else
            System.out.println("\nVehicular circulation NOT ALLOWED");

        br.close();
    }
}
