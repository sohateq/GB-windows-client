import javax.swing.*;

public class CalculateGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JTextField heightField;
    private JTextField lenghtField;
    private JTextField costField;
    private JLabel heightLabel;
    private JLabel lengthLabel;
    private JLabel costOfMeterPerDayLabel;
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
    private JLabel countLabel;
    private JLabel unitWeightLabel;
    private JTextField stairsFrameUnitWeightTextField;
    private JTextField passFrameUnitWeightTextField;
    private JTextField diagonalConnectionUnitWeightTextField;
    private JTextField horizontalConnectionUnitWeightTextField;
    private JTextField crossbarUnitWeightTextField;
    private JTextField deckUnitWeightTextField;
    private JTextField supportUnitWeightTextField;
    private JLabel totalWeightLabel;
    private JTextField stairsFrameTotalWeightTextField;
    private JTextField passFrameTotalWeightTextField;
    private JTextField diagonalConnectionTotalWeightTextField;
    private JTextField horizontalConnectionTotalWeightTextField;
    private JTextField crossbarTotalWeightTextField;
    private JTextField deckTotalWeightTextField;
    private JTextField supportTotalWeightTextField;
    private JLabel unitCostLabel;
    private JTextField stairsFrameUnitCostTextField;
    private JTextField passFrameUnitCostTextField;
    private JTextField diagonalConnectionUnitCostTextField;
    private JTextField horizontalConnectionUnitCostTextField;
    private JTextField crossbarUnitCostTextField;
    private JTextField deckUnitCostTextField;
    private JTextField supportUnitCostTextField;
    private JLabel totalCostLabel;
    private JTextField stairsFrameTotalCostTextField;
    private JTextField passFrameTotalCostTextField;
    private JTextField diagonalConnectionTotalCostTextField;
    private JTextField horizontalConnectionTotalCostTextField;
    private JTextField crossbarTotalCostTextField;
    private JTextField deckTotalCostTextField;
    private JTextField supportTotalCostTextField;
    private MainWindow mainWindow;
    private JFrame fromWindow;

    public CalculateGUI(MainWindow mainWindow, JFrame fromWindow) {
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
