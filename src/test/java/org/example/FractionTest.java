package org.example;

import org.example.Fraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionTest {

    @org.junit.jupiter.api.Test
    void constructorTest(){
        // check normal use
        Fraction f1 = new Fraction(1, 1);
        Assertions.assertEquals("1 / 1", f1.toString());

        // check negative numbers
        Fraction f2 = new Fraction(1, -1);
        Assertions.assertEquals("1 / -1", f2.toString());

        // check two negative numbers
        Fraction f3 = new Fraction(-1, -1);
        Assertions.assertEquals("1 / 1", f3.toString());

        // check if the divisor is 0
        Fraction f4 = new Fraction(1, 0);
        Assertions.assertEquals("1 / 1", f4.toString());
    }


    @org.junit.jupiter.api.Test
    void getDividend() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals(1, f.getDividend());
    }

    @org.junit.jupiter.api.Test
    void setDividend() {
        Fraction f = new Fraction(1, 10);
        f.setDividend(2);

        Assertions.assertEquals(2, f.getDividend());
    }

    @org.junit.jupiter.api.Test
    void getDivisor() {
        Fraction f = new Fraction(1, 10);

        Assertions.assertEquals(10, f.getDivisor());
    }

    @org.junit.jupiter.api.Test
    void setDivisor() {
        Fraction f = new Fraction(1, 10);
        f.setDivisor(20);

        Assertions.assertEquals(20, f.getDivisor());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Fraction f = new Fraction(17, 3);

        Assertions.assertEquals("17 / 3", f.toString());
    }

    @Test
    void add() {
        Fraction f1 = new Fraction(12,78);
        Fraction f2 = new Fraction(4,6);

        Fraction result = f1.add(f2).shorten();

        Assertions.assertEquals(32, result.getDividend());
        Assertions.assertEquals(39, result.getDivisor());
    }

    @Test
    void sub() {
        Fraction f1 = new Fraction(1,70);
        Fraction f2 = new Fraction(2,90);

        Fraction result = f1.sub(f2).shorten();
        Assertions.assertEquals(1, result.getDividend());
        Assertions.assertEquals(-126, result.getDivisor());
    }

    @Test
    void mul() {
        Fraction f1 = new Fraction(1,27);
        Fraction f2 = new Fraction(9,44);

        Fraction result = f1.mul(f2).shorten();
        Assertions.assertEquals(1, result.getDividend());
        Assertions.assertEquals(132, result.getDivisor());
    }

    @Test
    void div() {
        Fraction f1 = new Fraction(1,27);
        Fraction f2 = new Fraction(9,44);

        Fraction result = f1.div(f2).shorten();

        Assertions.assertEquals(44, result.getDividend());
        Assertions.assertEquals(243, result.getDivisor());
    }

    @Test
    void shorten() {
        Fraction f = new Fraction(56, 528);
        f.shorten();
        Assertions.assertEquals(7, f.getDividend());
        Assertions.assertEquals(66, f.getDivisor());
    }
}