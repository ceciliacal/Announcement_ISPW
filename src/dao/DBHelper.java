package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private  final String USER = "root";
    private  final String PASS = "root";
    private  final String DB_URL = "jdbc:mysql://127.0.0.1:3306/localDB";
    private  final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private Connection connection = null;

    // Apertura connessione con il DB

    public Connection openConnection() {
        if (connection != null) return connection;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("There was an exception during connection opening !");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("There was an exception loading drivers!");
            e.printStackTrace();
        }
        return connection;
    }

    // Chiusura la connessione con il DB

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("There was an exception during connection close !");
            e.printStackTrace();
        }
    }
}
