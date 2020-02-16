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
    private JTextField textField1;
    private JLabel customerLabel;
    private JTextField customerTextField;
    private JLabel typeLabel;
    private JTextField typeTextField;
    private JTable elementsTable;
    private JComboBox startDayComboBox;
    private JComboBox startMonthComboBox;
    private JComboBox startYearComboBox;
    private JComboBox endDayComboBox;
    private JComboBox endMonthComboBox;
    private JComboBox endYearComboBox;
    private JComboBox statusComboBox;
    private JLabel statusLabel;

    public OperationsListGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
