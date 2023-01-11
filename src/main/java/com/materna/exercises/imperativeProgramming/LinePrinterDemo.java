package com.materna.exercises.imperativeProgramming;


public class LinePrinterDemo {
    public static void main(String[] args) {
        LinePrinter.line();
        LinePrinter.line(2);
        LinePrinter.line(3,'*');
        LinePrinter.line("╠", 4, '═', "╣");
        LinePrinter.line(5, "*=");
    }
}
