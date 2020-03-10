import javax.swing.*;
import java.awt.*;

public class StorageGUI extends JFrame {
    private JPanel RootPanel;
    private JButton balanceButton;
    private JButton operationsListButton;
    private JButton shipmentListButton;
    private JButton createOperationButton;
    private MainWindow mainWindow;

    public StorageGUI(MainWindow mainWindow) throws HeadlessException {
        this.mainWindow = mainWindow;
        setContentPane(RootPanel);
        setBalanceButtonAction();
        setOperationsListButtonAction();
        setShipmentListButtonAction();
        setCreateOperationButtonAction();
    }

    private void setBalanceButtonAction () {
        balanceButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new BalanceGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }

    private void setOperationsListButtonAction() {
        operationsListButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new OperationsListGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }

    private void setShipmentListButtonAction() {
        shipmentListButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new ShipmentListGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }

    private void setCreateOperationButtonAction() {
        createOperationButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new CreateOperationGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }
}
