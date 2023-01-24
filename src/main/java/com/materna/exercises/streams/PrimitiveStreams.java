package com.materna.exercises.streams;

import java.io.Reader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimitiveStreams {
  public static void main(String[] args) {
    ////// 1.2.6


    ////// 1.2.7
    int[] numbers1 = {7, 12};
    int[] numbers2 = {51, 56, 0, 2};
    int[] result1 = join(numbers1, numbers2);
    int[] result2 = join(numbers1, numbers2, 3);
    System.out.println(Arrays.toString(result1));   // [7, 12, 51, 56, 0, 2]
    System.out.println(Arrays.toString(result2));   // [7, 12, 51]
  }

  ////// 1.2.6

//  public static String decrementNumbers(Reader reader){
//    return "";
//  }


  ////// 1.2.7
  private static int[] join(int[] numbers1, int[] numbers2) {
    return join(numbers1, numbers2, numbers1.length + numbers2.length);
  }

  private static int[] join(int[] numbers1, int[] numbers2, long maxSize) {
    return IntStream.concat(IntStream.of(numbers1), IntStream.of(numbers2))
            .limit(maxSize)
            .toArray();
  }
}
