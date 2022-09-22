package org.example;

public class Main {


    public static void main(String[] args) {
        int dividend = Integer.parseInt(args[0]);
        int divisor = Integer.parseInt(args[1]);

        Fraction f = new Fraction(dividend, divisor);
        f.shorten();





        System.out.println(f);

    }
}
