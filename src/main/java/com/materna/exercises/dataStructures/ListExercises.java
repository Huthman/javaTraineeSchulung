package com.materna.exercises.dataStructures;

import java.util.*;

public class ListExercises {

  public static void main(String[] args) {
    //////// 1.2.5
//    List<String> names1 = Arrays.asList("Alexandre", "Charles", "Anne", "Henry");
//    List<String> agree = Arrays.asList("Alexandre", "Charles", "Anne", "Henry");
//    List<String> concur = Arrays.asList("Henry","Alexandre","Charles", "Anne");
//    List<String> doNotMatch = Arrays.asList("Alexandre", "William", "Anne", "Henry");
//
//    System.out.println(isSameCircle(names1, agree));

    //////// 1.3.2

    System.out.println( Arrays.toString( unique() ) ); //                                    []
    System.out.println( Arrays.toString( unique( 1, 2 ) ) ); //                      [1.0, 2.0]
    System.out.println( Arrays.toString( unique( 1, 1 ) ) ); //                           [1.0]
    System.out.println( Arrays.toString( unique( 3,1, 2, 1 ) ) ); //                   [1.0, 2.0]
    System.out.println( Arrays.toString( unique( 1, 2, 1, Double.NaN ) ) ); //  [1.0, 2.0, NaN]
    System.out.println( Arrays.toString( unique( 1, Double.NaN, Double.NaN ) ) ); // [1.0, NaN]
    System.out.println( Arrays.toString( unique( -0, 0 ) ) ); //                          [0.0]
//    unique(null);
  }




  //////// 1.2.5
  public static String isSameCircle(List<String> names1, List<String> names2){
    if(Objects.requireNonNull(names1).equals(Objects.requireNonNull(names2))){
      return "agree";
    }
    if(!(names1.containsAll(names2) && names2.containsAll(names1))){
      return "do not match";
    }

    for(int i1 = 0, i2 = names2.indexOf(names1.get(0));
        i1<names1.size();
        i1++, i2++ ){

      if(!names1.get(i1).equals(names2.get(i2))){
        return "do not agree";
      }

      if(i2 == names2.size()-1){
        i2 = -1;
      }
    }
    return "concur";

  }

  //////// 1.3.2
  public static double[] unique(double... values){
    List<Double> temp = new ArrayList<>();
    HashSet<Double> set = new HashSet<>();
    for(double value: Objects.requireNonNull(values)){
      temp.add(value);
      set.add(value);
    }

    double[] toReturn = new double[set.size()];
    UniqueIterator<Double> iterator = new UniqueIterator<>(temp.iterator());
    for(int i = 0; iterator.hasNext(); i++){
      toReturn[i] = iterator.next();
    }

    return toReturn;

//    LinkedHashSet<Double> set = new LinkedHashSet<>();
//    for(double value : Objects.requireNonNull(values)){
//      set.add(value);
//    }
//
//    double[] toReturn = new double[set.size()];
//    Iterator<Double> setIterator = set.iterator();
//    for(int i = 0; setIterator.hasNext(); i++){
//      toReturn[i] = setIterator.next();
//    }
//
//    return toReturn;
  }

}
