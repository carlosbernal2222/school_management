import Database.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Controller {

    public static void main(String[] args) {

        System.out.println("Welcome To my School Management System");
        DatabaseManager dbManager = new DatabaseManager();

        try {
            Connection connection = dbManager.getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("Connection to the database established successfully!");
            } else {
                System.out.println("Failed to establish connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection();
        }

    }
}
