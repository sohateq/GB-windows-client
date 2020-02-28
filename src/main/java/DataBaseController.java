import GUI.OperationsListGUI;
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
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS Operations (id INTEGER PRIMARY KEY NOT NULL, date TEXT NOT NULL, customerName TEXT NOT NULL, type TEXT NOT NULL, " +
                    "stairsFrameCount INTEGER, " +
                    "passFrameCount INTEGER, " +
                    "diagonalConnectionCount INTEGER, " +
                    "horizontalConnectionCount INTEGER, " +
                    "crossbarCount INTEGER, " +
                    "deckCount INTEGER, " +
                    "supportsCount INTEGER, " +
                    "stairsFrameBadCount INTEGER, " +
                    "passFrameBadCount INTEGER, " +
                    "diagonalConnectionBadCount INTEGER, " +
                    "horizontalConnectionBadCount INTEGER, " +
                    "crossbarBadCount INTEGER, " +
                    "deckBadCount INTEGER, " +
                    "supportsBadCount INTEGER, " +
                    "performed INTEGER);");
            List<StorageOperation> operations = ClientController.getInstance().getOperationsList();
            for (int i = 0; i < operations.size(); i++) {
                int id = operations.get(i).getId();
                String date = operations.get(i).getDate();
                String customerName = operations.get(i).getCustomerName();
                String type = operations.get(i).getType();
                int stairsFrameCount = operations.get(i).getStairsFrameCount();
                int passFrameCount = operations.get(i).getPassFrameCount();
                int diagonalConnectionCount = operations.get(i).getDiagonalConnectionCount();
                int horizontalConnectionCount = operations.get(i).getHorizontalConnectionCount();
                int crossbarCount = operations.get(i).getCrossbarCount();
                int deckCount = operations.get(i).getDeckCount();
                int supportsCount = operations.get(i).getSupportsCount();
                int stairsFrameBadCount = operations.get(i).getStairsFrameBadCount();
                int passFrameBadCount = operations.get(i).getPassFrameBadCount();
                int diagonalConnectionBadCount = operations.get(i).getDiagonalConnectionBadCount();
                int horizontalConnectionBadCount = operations.get(i).getHorizontalConnectionBadCount();
                int crossbarBadCount = operations.get(i).getCrossbarBadCount();
                int deckBadCount = operations.get(i).getDeckBadCount();
                int supportsBadCount = operations.get(i).getSupportsBadCount();
                int performed = 0;
                if (operations.get(i).getPerformed()) {
                    performed = 1;
                }
                try {
                    String query = String.format("INSERT INTO Operations(id, date, customerName, type, " +
                            "stairsFrameCount, " +
                            "passFrameCount, " +
                            "diagonalConnectionCount, " +
                            "horizontalConnectionCount, " +
                            "crossbarCount, " +
                            "deckCount, " +
                            "supportsCount, " +
                            "stairsFrameBadCount, " +
                            "passFrameBadCount, " +
                            "diagonalConnectionBadCount, " +
                            "horizontalConnectionBadCount, " +
                            "crossbarBadCount, " +
                            "deckBadCount, " +
                            "supportsBadCount, " +
                            "performed) VALUES('%d', '%s', '%s', '%s', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d')",
                            id, date, customerName, type, stairsFrameCount, passFrameCount, diagonalConnectionCount, horizontalConnectionCount, crossbarCount, deckCount, supportsCount,
                            stairsFrameBadCount, passFrameBadCount, diagonalConnectionBadCount, horizontalConnectionBadCount, crossbarBadCount, deckBadCount, supportsBadCount, performed);
                    statement.execute(query);
                } catch (SQLException e) {
                    String query = String.format("UPDATE Operations SET " +
                                    "date = '%s', " +
                                    "customerName = '%s', " +
                                    "type = '%s', " +
                                    "stairsFrameCount = '%d', " +
                                    "passFrameCount = '%d', " +
                                    "diagonalConnectionCount = '%d', " +
                                    "horizontalConnectionCount = '%d', " +
                                    "crossbarCount = '%d', " +
                                    "deckCount = '%d', " +
                                    "supportsCount = '%d', " +
                                    "stairsFrameBadCount = '%d', " +
                                    "passFrameBadCount = '%d', " +
                                    "diagonalConnectionBadCount = '%d', " +
                                    "horizontalConnectionBadCount = '%d', " +
                                    "crossbarBadCount = '%d', " +
                                    "deckBadCount = '%d', " +
                                    "supportsBadCount = '%d', " +
                                    "performed = '%d' " +
                                    "WHERE id = '%d';",
                            date, customerName, type, stairsFrameCount, passFrameCount, diagonalConnectionCount, horizontalConnectionCount, crossbarCount, deckCount, supportsCount,
                            stairsFrameBadCount, passFrameBadCount, diagonalConnectionBadCount, horizontalConnectionBadCount, crossbarBadCount, deckBadCount, supportsBadCount, performed, id);
                    statement.execute(query);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
