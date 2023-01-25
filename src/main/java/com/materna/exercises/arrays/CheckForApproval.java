package com.materna.exercises.arrays;

public class CheckForApproval {
    public static void main(String[] args) {
        System.out.println(allTrue(true, null));
    }

    static boolean allTrue(boolean firstVote, boolean... votes){
        for(boolean vote : votes){
            if(!vote){
                return false;
            }
        }
        return firstVote;
    }
}
