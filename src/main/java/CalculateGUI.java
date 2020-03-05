import com.google.gson.annotations.Expose;
import retrofitModel.entity.StorageOperation;

import javax.swing.*;
import java.util.List;

public class CalculateGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JTextField heightField;
    private JTextField lengthField;
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
    private ElementScaffold[] balance;

    public CalculateGUI(MainWindow mainWindow, JFrame fromWindow) {
        this.mainWindow = mainWindow;
        this.fromWindow = fromWindow;
        this.balance = DataBaseController.getBalance();
        setContentPane(RootPanel);
        fillComboBoxes();
        setBackButtonAction();
        setCalcButtonAction();
        setElementCalcButtonAction();
        setCreateShipmentButtonAction();
    }

    private void setBackButtonAction() {
        backButton.addActionListener(e -> {
            mainWindow.setContentPane(fromWindow.getContentPane());
            mainWindow.validate();
        });
    }

    private void setCalcButtonAction () {
        calcButton.addActionListener(e -> calculate());
    }

    private void setElementCalcButtonAction () {
        elementCalcButton.addActionListener(e -> elementsCalculate());
    }

    private void setCreateShipmentButtonAction () {
        createShipmentButton.addActionListener(e -> createOperation());
    }

    private void calculate () {
        try {
            int height = Integer.parseInt(heightField.getText());
            int length = Integer.parseInt(lengthField.getText());
            double squareMeterCost = Double.parseDouble(costField.getText());
            if (height%2 == 1) height++;
            if (length%3 == 2) length++;
            if (length%3 == 1) length--;
            int levelCount = height/2;
            int sectionCount = length/3;
            int liftCount = 1 + (length/30);
            int deckLevelCount = 1;
            if (levelCount - 1 > 0) deckLevelCount = levelCount - 1;
            int stairsFrameCount = (levelCount-1) * liftCount;
            int passFrameCount = levelCount * ((sectionCount + 1) - liftCount) + liftCount;
            int diagonalConnectionCount = ((height/3) * (length/2))/2;
            int horizontalConnectionCount = diagonalConnectionCount * 3;
            int crossbarCount = deckLevelCount * sectionCount * 2;
            int deckCount = sectionCount * deckLevelCount * 3;
            int supportCount = (sectionCount + 1) * 2;
            double costPerDay = height * length * squareMeterCost;

            double stairsFrameUnitWeight = balance[0].getWeight();
            double stairsFrameTotalWeight = stairsFrameUnitWeight * stairsFrameCount;
            double stairsFrameUnitCost = (balance[0].getBuyingPrice()/100) * 115;
            double stairsFrameTotalCost = stairsFrameUnitCost * stairsFrameCount;

            double passFrameUnitWeight = balance[1].getWeight();
            double passFrameTotalWeight = passFrameUnitWeight * passFrameCount;
            double passFrameUnitCost = (balance[1].getBuyingPrice()/100) * 115;
            double passFrameTotalCost = passFrameUnitCost * passFrameCount;

            double diagonalConnectionUnitWeight = balance[2].getWeight();
            double diagonalConnectionTotalWeight = diagonalConnectionUnitWeight * diagonalConnectionCount;
            double diagonalConnectionUnitCost = (balance[2].getBuyingPrice()/100) * 115;
            double diagonalConnectionTotalCost = diagonalConnectionUnitCost * diagonalConnectionCount;

            double horizontalConnectionUnitWeight = balance[3].getWeight();
            double horizontalConnectionTotalWeight = horizontalConnectionUnitWeight * horizontalConnectionCount;
            double horizontalConnectionUnitCost = (balance[3].getBuyingPrice()/100) * 115;
            double horizontalConnectionTotalCost = horizontalConnectionUnitCost * horizontalConnectionCount;

            double crossbarUnitWeight = balance[4].getWeight();
            double crossbarTotalWeight = crossbarUnitWeight * crossbarCount;
            double crossbarUnitCost = (balance[4].getBuyingPrice()/100) * 115;
            double crossbarTotalCost = crossbarUnitCost * crossbarCount;

            double deckUnitWeight = balance[5].getWeight();
            double deckTotalWeight = deckUnitWeight * deckCount;
            double deckUnitCost = (balance[5].getBuyingPrice()/100) * 115;
            double deckTotalCost = deckUnitCost * deckCount;

            double supportUnitWeight = balance[6].getWeight();
            double supportTotalWeight = supportUnitWeight * supportCount;
            double supportUnitCost = (balance[6].getBuyingPrice()/100) * 115;
            double supportTotalCost = supportUnitCost * supportCount;

            double constructionTotalCoast = stairsFrameTotalCost + passFrameTotalCost + diagonalConnectionTotalCost + horizontalConnectionTotalCost +
                    crossbarTotalCost + deckTotalCost + supportTotalCost;

            rentCostTextField.setText(String.format("%.2f", (costPerDay * 30)) + " / " + String.format("%.2f", costPerDay));
            depositTextField.setText(((constructionTotalCoast/10)*4) + "");
            sellCostTextField.setText(String.format("%.2f", constructionTotalCoast) + " / " + String.format("%.2f", ((constructionTotalCoast/10)*7)));

            stairsFrameCountTextField.setText(stairsFrameCount + "");
            stairsFrameUnitWeightTextField.setText(String.format("%.1f", stairsFrameUnitWeight));
            stairsFrameTotalWeightTextField.setText(String.format("%.1f", stairsFrameTotalWeight));
            stairsFrameUnitCostTextField.setText(String.format("%.2f", stairsFrameUnitCost));
            stairsFrameTotalCostTextField.setText(String.format("%.2f", stairsFrameTotalCost));

            passFrameCountTextField.setText(passFrameCount + "");
            passFrameUnitWeightTextField.setText(String.format("%.1f", passFrameUnitWeight));
            passFrameTotalWeightTextField.setText(String.format("%.1f", passFrameTotalWeight));
            passFrameUnitCostTextField.setText(String.format("%.2f", passFrameUnitCost));
            passFrameTotalCostTextField.setText(String.format("%.2f", passFrameTotalCost));

            diagonalConnectionCountTextField.setText(diagonalConnectionCount + "");
            diagonalConnectionUnitWeightTextField.setText(String.format("%.1f", diagonalConnectionUnitWeight));
            diagonalConnectionTotalWeightTextField.setText(String.format("%.1f", diagonalConnectionTotalWeight));
            diagonalConnectionUnitCostTextField.setText(String.format("%.2f", diagonalConnectionUnitCost));
            diagonalConnectionTotalCostTextField.setText(String.format("%.2f", diagonalConnectionTotalCost));

            horizontalConnectionCountTextField.setText(horizontalConnectionCount + "");
            horizontalConnectionUnitWeightTextField.setText(String.format("%.1f", horizontalConnectionUnitWeight));
            horizontalConnectionTotalWeightTextField.setText(String.format("%.1f", horizontalConnectionTotalWeight));
            horizontalConnectionUnitCostTextField.setText(String.format("%.2f", horizontalConnectionUnitCost));
            horizontalConnectionTotalCostTextField.setText(String.format("%.2f", horizontalConnectionTotalCost));

            crossbarCountTextField.setText(crossbarCount + "");
            crossbarUnitWeightTextField.setText(String.format("%.1f", crossbarUnitWeight));
            crossbarTotalWeightTextField.setText(String.format("%.1f", crossbarTotalWeight));
            crossbarUnitCostTextField.setText(String.format("%.2f", crossbarUnitCost));
            crossbarTotalCostTextField.setText(String.format("%.2f", crossbarTotalCost));

            deckCountTextField.setText(deckCount + "");
            deckUnitWeightTextField.setText(deckUnitWeight + "");
            deckTotalWeightTextField.setText(deckTotalWeight + "");
            deckUnitCostTextField.setText(String.format("%.2f", deckUnitCost));
            deckTotalCostTextField.setText(String.format("%.2f", deckTotalCost));

            supportCountTextField.setText(supportCount + "");
            supportUnitWeightTextField.setText(supportUnitWeight + "");
            supportTotalWeightTextField.setText(supportTotalWeight + "");
            supportUnitCostTextField.setText(String.format("%.2f", supportUnitCost));
            supportTotalCostTextField.setText(String.format("%.2f", supportTotalCost));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "В поля могут быть введены только числа! \n Дробные значения пишите через точку!", "Предупреждение", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void elementsCalculate () {
        try {
            int stairsFrameCount = Integer.parseInt(stairsFrameCountTextField.getText());
            int passFrameCount = Integer.parseInt(passFrameCountTextField.getText());
            int diagonalConnectionCount = Integer.parseInt(diagonalConnectionCountTextField.getText());
            int horizontalConnectionCount = Integer.parseInt(horizontalConnectionCountTextField.getText());
            int crossbarCount = Integer.parseInt(crossbarCountTextField.getText());
            int deckCount = Integer.parseInt(deckCountTextField.getText());
            int supportCount = Integer.parseInt(supportCountTextField.getText());

            double stairsFrameUnitWeight = balance[0].getWeight();
            double stairsFrameTotalWeight = stairsFrameUnitWeight * stairsFrameCount;
            double stairsFrameUnitCost = (balance[0].getBuyingPrice()/100) * 115;
            double stairsFrameTotalCost = stairsFrameUnitCost * stairsFrameCount;

            double passFrameUnitWeight = balance[1].getWeight();
            double passFrameTotalWeight = passFrameUnitWeight * passFrameCount;
            double passFrameUnitCost = (balance[1].getBuyingPrice()/100) * 115;
            double passFrameTotalCost = passFrameUnitCost * passFrameCount;

            double diagonalConnectionUnitWeight = balance[2].getWeight();
            double diagonalConnectionTotalWeight = diagonalConnectionUnitWeight * diagonalConnectionCount;
            double diagonalConnectionUnitCost = (balance[2].getBuyingPrice()/100) * 115;
            double diagonalConnectionTotalCost = diagonalConnectionUnitCost * diagonalConnectionCount;

            double horizontalConnectionUnitWeight = balance[3].getWeight();
            double horizontalConnectionTotalWeight = horizontalConnectionUnitWeight * horizontalConnectionCount;
            double horizontalConnectionUnitCost = (balance[3].getBuyingPrice()/100) * 115;
            double horizontalConnectionTotalCost = horizontalConnectionUnitCost * horizontalConnectionCount;

            double crossbarUnitWeight = balance[4].getWeight();
            double crossbarTotalWeight = crossbarUnitWeight * crossbarCount;
            double crossbarUnitCost = (balance[4].getBuyingPrice()/100) * 115;
            double crossbarTotalCost = crossbarUnitCost * crossbarCount;

            double deckUnitWeight = balance[5].getWeight();
            double deckTotalWeight = deckUnitWeight * deckCount;
            double deckUnitCost = (balance[5].getBuyingPrice()/100) * 115;
            double deckTotalCost = deckUnitCost * deckCount;

            double supportUnitWeight = balance[6].getWeight();
            double supportTotalWeight = supportUnitWeight * supportCount;
            double supportUnitCost = (balance[6].getBuyingPrice()/100) * 115;
            double supportTotalCost = supportUnitCost * supportCount;


            double constructionTotalCoast = stairsFrameTotalCost + passFrameTotalCost + diagonalConnectionTotalCost + horizontalConnectionTotalCost +
                    crossbarTotalCost + deckTotalCost + supportTotalCost;

            rentCostTextField.setText(String.format("%.2f", (constructionTotalCoast / 10)) + " / " + String.format("%.2f", (constructionTotalCoast / 300)));
            depositTextField.setText(String.format("%.2f", ((constructionTotalCoast/10)*4)));
            sellCostTextField.setText(String.format("%.2f", constructionTotalCoast) + " / " + String.format("%.2f", ((constructionTotalCoast/10)*7)));

            stairsFrameCountTextField.setText(stairsFrameCount + "");
            stairsFrameUnitWeightTextField.setText(String.format("%.1f", stairsFrameUnitWeight));
            stairsFrameTotalWeightTextField.setText(String.format("%.1f", stairsFrameTotalWeight));
            stairsFrameUnitCostTextField.setText(String.format("%.2f", stairsFrameUnitCost));
            stairsFrameTotalCostTextField.setText(String.format("%.2f", stairsFrameTotalCost));

            passFrameCountTextField.setText(passFrameCount + "");
            passFrameUnitWeightTextField.setText(String.format("%.1f", passFrameUnitWeight));
            passFrameTotalWeightTextField.setText(String.format("%.1f", passFrameTotalWeight));
            passFrameUnitCostTextField.setText(String.format("%.2f", passFrameUnitCost));
            passFrameTotalCostTextField.setText(String.format("%.2f", passFrameTotalCost));

            diagonalConnectionCountTextField.setText(diagonalConnectionCount + "");
            diagonalConnectionUnitWeightTextField.setText(String.format("%.1f", diagonalConnectionUnitWeight));
            diagonalConnectionTotalWeightTextField.setText(String.format("%.1f", diagonalConnectionTotalWeight));
            diagonalConnectionUnitCostTextField.setText(String.format("%.2f", diagonalConnectionUnitCost));
            diagonalConnectionTotalCostTextField.setText(String.format("%.2f", diagonalConnectionTotalCost));

            horizontalConnectionCountTextField.setText(horizontalConnectionCount + "");
            horizontalConnectionUnitWeightTextField.setText(String.format("%.1f", horizontalConnectionUnitWeight));
            horizontalConnectionTotalWeightTextField.setText(String.format("%.1f", horizontalConnectionTotalWeight));
            horizontalConnectionUnitCostTextField.setText(String.format("%.2f", horizontalConnectionUnitCost));
            horizontalConnectionTotalCostTextField.setText(String.format("%.2f", horizontalConnectionTotalCost));

            crossbarCountTextField.setText(crossbarCount + "");
            crossbarUnitWeightTextField.setText(String.format("%.1f", crossbarUnitWeight));
            crossbarTotalWeightTextField.setText(String.format("%.1f", crossbarTotalWeight));
            crossbarUnitCostTextField.setText(String.format("%.2f", crossbarUnitCost));
            crossbarTotalCostTextField.setText(String.format("%.2f", crossbarTotalCost));

            deckCountTextField.setText(deckCount + "");
            deckUnitWeightTextField.setText(deckUnitWeight + "");
            deckTotalWeightTextField.setText(deckTotalWeight + "");
            deckUnitCostTextField.setText(String.format("%.2f", deckUnitCost));
            deckTotalCostTextField.setText(String.format("%.2f", deckTotalCost));

            supportCountTextField.setText(supportCount + "");
            supportUnitWeightTextField.setText(supportUnitWeight + "");
            supportTotalWeightTextField.setText(supportTotalWeight + "");
            supportUnitCostTextField.setText(String.format("%.2f", supportUnitCost));
            supportTotalCostTextField.setText(String.format("%.2f", supportTotalCost));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "В поля могут быть введены только числа! \n Дробные значения пишите через точку!", "Предупреждение", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createOperation () {
        String date = yearComboBox.getSelectedItem().toString() + "-" + monthComboBox.getSelectedItem().toString() + "-" + dayComboBox.getSelectedItem().toString();
        String customerName = customersComboBox.getSelectedItem().toString();
        String type = "отгрузка";
        int stairsFrameCount = Integer.parseInt(stairsFrameCountTextField.getText());
        int passFrameCount = Integer.parseInt(passFrameCountTextField.getText());
        int diagonalConnectionCount = Integer.parseInt(diagonalConnectionCountTextField.getText());
        int horizontalConnectionCount = Integer.parseInt(horizontalConnectionCountTextField.getText());
        int crossbarCount = Integer.parseInt(crossbarCountTextField.getText());
        int deckCount = Integer.parseInt(deckCountTextField.getText());
        int supportCount = Integer.parseInt(supportCountTextField.getText());
        int stairsFrameBadCount = 0;
        int passFrameBadCount = 0;
        int diagonalConnectionBadCount = 0;
        int horizontalConnectionBadCount = 0;
        int crossbarBadCount = 0;
        int deckBadCount = 0;
        int supportBadCount = 0;
        boolean performed = false;
        StorageOperation operation = new StorageOperation(date, customerName, type, stairsFrameCount, passFrameCount, diagonalConnectionCount, horizontalConnectionCount, crossbarCount,
                deckCount, supportCount, stairsFrameBadCount, passFrameBadCount, diagonalConnectionBadCount, horizontalConnectionBadCount, crossbarBadCount, deckBadCount, supportBadCount, performed);
        DataBaseController.operationInsert(operation);
    }

    private void fillComboBoxes () {

        int year = 2019;
        for (int i = 0; i < 20; i++) {
            yearComboBox.addItem(year + "");
            year++;
        }

        for (int i = 0; i < 12; i++) {
            String month = String.format("%02d", (i+1));
            monthComboBox.addItem(month);
        }
        for (int i = 0; i < 31; i++) {
            String day = String.format("%02d", (i+1));
            dayComboBox.addItem(day);
        }

        List<String> customers = DataBaseController.getCustomers();
        customersComboBox.addItem("");
        for (int i = 0; i < customers.size(); i++) {
            customersComboBox.addItem(customers.get(i));
        }
    }
}
