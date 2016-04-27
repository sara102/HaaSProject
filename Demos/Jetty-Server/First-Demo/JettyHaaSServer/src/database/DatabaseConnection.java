package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    public static Connection connection;

    /*public static void main(String[] args) {
        new DatabaseConnection();

        //db.setSize(860,640);
        //db.setVisible(true);
    }*/
    public DatabaseConnection() {
        connection = initDatabaseConnection();
        //initDatabaseConnection();
    }

    //-------------------- Initialize DB with prepared Statement ---------------------------------------
    public static Connection initDatabaseConnection() {
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medi_reminder", "root", "root");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return connection;
        }

        return connection;
    }
    public static void closeDatabaseConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
