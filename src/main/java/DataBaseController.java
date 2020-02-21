import retrofitModel.entity.StorageOperation;

import java.sql.*;
import java.util.Date;
import java.util.List;

public abstract class DataBaseController {
    private static Connection connection;
    private static Statement statement;

    public static void connect () {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:talosDB");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect () {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBalance () {

    }

    public static void updateOperations() {

    }

    public static Balance getBalance () {
        return null;
    }

    public static List<StorageOperation> getOperations (Date startDate, Date endDate, String customer, String type, boolean isPerformed) {
        return null;
    }

    public static void insertOperation (StorageOperation operation){

    }

    public static void inventory (Balance balance) {

    }
}
