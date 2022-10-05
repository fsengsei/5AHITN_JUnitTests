package htl.steyr.ac.at;

public class Main {
    public static void main(String[] args) {
        int dividend = Integer.parseInt(args[0]);
        int divisor = Integer.parseInt(args[1]);

        Fraction f = new Fraction(dividend, divisor);
        Fraction f2 = new Fraction(divisor, dividend);



        System.out.println("Add function: " + f.add(f2));
        System.out.println("Subtract function: " + f.subtract(f2));
        System.out.println("Multiply function: " + f.multiply(f2));
        System.out.println("Divide function: " + f.divide(f2));
        System.out.println("Shorten function: " + f.shorten());
        System.out.println("Shorten function: " + f2.shorten());
    }
}
