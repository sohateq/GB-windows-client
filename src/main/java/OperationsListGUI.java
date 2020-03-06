import retrofitModel.entity.StorageOperation;

import javax.swing.*;
import java.util.List;

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
    private JButton deleteOperationButton;
    private MainWindow mainWindow;
    private JFrame fromWindow;

    public OperationsListGUI(MainWindow mainWindow, JFrame fromWindow) {
        this.mainWindow = mainWindow;
        this.fromWindow = fromWindow;
        fillComboBoxes();
        fillOperationsList();
        setContentPane(RootPanel);
        setBackButtonAction();
        setApplyButtonAction();
        setResetButtonAction();
        setDeleteOperationButtonAction();
    }

    private void setBackButtonAction() {
        backButton.addActionListener(e -> {
            mainWindow.setContentPane(fromWindow.getContentPane());
            mainWindow.validate();
        });
    }

    private void setApplyButtonAction () {
        applyButton.addActionListener(e -> fillOperationsList());
    }

    private void setResetButtonAction () {
        resetButton.addActionListener(e -> setEmptyComboBoxes());
    }

    private void setDeleteOperationButtonAction () {
        deleteOperationButton.addActionListener(e -> {
            int sure = JOptionPane.showConfirmDialog(this, "Вы уверенны, что хотите удалить операцию? \n Удаленную операцию нельзя востановить!",
                    "Предупреждение", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (sure == JOptionPane.YES_OPTION) {
                ListModel<StorageOperation> listModel = operationsList.getModel();
                int index = operationsList.getSelectedIndex();
                StorageOperation operation = listModel.getElementAt(index);
                DataBaseController.deleteOperation(operation);
                dateTextField.setText("");
                customerTextField.setText("");
                typeTextField.setText("");
                statusTextField.setText("");
                stairsFrameCountTextField.setText("");
                passFrameCountTextField.setText("");
                diagonalConnectionCountTextField.setText("");
                horizontalConnectionCountTextField.setText("");
                crossbarCountTextField.setText("");
                deckCountTextField.setText("");
                supportCountTextField.setText("");
                stairsFrameBadCountTextField.setText("");
                passFrameBadCountTextField.setText("");
                diagonalConnectionBadCountTextField.setText("");
                horizontalConnectionBadCountTextField.setText("");
                crossbarBadCountTextField.setText("");
                deckBadCountTextField.setText("");
                supportBadCountTextField.setText("");
                setEmptyComboBoxes();
                fillOperationsList();
                deleteOperationButton.setVisible(false);
            }
        });
    }

    private void fillOperationsList () {
        operationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel<StorageOperation> listModel = new DefaultListModel<>();
        List<StorageOperation> operations;
        String startYear = (String) startYearComboBox.getSelectedItem();
        String startMonth = (String) startMonthComboBox.getSelectedItem();
        String startDay = (String) startDayComboBox.getSelectedItem();
        String startDate = null;
        if (!startYear.isEmpty() && !startMonth.isEmpty() && !startDay.isEmpty()) {
            startDate = startYear + "-" + startMonth + "-" + startDay;
        }
        String endYear = (String) endYearComboBox.getSelectedItem();
        String endMonth = (String) endMonthComboBox.getSelectedItem();
        String endDay = (String) endDayComboBox.getSelectedItem();
        String endDate = null;
        if (!endYear.isEmpty() && !endMonth.isEmpty() && !endDay.isEmpty()) {
            endDate = endYear + "-" + endMonth + "-" + endDay;
        }
        String customer = (String) customersComboBox.getSelectedItem();
        if (customer.isEmpty()) {
            customer = null;
        }
        String type = (String) typeComboBox.getSelectedItem();
        if (type.isEmpty()) {
            type = null;
        }
        String status = (String) statusComboBox.getSelectedItem();
        if (status.isEmpty()) {
            operations = DataBaseController.getOperations(startDate, endDate, customer, type);

        } else {
            if (status.equalsIgnoreCase("проведено")) {
                operations = DataBaseController.getOperations(startDate, endDate, customer, type, true);
            } else {
                operations = DataBaseController.getOperations(startDate, endDate, customer, type, false);
            }
        }
        for (int i = 0; i < operations.size(); i++) {
            listModel.addElement(operations.get(i));
        }
        operationsList.setModel(listModel);
        operationsList.addListSelectionListener(e -> {
            int index = operationsList.getSelectedIndex();
            StorageOperation operation = listModel.getElementAt(index);
            dateTextField.setText(operation.getDate());
            customerTextField.setText(operation.getCustomerName());
            typeTextField.setText(operation.getType());
            String operationStatus = "проведено";
            deleteOperationButton.setVisible(false);
            if (!operation.getPerformed()) {
                operationStatus = "не проведено";
                deleteOperationButton.setVisible(true);
            }
            statusTextField.setText(operationStatus);
            stairsFrameCountTextField.setText(operation.getStairsFrameCount().toString());
            passFrameCountTextField.setText(operation.getPassFrameCount().toString());
            diagonalConnectionCountTextField.setText(operation.getDiagonalConnectionCount().toString());
            horizontalConnectionCountTextField.setText(operation.getHorizontalConnectionCount().toString());
            crossbarCountTextField.setText(operation.getCrossbarCount().toString());
            deckCountTextField.setText(operation.getDeckCount().toString());
            supportCountTextField.setText(operation.getSupportsCount().toString());
            stairsFrameBadCountTextField.setText(operation.getStairsFrameBadCount().toString());
            passFrameBadCountTextField.setText(operation.getPassFrameBadCount().toString());
            diagonalConnectionBadCountTextField.setText(operation.getDiagonalConnectionBadCount().toString());
            horizontalConnectionBadCountTextField.setText(operation.getHorizontalConnectionBadCount().toString());
            crossbarBadCountTextField.setText(operation.getCrossbarBadCount().toString());
            deckBadCountTextField.setText(operation.getDeckBadCount().toString());
            supportBadCountTextField.setText(operation.getSupportsBadCount().toString());
        });
    }

    private void fillComboBoxes () {

        int year = 2019;
        startYearComboBox.addItem("");
        endYearComboBox.addItem("");
        for (int i = 0; i < 20; i++) {
            startYearComboBox.addItem(year + "");
            endYearComboBox.addItem(year + "");
            year++;
        }
        startMonthComboBox.addItem("");
        endMonthComboBox.addItem("");
        for (int i = 0; i < 12; i++) {
            String month = String.format("%02d", (i+1));
            startMonthComboBox.addItem(month);
            endMonthComboBox.addItem(month);
        }
        startDayComboBox.addItem("");
        endDayComboBox.addItem("");
        for (int i = 0; i < 31; i++) {
            String day = String.format("%02d", (i+1));
            startDayComboBox.addItem(day);
            endDayComboBox.addItem(day);
        }

        List<String> customers = DataBaseController.getCustomers();
        customersComboBox.addItem("");
        for (int i = 0; i < customers.size(); i++) {
            customersComboBox.addItem(customers.get(i));
        }

        List<String> types = DataBaseController.getTypes();
        typeComboBox.addItem("");
        for (int i = 0; i < types.size(); i++) {
            typeComboBox.addItem(types.get(i));
        }

        statusComboBox.addItem("");
        statusComboBox.addItem("проведено");
        statusComboBox.addItem("не проведено");
    }

    private void setEmptyComboBoxes () {
        startYearComboBox.setSelectedItem("");
        startMonthComboBox.setSelectedItem("");
        startDayComboBox.setSelectedItem("");
        endYearComboBox.setSelectedItem("");
        endMonthComboBox.setSelectedItem("");
        endDayComboBox.setSelectedItem("");
        customersComboBox.setSelectedItem("");
        typeComboBox.setSelectedItem("");
        statusComboBox.setSelectedItem("");
    }
}
