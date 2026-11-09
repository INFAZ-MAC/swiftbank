package lk.ijse.swiftbanksystem.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/swiftbank?serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "ijse@1234";

    private static DBConnection dbconnection;
    private Connection conn;

    private DBConnection() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public static synchronized DBConnection getInstance() throws SQLException {
        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed() || !conn.isValid(2)) {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
        return conn;
    }
}