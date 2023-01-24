package com.materna.exercises.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println(getFridayThirteenth(2023).size());
  }

  public static List<LocalDate> getFridayThirteenth(int year){

    List<LocalDate> fridayThirteenth = new ArrayList<>();
    LocalDate date = LocalDate.of(year,1,13);

    do{
      if(date.getDayOfWeek() == DayOfWeek.FRIDAY){
        fridayThirteenth.add(date);
      }
      date = date.plusMonths(1);
    }while(date.getYear() == year);

    return fridayThirteenth;
  }

}
