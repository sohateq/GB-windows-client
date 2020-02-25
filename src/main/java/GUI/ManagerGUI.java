package GUI;

import javax.swing.*;

public class ManagerGUI extends JFrame {
    private JPanel RootPanel;
    private JButton balanceButton;
    private JButton calcButton;
    private JButton operationHistoryButton;
    private JButton customersButton;

    public ManagerGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
