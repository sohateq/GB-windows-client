package GUI;

import javax.swing.*;

public class StartGUI extends JFrame {
    private JButton managerButton;
    private JButton storageButton;
    private JPanel RootPanel;
    private MainWindow mainWindow;

    public StartGUI(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setBounds(400, 100, 700, 800);
//        setContentPane(RootPanel);
//        setVisible(false);
        setManagerButtonAction();
    }

    public JPanel getRootPanel() {
        return RootPanel;
    }
    private void setManagerButtonAction () {
        managerButton.addActionListener(e -> {
            mainWindow.setContentPane(new ManagerGUI(mainWindow).getRootPanel());
            mainWindow.validate();
        });
    }
}
