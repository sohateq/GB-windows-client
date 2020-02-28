import GUI.*;

public class Main {
    public static void main(String[] args) {
//        new MainWindow();
        DataBaseController.connect();
        DataBaseController.updateBalance();
        DataBaseController.updateOperations();
        DataBaseController.disconnect();
    }
}
