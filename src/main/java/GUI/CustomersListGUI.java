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
    private JTable contentTable;
    private JList operationsList;
    private JScrollPane operationsScrollPane;
    private JLabel operationsContentLabel;
    private JLabel customerBalanceLabel;
    private JTable table1;
    private JPanel rootPane;
    private JScrollPane customersListScrollPane;

    public CustomersListGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400, 100, 700, 800);
        setContentPane(rootPane);
        setVisible(true);
    }
}
