package com.materna.exercises.threadsExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws Exception{


//    Runnable r1 = () -> {
//      System.out.println("1.1 " + Thread.currentThread().getName());
//      System.out.println("1.2 " + Thread.currentThread().getName());
//    };
//    Runnable r2 = () -> {
//      System.out.println("2.1 " + Thread.currentThread().getName());
//      System.out.println("2.2 " + Thread.currentThread().getName());
//    };
//
//    ExecutorService executor = Executors.newCachedThreadPool();
//    executor.execute(r1);
//    executor.execute(r2);
//    Thread.sleep(500);
//    executor.execute(r1);
//    executor.execute(r2);
//    executor.shutdown();

    Stream.of("one", "two", "three", "four")
            .filter(e -> e.length() > 3)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped value: " + e))
            .collect(Collectors.toList());


  }

}
