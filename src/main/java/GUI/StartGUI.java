package GUI;

import javax.swing.*;

public class StartGUI extends JFrame {
    private JButton managerButton;
    private JButton storageButton;
    private JPanel RootPanel;
    private MainWindow mainWindow;

    public StartGUI(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setContentPane(RootPanel);
        setManagerButtonAction();
        setStorageButtonAction();
    }

    private void setManagerButtonAction () {
        managerButton.addActionListener(e -> {
            mainWindow.setContentPane(new ManagerGUI(mainWindow).getContentPane());
            mainWindow.validate();
        });
    }

    private void setStorageButtonAction() {
        storageButton.addActionListener(e -> {
            mainWindow.setContentPane(new StorageGUI(mainWindow).getContentPane());
            mainWindow.validate();
        });
    }
}
