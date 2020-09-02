import retrofitModel.entity.StorageOperation;

import java.sql.*;
import java.util.ArrayList;
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
                String type = operations.get(i).getType().toLowerCase();
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
                            "performed) VALUES('%d', '%s', '%s', '%s', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d', '%d')",
                            id, date, customerName, type,
                            stairsFrameCount, passFrameCount, diagonalConnectionCount, horizontalConnectionCount, crossbarCount, deckCount, supportsCount,
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
        List<ElementScaffold> elementScaffolds = new ArrayList<>();
        ElementScaffold [] balance = new ElementScaffold[7];
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Balance;");
            while (resultSet.next()) {
                String elementName = resultSet.getString("name");
                int count = resultSet.getInt("count");
                int defectiveCount = resultSet.getInt("defectiveCount");
                double weight = resultSet.getDouble("weight");
                double buyingPrice = resultSet.getDouble("buyingPrice");
                elementScaffolds.add(new ElementScaffold(elementName, count, defectiveCount, weight, buyingPrice));
            }
            elementScaffolds.toArray(balance);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public static List<StorageOperation> getOperations (String startDate, String endDate, String customer, String typeF, boolean isPerformed) {
//        Возвращает лист операций с учетом фильтров, должен работать даже если один, несколько или все фильтры не заданы
        if (startDate == null || startDate.isEmpty()) {
            startDate = "1970-01-01";
        }
        if (endDate == null || endDate.isEmpty()){
            endDate = "2050-12-31";
        }
        if (customer != null && !customer.isEmpty()) {
            customer = " AND customerName = '" + customer + "'";
        } else {
            customer = "";
        }
        if (typeF != null && !typeF.isEmpty()) {
            typeF = " AND type = '" + typeF + "'";
        } else {
            typeF = "";
        }
        String performed = " AND performed = '1'";
        if (!isPerformed) {
            performed = " AND performed = '0'";
        }
        String filter = "WHERE (date BETWEEN '" + startDate + "' AND '" + endDate + "')" + customer + typeF + performed;
        List<StorageOperation> operations = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Operations " + filter + " ORDER BY date DESC;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getString("date");
                String customerName = resultSet.getString("customerName");
                String type = resultSet.getString("type");
                int stairsFrameCount = resultSet.getInt("stairsFrameCount");
                int passFrameCount = resultSet.getInt("passFrameCount");
                int diagonalConnectionCount = resultSet.getInt("diagonalConnectionCount");
                int horizontalConnectionCount = resultSet.getInt("horizontalConnectionCount");
                int crossbarCount = resultSet.getInt("crossbarCount");
                int deckCount = resultSet.getInt("deckCount");
                int supportsCount = resultSet.getInt("supportsCount");
                int stairsFrameBadCount = resultSet.getInt("stairsFrameBadCount");
                int passFrameBadCount = resultSet.getInt("passFrameBadCount");
                int diagonalConnectionBadCount = resultSet.getInt("diagonalConnectionBadCount");
                int horizontalConnectionBadCount = resultSet.getInt("horizontalConnectionBadCount");
                int crossbarBadCount = resultSet.getInt("crossbarBadCount");
                int deckBadCount = resultSet.getInt("deckBadCount");
                int supportsBadCount = resultSet.getInt("supportsBadCount");
                Boolean operationsIsPerformed = false;
                if (resultSet.getInt("performed") == 1) {
                    operationsIsPerformed = true;
                }
                operations.add(new StorageOperation(id, date, customerName, type, stairsFrameCount, passFrameCount, diagonalConnectionCount, horizontalConnectionCount, crossbarCount, deckCount, supportsCount,
                        stairsFrameBadCount, passFrameBadCount, diagonalConnectionBadCount, horizontalConnectionBadCount, crossbarBadCount, deckBadCount, supportsBadCount, operationsIsPerformed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operations;
    }

    public static List<StorageOperation> getOperations (String startDate, String endDate, String customer, String typeF) {
//        Возвращает лист операций с учетом фильтров, должен работать даже если один, несколько или все фильтры не заданы
        if (startDate == null || startDate.isEmpty()) {
            startDate = "1970-01-01";
        }
        if (endDate == null || endDate.isEmpty()){
            endDate = "2050-12-31";
        }
        if (customer != null && !customer.isEmpty()) {
            customer = " AND customerName = '" + customer + "'";
        } else {
            customer = "";
        }
        if (typeF != null && !typeF.isEmpty()) {
            typeF = " AND type = '" + typeF + "'";
        } else {
            typeF = "";
        }
        String filter = " WHERE (date BETWEEN '" + startDate + "' AND '" + endDate + "')" + customer + typeF;
        List<StorageOperation> operations = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Operations" + filter + " ORDER BY date DESC;");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String date = resultSet.getString("date");
                String customerName = resultSet.getString("customerName");
                String type = resultSet.getString("type");
                int stairsFrameCount = resultSet.getInt("stairsFrameCount");
                int passFrameCount = resultSet.getInt("passFrameCount");
                int diagonalConnectionCount = resultSet.getInt("diagonalConnectionCount");
                int horizontalConnectionCount = resultSet.getInt("horizontalConnectionCount");
                int crossbarCount = resultSet.getInt("crossbarCount");
                int deckCount = resultSet.getInt("deckCount");
                int supportsCount = resultSet.getInt("supportsCount");
                int stairsFrameBadCount = resultSet.getInt("stairsFrameBadCount");
                int passFrameBadCount = resultSet.getInt("passFrameBadCount");
                int diagonalConnectionBadCount = resultSet.getInt("diagonalConnectionBadCount");
                int horizontalConnectionBadCount = resultSet.getInt("horizontalConnectionBadCount");
                int crossbarBadCount = resultSet.getInt("crossbarBadCount");
                int deckBadCount = resultSet.getInt("deckBadCount");
                int supportsBadCount = resultSet.getInt("supportsBadCount");
                Boolean operationsIsPerformed = false;
                if (resultSet.getInt("performed") == 1) {
                    operationsIsPerformed = true;
                }
                operations.add(new StorageOperation(id, date, customerName, type, stairsFrameCount, passFrameCount, diagonalConnectionCount, horizontalConnectionCount, crossbarCount, deckCount, supportsCount,
                        stairsFrameBadCount, passFrameBadCount, diagonalConnectionBadCount, horizontalConnectionBadCount, crossbarBadCount, deckBadCount, supportsBadCount, operationsIsPerformed));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operations;
    }

    public static List<String> getCustomers () {
        List<String> customers = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT customerName FROM Operations ORDER BY customerName;");
            while (resultSet.next()) {
                customers.add(resultSet.getString("customerName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public static List<String> getTypes () {
        List<String> types = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT type FROM Operations ORDER BY type;");
            while (resultSet.next()) {
                types.add(resultSet.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }


    public static void createOperation(StorageOperation operation) {
        new Thread(()->{
            if (operation.getPerformed() && operation.getType().equalsIgnoreCase("отгрузка")) {
                ElementScaffold [] balance = getBalance();
                balance[0].countReduce(operation.getStairsFrameCount());
                balance[0].defectiveCountReduce(operation.getStairsFrameBadCount());
                balance[1].countReduce(operation.getPassFrameCount());
                balance[1].defectiveCountReduce(operation.getPassFrameBadCount());
                balance[2].countReduce(operation.getDiagonalConnectionCount());
                balance[2].defectiveCountReduce(operation.getDiagonalConnectionBadCount());
                balance[3].countReduce(operation.getHorizontalConnectionCount());
                balance[3].defectiveCountReduce(operation.getHorizontalConnectionBadCount());
                balance[4].countReduce(operation.getCrossbarCount());
                balance[4].defectiveCountReduce(operation.getCrossbarBadCount());
                balance[5].countReduce(operation.getDeckCount());
                balance[5].defectiveCountReduce(operation.getDeckBadCount());
                balance[6].countReduce(operation.getSupportsCount());
                balance[6].defectiveCountReduce(operation.getSupportsBadCount());
                ClientController.getInstance().editBalance(balance);
                updateBalance();
            } else if (operation.getPerformed() && !operation.getType().equalsIgnoreCase("отгрузка")) {
                ElementScaffold [] balance = getBalance();
                balance[0].countAppend(operation.getStairsFrameCount());
                balance[0].defectiveCountAppend(operation.getStairsFrameBadCount());
                balance[1].countAppend(operation.getPassFrameCount());
                balance[1].defectiveCountAppend(operation.getPassFrameBadCount());
                balance[2].countAppend(operation.getDiagonalConnectionCount());
                balance[2].defectiveCountAppend(operation.getDiagonalConnectionBadCount());
                balance[3].countAppend(operation.getHorizontalConnectionCount());
                balance[3].defectiveCountAppend(operation.getHorizontalConnectionBadCount());
                balance[4].countAppend(operation.getCrossbarCount());
                balance[4].defectiveCountAppend(operation.getCrossbarBadCount());
                balance[5].countAppend(operation.getDeckCount());
                balance[5].defectiveCountAppend(operation.getDeckBadCount());
                balance[6].countAppend(operation.getSupportsCount());
                balance[6].defectiveCountAppend(operation.getSupportsBadCount());
                ClientController.getInstance().editBalance(balance);
                updateBalance();
            }
            ClientController.getInstance().createOperation(operation);
            updateOperations();
        }).start();
    }

    public static void performOperation(StorageOperation operation) {
        new Thread(() -> {
            if (operation.getPerformed() && operation.getId() != null && operation.getType().equalsIgnoreCase("отгрузка")) {
                ElementScaffold [] balance = getBalance();
                balance[0].countReduce(operation.getStairsFrameCount());
                balance[0].defectiveCountReduce(operation.getStairsFrameBadCount());
                balance[1].countReduce(operation.getPassFrameCount());
                balance[1].defectiveCountReduce(operation.getPassFrameBadCount());
                balance[2].countReduce(operation.getDiagonalConnectionCount());
                balance[2].defectiveCountReduce(operation.getDiagonalConnectionBadCount());
                balance[3].countReduce(operation.getHorizontalConnectionCount());
                balance[3].defectiveCountReduce(operation.getHorizontalConnectionBadCount());
                balance[4].countReduce(operation.getCrossbarCount());
                balance[4].defectiveCountReduce(operation.getCrossbarBadCount());
                balance[5].countReduce(operation.getDeckCount());
                balance[5].defectiveCountReduce(operation.getDeckBadCount());
                balance[6].countReduce(operation.getSupportsCount());
                balance[6].defectiveCountReduce(operation.getSupportsBadCount());
                ClientController.getInstance().editBalance(balance);
                updateBalance();
                ClientController.getInstance().editOperation(operation);
                updateOperations();
            }
        }).start();
    }

    public static void inventory (ElementScaffold[] balance) {
//        Меняет локальную и серверную базу данных баланса (лучше сделать в отдельном потоке)
        new Thread(()-> {
            ClientController.getInstance().editBalance(balance);
            updateBalance();
        }).start();

    }

    public static boolean deleteOperation (int operationID) {
        String query  = "DELETE FROM Operations WHERE id = '" + operationID + "';";
        try {
            new Thread(() -> {
                ClientController.getInstance().deleteOperation(operationID);
            }).start();
            statement.execute(query);
            updateOperations();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void editDefectiveBalance (StorageOperation operation) {
        new Thread(()->{
            ElementScaffold [] balance = getBalance();
            if (operation.getPerformed() && operation.getType().equalsIgnoreCase("восстановление")) {
                balance[0].countAppend(operation.getStairsFrameCount());
                balance[0].defectiveCountReduce(operation.getStairsFrameCount());
                balance[1].countAppend(operation.getPassFrameCount());
                balance[1].defectiveCountReduce(operation.getPassFrameCount());
                balance[2].countAppend(operation.getDiagonalConnectionCount());
                balance[2].defectiveCountReduce(operation.getDiagonalConnectionCount());
                balance[3].countAppend(operation.getHorizontalConnectionCount());
                balance[3].defectiveCountReduce(operation.getHorizontalConnectionCount());
                balance[4].countAppend(operation.getCrossbarCount());
                balance[4].defectiveCountReduce(operation.getCrossbarCount());
                balance[5].countAppend(operation.getDeckCount());
                balance[5].defectiveCountReduce(operation.getDeckCount());
                balance[6].countAppend(operation.getSupportsCount());
                balance[6].defectiveCountReduce(operation.getSupportsCount());
                ClientController.getInstance().editBalance(balance);
                updateBalance();
            } else if (operation.getPerformed() && operation.getType().equalsIgnoreCase("брак")) {
                balance[0].countReduce(operation.getStairsFrameBadCount());
                balance[0].defectiveCountAppend(operation.getStairsFrameBadCount());
                balance[1].countReduce(operation.getPassFrameBadCount());
                balance[1].defectiveCountAppend(operation.getPassFrameBadCount());
                balance[2].countReduce(operation.getDiagonalConnectionBadCount());
                balance[2].defectiveCountAppend(operation.getDiagonalConnectionBadCount());
                balance[3].countReduce(operation.getHorizontalConnectionBadCount());
                balance[3].defectiveCountAppend(operation.getHorizontalConnectionBadCount());
                balance[4].countReduce(operation.getCrossbarBadCount());
                balance[4].defectiveCountAppend(operation.getCrossbarBadCount());
                balance[5].countReduce(operation.getDeckBadCount());
                balance[5].defectiveCountAppend(operation.getDeckBadCount());
                balance[6].countReduce(operation.getSupportsBadCount());
                balance[6].defectiveCountAppend(operation.getSupportsBadCount());
                ClientController.getInstance().editBalance(balance);
                updateBalance();
            } else if (operation.getPerformed() && operation.getType().equalsIgnoreCase("утилизация")) {
                balance[0].defectiveCountReduce(operation.getStairsFrameBadCount());
                balance[1].defectiveCountReduce(operation.getPassFrameBadCount());
                balance[2].defectiveCountReduce(operation.getDiagonalConnectionBadCount());
                balance[3].defectiveCountReduce(operation.getHorizontalConnectionBadCount());
                balance[4].defectiveCountReduce(operation.getCrossbarBadCount());
                balance[5].defectiveCountReduce(operation.getDeckBadCount());
                balance[6].defectiveCountReduce(operation.getSupportsBadCount());
                ClientController.getInstance().editBalance(balance);
                updateBalance();
            }
            ClientController.getInstance().createOperation(operation);
            updateOperations();
        }).start();
    }
}
