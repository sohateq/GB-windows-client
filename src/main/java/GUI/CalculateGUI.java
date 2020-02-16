package GUI;

import javax.swing.*;

public class CalculateGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JTable scaffoldingTable;
    private JTextField heightField;
    private JTextField lenghtField;
    private JTextField costField;
    private JLabel heightLabel;
    private JLabel lengthLabel;
    private JLabel costOfMeterPerDayLabel;
    private JScrollPane scaffoldingPane;
    private JButton calcButton;
    private JButton elementCalcButton;
    private JLabel rentCostLabel;
    private JLabel depositLabel;
    private JLabel sellCostLabel;
    private JTextField rentCostTextField;
    private JTextField depositTextField;
    private JTextField sellCostTextField;
    private JLabel customerLabel;
    private JComboBox customersComboBox;
    private JButton createShipmentButton;
    private JButton createCustomerButton;
    private JLabel dateLabel;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;

    public CalculateGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 100, 1700, 800);
        setContentPane(RootPanel);
        setVisible(true);
    }
}
