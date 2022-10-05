import java.math.BigInteger;

public class Fraction {

    /**
     * Comment for push to github
     */

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

    public Fraction add(Fraction other) {
        /**
         * @ToDo
         * Add this with other
         */
        return new Fraction((this.dividend * other.divisor) + (other.dividend * this.divisor), this.divisor * other.divisor);
    }

    public Fraction subtract(Fraction other) {
        /**
         * @ToDo
         * Subtract other from this
         */
        return new Fraction((this.dividend * other.divisor) - (other.dividend * this.divisor), this.divisor * other.divisor);
    }

    public Fraction multiply(Fraction other) {
        /**
         * @ToDo
         * Multiply this with other
         */
        return new Fraction(this.dividend * other.dividend, this.divisor * other.divisor);
    }

    public Fraction divide(Fraction other) {
        /**
         * @ToDo
         * Divide this by other
         */


        return new Fraction(this.dividend * other.divisor, this.divisor * other.dividend);
    }

    public Fraction shorten() {
        /**
         * @ToDo
         * Shorten the fraction
         */
        Fraction e = new Fraction(this.dividend / gcd(this.dividend, this.divisor), this.divisor / gcd(this.dividend, this.divisor));
        this.dividend = e.dividend;
        this.divisor = e.divisor;
        return this;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return this.dividend + " / " + this.divisor;
    }


}
