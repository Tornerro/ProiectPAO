package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pao";
    private static final String DB_USER_NAME = "root";
    private static final String DB_PASSWORD = "root";
    private final Connection connection;

    private DbConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = getConnection();
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new RuntimeException("Error during connection.");
        }
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
    }

    private static final class SINGLETON_HOLDER{
        private static final DbConnection INSTANCE = new DbConnection();
    }

    public static DbConnection getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    public Connection getDBConnection() {
        return this.connection;
    }
}
