package GUI;

import javax.swing.*;
import java.awt.*;

public class StorageGUI extends JFrame {
    private JPanel RootPanel;
    private JButton balanceButton;
    private JButton operationsListButton;
    private JButton shipmentListButton;
    private JButton createOperationButton;

    public StorageGUI() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
