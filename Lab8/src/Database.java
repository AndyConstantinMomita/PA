import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/musicalbum" ;
        try {
             connection = DriverManager.getConnection(url, "dba", "sqlLab88");
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }

    public static void closeConnection()throws SQLException {
        connection.close();
    }
}
