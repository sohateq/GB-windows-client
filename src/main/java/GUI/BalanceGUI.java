package GUI;

import javax.swing.*;
import java.awt.*;

public class BalanceGUI extends JFrame {
    private JButton backButton;
    private JPanel RootPanel;
    private JLabel stairsFrameLabel;
    private JLabel passFrameLabel;
    private JLabel diagonalConnectionLabel;
    private JLabel horizontalConnectionLabel;
    private JLabel crossbarLabel;
    private JLabel deckLabel;
    private JLabel supportLabel;
    private JTextField stairsFrameCountTextField;
    private JTextField passFrameCountTextField;
    private JTextField diagonalConnectionCountTextField;
    private JTextField horizontalConnectionCountTextField;
    private JTextField crossbarCountTextField;
    private JTextField deckCountTextField;
    private JTextField supportCountTextField;
    private JTextField stairsFrameBadCountTextField;
    private JTextField passFrameBadCountTextField;
    private JTextField diagonalConnectionBadCountTextField;
    private JTextField horizontalConnectionBadCountTextField;
    private JTextField crossbarBarCountLabel;
    private JTextField deckBadCountTextField;
    private JTextField supportBadCountTextField;
    private JButton inventoryButton;
    private JTextField stairsFrameBuyingPriceTextField;
    private JTextField passFrameBuyingPriceTextField;
    private JTextField diagonalConnectionBuyingPriceTextField;
    private JTextField horizontalConnectionBuyingPriceTextField;
    private JTextField crossbarBuyingPryceLabel;
    private JTextField deckBuyingPriceTextField;
    private JTextField supportBuyingPriceTextField;
    private JTextField stairsFrameWeightTextField;
    private JTextField passFrameWeightTextField;
    private JTextField diagonalConnectionWeightTextField;
    private JTextField horizontalConnectionWeightTextField;
    private JTextField crossbarWeightTextField;
    private JTextField deckWeightTextField;
    private JTextField supportWeightTextField;
    private JLabel countLabel;
    private JLabel defectiveCountLabel;
    private JLabel weightLabel;
    private JLabel buyingPriceLabel;

    public BalanceGUI() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
