package GUI;

import javax.swing.*;

public class CustomersListGUI extends JFrame {
    private JButton backButton;
    private JTextField searchTextField;
    private JButton searchButton;
    private JList customersList;
    private JLabel nameCustomerLabel;
    private JLabel phoneCustomerLabel;
    private JLabel addressCustomerLabel;
    private JLabel operationsLabel;
    private JTextArea nameCustomerTextArea;
    private JTextArea phoneCustomerTextArea;
    private JTextArea addressCustomerTextArea;
    private JList operationsList;
    private JScrollPane operationsScrollPane;
    private JLabel operationsContentLabel;
    private JLabel customerBalanceLabel;
    private JPanel rootPane;
    private JScrollPane customersListScrollPane;
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
    private JPanel CustomersBalance;
    private JLabel stairsFrameBalanceLabel;
    private JLabel passFrameBalanceLabel;
    private JLabel diagonalConnectionBalanceLabel;
    private JLabel horizontalConnectionBalanceLabel;
    private JLabel crossbarBalanceLabel;
    private JLabel deckBalanceLabel;
    private JLabel supportBalanceLabel;
    private JTextField stairsFrameBalanceTextField;
    private JTextField passFrameBalanceTextField;
    private JTextField diagonalConnectionBalanceTextField;
    private JTextField horizontalConnectionBalanceTextField;
    private JTextField crossbarBalanceTextField;
    private JTextField deckBalanceTextField;
    private JTextField supportBalanceTextField;

    public CustomersListGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setContentPane(rootPane);
        setVisible(true);
    }
}
