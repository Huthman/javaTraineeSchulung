package org.example.arrays;

public class Reverse {
    public static void main(String[] args) {
        double[] test = {1,2,3,4,5,6};
        reverse(test);
        for(double d : test){
            System.out.println(d);
        }
    }

    public static void reverse(double[] numbers){
        if(numbers == null){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < numbers.length/2; i++){
            double temp;
            temp = numbers[i];
            numbers[i] = numbers[numbers.length-i-1];
            numbers[numbers.length-i-1] = temp;
        }
    }
}
