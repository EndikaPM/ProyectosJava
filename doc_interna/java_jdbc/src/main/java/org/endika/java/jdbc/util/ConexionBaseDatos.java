package org.endika.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso";// si no gunciona por tiempo añade esto al
    private static String userName = "root";                             // url ?serveTimezone=UTC
    private static String password = "";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(url,userName,password);
        }
        return connection;
    }
}
