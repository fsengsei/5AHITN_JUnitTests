package htl.steyr.ac.at;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbInstance {

    static {
        try {
            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private DbInstance() {
    }

    private static Connection connection = null;

    public synchronized static Connection getInstance() {
        if (connection == null) {
            try {
                // erzeuge neue Verbinung zur Datenbank
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
            } catch (SQLException throwables) {
            }
        }
        return connection;
    }
}
