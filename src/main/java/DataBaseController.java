import retrofitModel.entity.StorageOperation;

import java.sql.*;
import java.util.Date;
import java.util.List;

public abstract class DataBaseController {
    private static Connection connection;
    private static Statement statement;
    private static ClientController clientController = ClientController.getInstance();

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
//        Обновляет локальную базу данных с балансом
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS Blance (id INTEGER PRIMARY KEY NOT NULL, name TEXT  UNIQUE NOT NULL, count INTEGER, defectiveCount INTEGER, weight REAL, buyingPrice REAL);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOperations() {
//        Обновляет локальную базу данных операций
    }

    public static ElementScaffold[] getBalance () {
//        Возвращщает объект баланса из локальной базы данных
        return null;
    }

    public static List<StorageOperation> getOperations (Date startDate, Date endDate, String customer, String type, boolean isPerformed) {
//        Возвращает лист операций с учетом фильтров, должен работать даже если один, несколько или все фильтры не заданы
        return null;
    }

// Оба следующих метода не должны выполняться одновременно
    public static void insertOperation (StorageOperation operation) {
//        Добавляет в локальную и серверную базу данных операций новую операцию (лучше сделать в отдельном потоке)
    }

    public static void inventory (ElementScaffold[] balance) {
//        Меняет локальную и серверную базу данных баланса (лучше сделать в отдельном потоке)

    }
}
