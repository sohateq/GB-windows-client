package GUI;

import javax.swing.*;

public class ManagerGUI extends JFrame {
    private JPanel RootPanel;
    private JButton balanceButton;
    private JButton calcButton;
    private JButton operationHistoryButton;
    private JButton customersButton;
    private MainWindow mainWindow;

    public ManagerGUI(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBalanceButtonAction();
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setBounds(400, 100, 700, 800);
//        setContentPane(RootPanel);
//        setVisible(true);
    }

    protected JPanel getRootPanel() {
        return RootPanel;
    }

    protected void setBalanceButtonAction () {
        balanceButton.addActionListener(e -> {
            this.mainWindow.setContentPane(new BalanceGUI(mainWindow).getContentPane());
            this.mainWindow.validate();
        });
    }
}
