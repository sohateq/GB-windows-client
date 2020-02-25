package GUI;

import javax.swing.*;
import java.awt.*;

public class ShipmentListGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JScrollPane sipmentListScrollPane;
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

    public ShipmentListGUI() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
