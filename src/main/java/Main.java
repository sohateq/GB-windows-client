import GUI.*;
import retrofitModel.entity.StorageOperation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        new MainWindow();
//        DataBaseController.connect();
//        DataBaseController.updateBalance();
//        DataBaseController.updateOperations();
//        List<StorageOperation> operations = DataBaseController.getOperations();
//        for (int i = 0; i < operations.size(); i++) {
//            System.out.println(operations.get(i).toString());
//        }
//        DataBaseController.disconnect();
        new ScaffoldCalculation().calculate(30, 30, 1);
    }
}
