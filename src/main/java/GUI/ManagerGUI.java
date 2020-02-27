package GUI;

import javax.swing.*;

public class ManagerGUI extends JFrame {
    private JPanel RootPanel;
    private JButton balanceButton;
    private JButton calcButton;
    private JButton operationsListButton;
    private JButton customersButton;
    private MainWindow mainWindow;

    public ManagerGUI(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setContentPane(RootPanel);
        setBalanceButtonAction();
        setCalcButtonAction();
        setOperationsListButtonAction();
        setCustomersButtonAction();
    }

    protected JPanel getRootPanel() {
        return RootPanel;
    }

    private void setBalanceButtonAction () {
        balanceButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new BalanceGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }

    private void setCalcButtonAction () {
        calcButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new CalculateGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }

    private void setOperationsListButtonAction() {
        operationsListButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new OperationsListGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }

    private void setCustomersButtonAction () {
        customersButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new CustomersListGUI(mainWindow, this).getContentPane());
            this.mainWindow.validate();
        });
    }
}
