package GUI;

import javax.swing.*;

public class OperationsListGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JList operationsList;
    private JScrollPane operationsScrollPane;
    private JLabel filterLabel;
    private JLabel periodLabel;
    private JLabel customerComboBoxLabel;
    private JLabel typeComboBoxLabel;
    private JComboBox customersComboBox;
    private JComboBox typeComboBox;
    private JLabel dashLabel;
    private JButton applyButton;
    private JButton resetButton;
    private JLabel infoLabel;
    private JLabel dateLabel;
    private JTextField dateTextField;
    private JLabel customerLabel;
    private JTextField customerTextField;
    private JLabel typeLabel;
    private JTextField typeTextField;
    private JComboBox startDayComboBox;
    private JComboBox startMonthComboBox;
    private JComboBox startYearComboBox;
    private JComboBox endDayComboBox;
    private JComboBox endMonthComboBox;
    private JComboBox endYearComboBox;
    private JComboBox statusComboBox;
    private JLabel statusComboBoxLabel;
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
    private JLabel statusLabel;
    private JTextField statusTextField;
    private JLabel stairsFrameBadCountLabel;
    private JLabel passFrameBadCountLabel;
    private JLabel diagonalConnectionBadCountLabel;
    private JLabel horizontalConnectionBadCountLabel;
    private JLabel crossbarBadCountLabel;
    private JLabel deckBadCountLabel;
    private JLabel supportBadCountLabel;
    private JTextField stairsFrameBadCountTextField;
    private JTextField passFrameBadCountTextField;
    private JTextField diagonalConnectionBadCountTextField;
    private JTextField horizontalConnectionBadCountTextField;
    private JTextField crossbarBadCountTextField;
    private JTextField deckBadCountTextField;
    private JTextField supportBadCountTextField;

    public OperationsListGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
