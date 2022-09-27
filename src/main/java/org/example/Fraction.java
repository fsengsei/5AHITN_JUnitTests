package org.example;

public class Fraction {

    private int dividend = 1;
    private int divisor = 1;

   /**
   * Constructor for Faction - class
   */
   
    public Fraction(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }

    /**
     * Adds two fractions
     * @param other the other fraction
     * @return a new org.example.Fraction with the result
     */
    public Fraction add(Fraction other) {
        // get the least common multiply for the divisors
        int com = lcm(this.divisor, other.divisor);
        // get the new dividends for the new least common multiply
        int newDividendThis = this.dividend * (com / this.divisor);
        int newDividendOther = other.dividend * (com / other.divisor);
        // return the sum of the dividends
        return new Fraction(newDividendThis + newDividendOther,com);
    }
    /**
     * subtracts two fractions
     * @param other the other fraction
     * @return a new org.example.Fraction with the result
     */
    public Fraction sub(Fraction other) {
        // get the least common multiply for the divisors
        int com = lcm(this.divisor, other.divisor);
        // get the new dividends for the new least common multiply
        int newDividendThis = this.dividend * (com / this.divisor);
        int newDividendOther = other.dividend * (com / other.divisor);
        // return the sum of the dividends
        return new Fraction(newDividendThis - newDividendOther,com);
    }
    /**
     * multiply two fractions
     * @param other the other fraction
     * @return a new org.example.Fraction with the result
     */
    public Fraction mul(Fraction other) {
        return new Fraction(this.dividend * other.dividend,this.divisor* other.divisor);
    }
    /**
     * divides two fractions
     * @param other the other fraction
     * @return a new org.example.Fraction with the result
     */
    public Fraction div(Fraction other) {
        return new Fraction(this.dividend * other.divisor,this.divisor* other.dividend);
    }
    /**
     * shortens a fraction
     * @return a new org.example.Fraction with the result
     */
    public Fraction shorten(){
        int gcd = gcd(this.dividend, this.divisor);
        this.setDividend(this.getDividend() /gcd);
        this.setDivisor(this.getDivisor() /gcd);
        return this;
    }

    /**
     * function to get the least common multiply
     * got it from https://www.baeldung.com/java-least-common-multiple
     * @param number1
     * @param number2
     * @return the least common multiply
     */
    private static int lcm(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
    /**
     * function to get the greatest common Divisor
     * got it from https://www.baeldung.com/java-greatest-common-divisor
     * @param n1
     * @param n2
     * @return the greatest common Divisor
     */
    private int gcd(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }

        if (n2 == 0) {
            return n1;
        }

        int n;
        for (n = 0; ((n1 | n2) & 1) == 0; n++) {
            n1 >>= 1;
            n2 >>= 1;
        }

        while ((n1 & 1) == 0) {
            n1 >>= 1;
        }

        do {
            while ((n2 & 1) == 0) {
                n2 >>= 1;
            }

            if (n1 > n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n2 = (n2 - n1);
        } while (n2 != 0);
        return n1 << n;
    }
}
