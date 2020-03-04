import javax.swing.*;
import java.awt.*;

public class ShipmentListGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JScrollPane shipmentListScrollPane;
    private JList shipmentList;
    private JLabel infoLabel;
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
    private JLabel customerLabel;
    private JTextField customerTextField;
    private JLabel dateLabel;
    private JTextField dateTextField;
    private JButton ShipButton;
    private MainWindow mainWindow;
    private JFrame fromWindow;

    public ShipmentListGUI(MainWindow mainWindow, JFrame fromWindow) throws HeadlessException {
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
