package GUI;

import javax.swing.*;
import java.awt.*;

public class BalanceGUI extends JFrame {
    private JButton backButton;
    private JTable table1;
    private JPanel RootPanel;

    public BalanceGUI() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
