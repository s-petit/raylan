package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RaylanConnection {

    protected static final String DB_URL = "jdbc:postgresql://localhost:5432/raylan_db";
    protected static final String DB_USER = "raylan";
    protected static final String DB_PWD = "raylan";

    public static Connection get() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
        } catch (Exception e) {
            // For the sake of this tutorial, let's keep exception handling simple
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ignore) {
                }
            }
        }

        return conn;
    }
}
