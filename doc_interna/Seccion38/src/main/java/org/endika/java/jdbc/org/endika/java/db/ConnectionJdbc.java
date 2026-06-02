package org.endika.java.jdbc.org.endika.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJdbc {

    private static String url = "jdbc:mariadb://localhost:3306/swing_product";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
