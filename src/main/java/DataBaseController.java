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
//        Обновляет локальную базу данных с балансом
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS Balance (id INTEGER PRIMARY KEY NOT NULL, name TEXT  UNIQUE NOT NULL, count INTEGER, defectiveCount INTEGER, weight REAL, buyingPrice REAL);");
            ElementScaffold[] balance = ClientController.getInstance().getBalance();
            for (int i = 0; i < balance.length; i++) {
                int id = i+1;
                String name = balance[i].getName();
                int count = balance[i].getCount();
                int defectiveCount = balance[i].getDefectiveCount();
                double weight = balance[i].getWeight();
                double buyingPrice = balance[i].getBuyingPrice();
                try {
                    String query = String.format("UPDATE Balance SET count = '%d', defectiveCount = '%d', weight = '%f', buyingPrice = '%f'  WHERE id = '%d';", count, defectiveCount, weight, buyingPrice, id);
                    statement.execute(query);
                } catch (SQLException e) {
                    String query = String.format("INSERT INTO Balance(id, name, count, defectiveCount, weight, buyingPrice) VALUES('%d', '%s', '%d', '%d', '%f', '%f')", id, name, count, defectiveCount, weight, buyingPrice);
                    statement.execute(query);
                }
            }
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
