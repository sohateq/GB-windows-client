import retrofitModel.entity.StorageOperation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
    private JButton shipButton;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JButton updateButton;
    private MainWindow mainWindow;
    private JFrame fromWindow;
    private StorageOperation currentOperation;

    public ShipmentListGUI(MainWindow mainWindow, JFrame fromWindow) throws HeadlessException {
        this.mainWindow = mainWindow;
        this.fromWindow = fromWindow;
        fillComboBoxes();
        fillShipmentList();
        setContentPane(RootPanel);
        setBackButtonAction();
        setShipButtonAction();
        setUpdateButtonAction();
    }

    private void setBackButtonAction() {
        backButton.addActionListener(e -> {
            mainWindow.setContentPane(fromWindow.getContentPane());
            mainWindow.validate();
        });
    }

    private void setShipButtonAction () {
        shipButton.addActionListener(e -> performOperation());
    }

    private void setUpdateButtonAction () {
        updateButton.addActionListener(e -> fillShipmentList());
    }

    private void fillShipmentList() {
        shipmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel<StorageOperation> listModel = new DefaultListModel<>();
        List<StorageOperation> operations = DataBaseController.getOperations(null, null, null, "отгрузка", false);
        for (int i = 0; i < operations.size(); i++) {
            listModel.addElement(operations.get(i));
        }
        shipmentList.setModel(listModel);
        shipmentList.clearSelection();
        dayComboBox.setSelectedItem("");
        monthComboBox.setSelectedItem("");
        yearComboBox.setSelectedItem("");
        customerTextField.setText("");
        stairsFrameCountTextField.setText("");
        passFrameCountTextField.setText("");
        diagonalConnectionCountTextField.setText("");
        horizontalConnectionCountTextField.setText("");
        crossbarCountTextField.setText("");
        deckCountTextField.setText("");
        supportCountTextField.setText("");
        shipmentList.addListSelectionListener(e -> {
            this.currentOperation = (StorageOperation) shipmentList.getSelectedValue();
            String date = currentOperation.getDate();
            String [] dateArr = date.split("-");
            dayComboBox.setSelectedItem(dateArr[2]);
            monthComboBox.setSelectedItem(dateArr[1]);
            yearComboBox.setSelectedItem(dateArr[0]);
            customerTextField.setText(currentOperation.getCustomerName());
            stairsFrameCountTextField.setText(currentOperation.getStairsFrameCount().toString());
            passFrameCountTextField.setText(currentOperation.getPassFrameCount().toString());
            diagonalConnectionCountTextField.setText(currentOperation.getDiagonalConnectionCount().toString());
            horizontalConnectionCountTextField.setText(currentOperation.getHorizontalConnectionCount().toString());
            crossbarCountTextField.setText(currentOperation.getCrossbarCount().toString());
            deckCountTextField.setText(currentOperation.getDeckCount().toString());
            supportCountTextField.setText(currentOperation.getSupportsCount().toString());
        });
    }

    private void fillComboBoxes () {

        int year = 2019;
        yearComboBox.addItem("");
        for (int i = 0; i < 20; i++) {
            yearComboBox.addItem(year + "");
            year++;
        }
        monthComboBox.addItem("");
        for (int i = 0; i < 12; i++) {
            String month = String.format("%02d", (i+1));
            monthComboBox.addItem(month);
        }
        dayComboBox.addItem("");
        for (int i = 0; i < 31; i++) {
            String day = String.format("%02d", (i+1));
            dayComboBox.addItem(day);
        }

    }

    private void performOperation () {
        int idOperation = this.currentOperation.getId();
        String date = yearComboBox.getSelectedItem().toString() + "-" + monthComboBox.getSelectedItem().toString() + "-" + dayComboBox.getSelectedItem().toString();
        String customerName = customerTextField.getText();
        String type = this.currentOperation.getType();
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
        boolean performed = true;
        StorageOperation performingOperation = new StorageOperation(idOperation, date, customerName, type, stairsFrameCount, passFrameCount, diagonalConnectionCount, horizontalConnectionCount, crossbarCount,
                deckCount, supportCount, stairsFrameBadCount, passFrameBadCount, diagonalConnectionBadCount, horizontalConnectionBadCount, crossbarBadCount, deckBadCount, supportBadCount, performed);
        DataBaseController.performOperation(performingOperation);
        JOptionPane.showMessageDialog(this,
                "Отгрузка помечана, как \"исполнено\".",
                "Сообщение",
                JOptionPane.INFORMATION_MESSAGE);
        shipmentList.clearSelection();
        dayComboBox.setSelectedItem("");
        monthComboBox.setSelectedItem("");
        yearComboBox.setSelectedItem("");
        customerTextField.setText("");
        stairsFrameCountTextField.setText("");
        passFrameCountTextField.setText("");
        diagonalConnectionCountTextField.setText("");
        horizontalConnectionCountTextField.setText("");
        crossbarCountTextField.setText("");
        deckCountTextField.setText("");
        supportCountTextField.setText("");
    }
}
