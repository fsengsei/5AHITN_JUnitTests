import htl.steyr.ac.at.Fraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionTest {

    @org.junit.jupiter.api.Test
    void getDividend() {
        /**
         * testing function getDividend
         */
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


    @Test
    void add() {
        Fraction f = new Fraction(10, 5);
        Fraction f2 = new Fraction(1, 2);


        Assertions.assertEquals("25 / 10", f.add(f2).toString());
    }

    @Test
    void subtract() {
        Fraction f = new Fraction(8, 4);
        Fraction f2 = new Fraction(1, 2);

        Assertions.assertEquals("12 / 8", f.subtract(f2).toString());
    }

    @Test
    void multiply() {
        Fraction f = new Fraction(10, 5);
        Fraction f2 = new Fraction(1, 2);

        Assertions.assertEquals("10 / 10", f.multiply(f2).toString());
    }

    @Test
    void divide() {
        Fraction f = new Fraction(10, 5);
        Fraction f2 = new Fraction(1, 2);

        Assertions.assertEquals("20 / 5", f.divide(f2).toString());
    }

    @Test
    void shorten() {
        Fraction f = new Fraction(10, 20);

        Assertions.assertEquals("1 / 2", f.shorten().toString());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Fraction f = new Fraction(17, 3);

        Assertions.assertEquals("17 / 3", f.toString());
    }
}