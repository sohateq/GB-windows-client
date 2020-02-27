package GUI;

import javax.swing.*;
import java.awt.*;

public class CreateOperationGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JLabel customerLabel;
    private JComboBox customerComboBox;
    private JLabel dateLabel;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JLabel typeLabel;
    private JComboBox typeComboBox;
    private JPanel InfoPane;
    private JLabel stairsFrameCountLabel;
    private JLabel passFrameCountLabel;
    private JLabel diagonalConnectionCountLabel;
    private JLabel horizontalConnectionCountLabel;
    private JLabel crossbarCountLabel;
    private JLabel deckCountLabel;
    private JLabel supportCountLabel;
    private JTextField stairsFrameCountTextField;
    private JTextField passFrameCountTextField;
    private JTextField diagonalConnectionCountTextField;
    private JTextField horizontalConnectionCountTextField;
    private JTextField crossbarCountTextField;
    private JTextField deckCountTextField;
    private JTextField supportCountTextField;
    private JButton createButton;
    private JTextField stairsFrameDefectiveCountTextField;
    private JTextField passFrameDefectiveCountTextField;
    private JTextField diagonalConnectionDefecviveCountTextField;
    private JTextField horizontalConnectionDefectiveCountTextField;
    private JTextField crossbarDefectiveCountTextField;
    private JTextField deckDefectiveCountTextField;
    private JTextField supportDefectiveCountTextField;
    private JLabel countLabel;
    private JLabel defectiveCountLabel;
    private MainWindow mainWindow;
    private JFrame fromWindow;

    public CreateOperationGUI(MainWindow mainWindow, JFrame fromWindow) throws HeadlessException {
        this.mainWindow = mainWindow;
        this.fromWindow = fromWindow;
        setContentPane(RootPanel);
        setBackButtonAction();
    }

    private void setBackButtonAction() {
        backButton.addActionListener(e -> {
            mainWindow.setContentPane(fromWindow.getContentPane());
            mainWindow.validate();
        });
    }


}
