package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    private static ThreadLocal<Connection> connectionThreadLocal=new ThreadLocal<>();

    private static final String Driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/javaHomework?serverTimezone=UTC";
    private static final String username="root";
    private static final String password="";

    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection=connectionThreadLocal.get();
        if(connection==null) {
            connection = DriverManager.getConnection(url, username, password);
            connectionThreadLocal.set(connection);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        Connection connection=connectionThreadLocal.get();
        if(connection!=null){
            connection.close();
        }
    }

}
