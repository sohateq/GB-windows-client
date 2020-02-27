package GUI;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setExtendedState(MAXIMIZED_BOTH);
        setContentPane(new StartGUI(this).getContentPane());
        setVisible(true);
    }

}
