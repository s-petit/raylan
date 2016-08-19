package repository;

import org.apache.commons.dbcp2.BasicDataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RaylanDatasource {

    protected static final String DB_URL = "jdbc:postgresql://localhost:5432/raylan_db";
    protected static final String DB_USER = "raylan";
    protected static final String DB_PWD = "raylan";
    public static final String DB_DRIVER = "org.postgresql.Driver";

    private static RaylanDatasource datasource;
    private BasicDataSource ds;

    private RaylanDatasource() {
        ds = new BasicDataSource();
        ds.setDriverClassName(DB_DRIVER);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PWD);
        ds.setUrl(DB_URL);

        // the settings below are optional -- dbcp can work with defaults
/*        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);*/

    }

    public static RaylanDatasource getInstance()  {
        if (datasource == null) {
            datasource = new RaylanDatasource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection()  {
        Connection connection = null;
        try {
            connection = this.ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
