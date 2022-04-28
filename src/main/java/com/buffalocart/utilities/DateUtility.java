package com.buffalocart.utilities;

import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateUtility {

    public LocalDate getTodaysDate(){
        LocalDate myObj = LocalDate.now();
        return myObj;
    }


    public static void main(String[] args) {
        LocalDate myObj = LocalDate.now(); // Create a date object
        System.out.println(myObj); // Display the current date



        String data="04/27/2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(data, formatter);
        System.out.println(date);


        Assert.assertEquals(date,myObj,"Not equal");
    }
}
