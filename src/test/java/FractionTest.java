import htl.steyr.ac.at.DbInstance;
import htl.steyr.ac.at.Fraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class FractionTest {
    static Connection db;

    @BeforeAll
    static void initDbc(){
        try {
            db = DbInstance.getInstance();
        } catch (Exception e){

        }
    }

    @org.junit.jupiter.api.Test
    @Order(1)
    public void createDatabase() {
        Assertions.assertDoesNotThrow(() -> {
            Statement s = db.createStatement();
            s.executeUpdate("CREATE DATABASE Test2");
        });
    }

    @org.junit.jupiter.api.Test
    @Order(2)
    public void createTable() {
        Assertions.assertDoesNotThrow(() -> {
            Statement s = db.createStatement();
            s.executeUpdate("CREATE TABLE Test2" +
                    "(test INTEGER not NULL)");
        });
    }

    @org.junit.jupiter.api.Test
    @Order(3)
    public void insertIntoTable() {
        Assertions.assertDoesNotThrow(() -> {
            Statement s = db.createStatement();
            s.executeUpdate("INSERT INTO Test2 (test)" +
                    "VALUES(1)");
        });
    }

    @org.junit.jupiter.api.Test
    @Order(4)
    public void readDataFromTable() throws SQLException {
        Statement s = db.createStatement();
        Assertions.assertDoesNotThrow(() -> {
            s.executeUpdate("SELECT * FROM Test2");
        });
        Assertions.assertEquals(s.executeUpdate("SELECT * FROM Test2")
        , 1);
    }

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