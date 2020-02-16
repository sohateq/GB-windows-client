import java.sql.*;
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
    public static void elementsUpdate () {

    }
    public static void storageMovementsUpdate () {

    }
    public static void customersUpdate () {

    }
// Пока void, потом подумаем что именно они будут возвращать
    public static void getElementsCount () {

    }

    public static void getElementsPrice () {

    }

    public static List<StorageMovement> getStorageMovements () {
        return null;
    }

    public static List<Customer> getCustomers () {
        return null;
    }

}
