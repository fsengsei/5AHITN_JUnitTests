import htl.steyr.ac.at.DbInstance;
import htl.steyr.ac.at.Fraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class FractionTest {
    private static Connection connect(String db) throws SQLException {
        Connection conn = null;


        if (db.length() <= 0) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
        } else {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306" + db, "root", "root");

        }


        return conn;
    }

    @Test
    @Order(1)
    void connectToDatabase() {
        Assertions.assertDoesNotThrow(new ThrowingSupplier<Connection>() {
            @Override
            public Connection get() throws Throwable {
                return connect("");
            }
        });
    }

    @Test
    @Order(2)
    void createDatabase() {

        /**
         *  Ist dasselbe wie unten nur das Interfaces mit nur einer Funktion mit () (lambda) aufgerufen werden können
         *  Assertions.assertDoesNotThrow(new ThrowingSupplier<Object>() {
         *             @Override
         *             public Object get() throws Throwable {
         *                 Connection c = connect("");
         *
         *                 Statement s = c.createStatement();
         *                 s.executeUpdate("CREATE DATABASE testdb");
         *
         *                 s.close();
         *                 c.close();
         *                 return null;
         *             }
         *         });
         */

        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("");

            Statement s = c.createStatement();
            s.executeUpdate("CREATE DATABASE testdb");

            s.close();
            c.close();
        });


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