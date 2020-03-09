import retrofitModel.entity.StorageOperation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersListGUI extends JFrame {
    private JButton backButton;
    private JTextField searchTextField;
    private JButton searchButton;
    private JList customersList;
    private JLabel nameCustomerLabel;
    private JLabel operationsLabel;
    private JList operationsList;
    private JScrollPane operationsScrollPane;
    private JLabel operationsContentLabel;
    private JLabel customerBalanceLabel;
    private JPanel RootPanel;
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
    private JTextField nameCustomerTextField;
    private MainWindow mainWindow;
    private JFrame fromWindow;
    private List<String> customers;

    public CustomersListGUI(MainWindow mainWindow, JFrame fromWindow) {
        this.customers = DataBaseController.getCustomers();
        this.mainWindow = mainWindow;
        this.fromWindow = fromWindow;
        setContentPane(RootPanel);
        setBackButtonAction();
        setSearchButtonAction();
        fillCustomersList(this.customers);
    }

    private void setBackButtonAction() {
        backButton.addActionListener(e -> {
            mainWindow.setContentPane(fromWindow.getContentPane());
            mainWindow.validate();
        });
    }

    private void setSearchButtonAction () {
        searchButton.addActionListener(e -> searchCustomer());
    }

    private void fillCustomersList (List<String> customers) {
        customersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < customers.size(); i++) {
            listModel.addElement(customers.get(i));
        }
        customersList.setModel(listModel);
        customersList.addListSelectionListener(e -> {
            stairsFrameCountTextField.setText("0");
            passFrameCountTextField.setText("0");
            diagonalConnectionCountTextField.setText("0");
            horizontalConnectionCountTextField.setText("0");
            crossbarCountTextField.setText("0");
            deckCountTextField.setText("0");
            supportCountTextField.setText("0");
            stairsFrameBadCountTextField.setText("0");
            passFrameBadCountTextField.setText("0");
            diagonalConnectionBadCountTextField.setText("0");
            horizontalConnectionBadCountTextField.setText("0");
            crossbarBadCountTextField.setText("0");
            deckBadCountTextField.setText("0");
            supportBadCountTextField.setText("0");
            stairsFrameBalanceTextField.setText("0");
            passFrameBalanceTextField.setText("0");
            diagonalConnectionBalanceTextField.setText("0");
            horizontalConnectionBalanceTextField.setText("0");
            crossbarBalanceTextField.setText("0");
            deckBalanceTextField.setText("0");
            supportBalanceTextField.setText("0");

            int index = customersList.getSelectedIndex();
            String customerName = listModel.getElementAt(index);
            nameCustomerTextField.setText(customerName);
            fillOperationsList();
            calcCustomerBalance();
        });
    }

    private void fillOperationsList () {
        operationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultListModel<StorageOperation> listModel = new DefaultListModel<>();
        String customerName = nameCustomerTextField.getText();
        if (!customerName.isEmpty()) {
            List<StorageOperation> operations = DataBaseController.getOperations(null, null, customerName, null, true);
            for (int i = 0; i < operations.size(); i++) {
                listModel.addElement(operations.get(i));
            }
            operationsList.setModel(listModel);
            operationsList.addListSelectionListener(e -> {
                int index = operationsList.getSelectedIndex();
                StorageOperation operation = listModel.getElementAt(index);
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

    }

    private void calcCustomerBalance () {
        int stairsFrameCount = 0;
        int passFrameCount = 0;
        int diagonalConnectionCount = 0;
        int horizontalConnectionCount = 0;
        int crossbarCount = 0;
        int deckCount = 0;
        int supportCount = 0;
        StorageOperation operation;
        ListModel<StorageOperation> listModel = operationsList.getModel();
        for (int i = 0; i < listModel.getSize(); i++) {
            operation = listModel.getElementAt(i);
            if (operation.getType().equalsIgnoreCase("отгрузка")) {
                stairsFrameCount = stairsFrameCount + operation.getStairsFrameCount() + operation.getStairsFrameBadCount();
                passFrameCount = passFrameCount + operation.getPassFrameCount() + operation.getPassFrameBadCount();
                diagonalConnectionCount = diagonalConnectionCount + operation.getDiagonalConnectionCount() + operation.getDiagonalConnectionBadCount();
                horizontalConnectionCount = horizontalConnectionCount + operation.getHorizontalConnectionCount() + operation.getHorizontalConnectionBadCount();
                crossbarCount = crossbarCount + operation.getCrossbarCount() + operation.getCrossbarBadCount();
                deckCount = deckCount + operation.getDeckCount() + operation.getDeckBadCount();
                supportCount = supportCount + operation.getSupportsCount() + operation.getSupportsBadCount();
            } else {
                stairsFrameCount = stairsFrameCount - operation.getStairsFrameCount() - operation.getStairsFrameBadCount();
                passFrameCount = passFrameCount - operation.getPassFrameCount() - operation.getPassFrameBadCount();
                diagonalConnectionCount = diagonalConnectionCount - operation.getDiagonalConnectionCount() - operation.getDiagonalConnectionBadCount();
                horizontalConnectionCount = horizontalConnectionCount - operation.getHorizontalConnectionCount() - operation.getHorizontalConnectionBadCount();
                crossbarCount = crossbarCount - operation.getCrossbarCount() - operation.getCrossbarBadCount();
                deckCount = deckCount - operation.getDeckCount() - operation.getDeckBadCount();
                supportCount = supportCount - operation.getSupportsCount() - operation.getSupportsBadCount();
            }
            stairsFrameBalanceTextField.setText(stairsFrameCount + "");
            passFrameBalanceTextField.setText(passFrameCount + "");
            diagonalConnectionBalanceTextField.setText(diagonalConnectionCount + "");
            horizontalConnectionBalanceTextField.setText(horizontalConnectionCount + "");
            crossbarBalanceTextField.setText(crossbarCount + "");
            deckBalanceTextField.setText(deckCount + "");
            supportBalanceTextField.setText(supportCount + "");
        }
    }

    private void searchCustomer () {
        List<String> searchCustomers = new ArrayList<>();
        String search = searchTextField.getText().toLowerCase();
        if (!search.isEmpty()) {
            for (int i = 0; i < this.customers.size(); i++) {
                if (this.customers.get(i).toLowerCase().contains(search)) {
                    searchCustomers.add(this.customers.get(i));
                }
                fillCustomersList(searchCustomers);
            }
        } else {
            this.customers = DataBaseController.getCustomers();
            fillCustomersList(this.customers);
        }

    }
}
