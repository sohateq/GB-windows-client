package GUI;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setExtendedState(MAXIMIZED_BOTH);
        mainPanel = new StartGUI(this).getRootPanel();
        setContentPane(mainPanel);
        setVisible(true);
    }

}
