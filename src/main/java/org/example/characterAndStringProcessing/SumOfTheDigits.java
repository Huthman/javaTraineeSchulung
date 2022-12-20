package org.example.characterAndStringProcessing;

public class SumOfTheDigits {
    public static void main(String[] args) {
        System.out.println(digitSum(100021301));
        System.out.println(digitSum("1000000000100000070000001"));
    }

    static int digitSum(long value){
//        int digitSum = 0;
//        while(value != 0){
//            digitSum += value%10;
//            value /= 10;
//        }
//        return digitSum;
        return digitSum(Long.toString(value));
    }

    static int digitSum(String value){
        int digitSum = 0;
        for(int i = 0; i<value.length(); i++){
            digitSum+=Integer.parseInt(Character.toString(value.charAt(i)));
        }
        return digitSum;
    }
}
