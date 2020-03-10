import retrofitModel.entity.StorageOperation;

import javax.swing.*;
import java.awt.*;

public class CreateOperationGUI extends JFrame {
    private JPanel RootPanel;
    private JButton backButton;
    private JLabel customerLabel;
    private JComboBox customersComboBox;
    private JLabel dateLabel;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JLabel typeLabel;
    private JComboBox typeComboBox;
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
    private JButton createButton;
    private JTextField stairsFrameDefectiveCountTextField;
    private JTextField passFrameDefectiveCountTextField;
    private JTextField diagonalConnectionDefectiveCountTextField;
    private JTextField horizontalConnectionDefectiveCountTextField;
    private JTextField crossbarDefectiveCountTextField;
    private JTextField deckDefectiveCountTextField;
    private JTextField supportDefectiveCountTextField;
    private JLabel countLabel;
    private JLabel defectiveCountLabel;
    private MainWindow mainWindow;
    private JFrame fromWindow;

    public CreateOperationGUI(MainWindow mainWindow, JFrame fromWindow) throws HeadlessException {
        this.mainWindow = mainWindow;
        this.fromWindow = fromWindow;
        fillComboBoxes();
        setContentPane(RootPanel);
        setBackButtonAction();
        setCreateButtonAction();
    }

    private void setBackButtonAction() {
        backButton.addActionListener(e -> {
            mainWindow.setContentPane(fromWindow.getContentPane());
            mainWindow.validate();
        });
    }

    private void setCreateButtonAction () {
        createButton.addActionListener(e -> createOperation());
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

        java.util.List<String> customers = DataBaseController.getCustomers();
        customersComboBox.addItem("");
        for (int i = 0; i < customers.size(); i++) {
            customersComboBox.addItem(customers.get(i));
        }

        typeComboBox.addItem("отгрузка");
        typeComboBox.addItem("возврат");
        typeComboBox.addItem("поступление");
        typeComboBox.addItem("восстановление");
        typeComboBox.addItem("брак");
        typeComboBox.addItem("утилизация");
        typeComboBox.addActionListener(e -> {
            if (typeComboBox.getSelectedItem().toString().equals("восстановление")) {
                countLabel.setVisible(true);
                stairsFrameCountTextField.setVisible(true);
                passFrameCountTextField.setVisible(true);
                diagonalConnectionCountTextField.setVisible(true);
                horizontalConnectionCountTextField.setVisible(true);
                crossbarCountTextField.setVisible(true);
                deckCountTextField.setVisible(true);
                supportCountTextField.setVisible(true);

                defectiveCountLabel.setVisible(false);
                stairsFrameDefectiveCountTextField.setVisible(false);
                passFrameDefectiveCountTextField.setVisible(false);
                diagonalConnectionDefectiveCountTextField.setVisible(false);
                horizontalConnectionDefectiveCountTextField.setVisible(false);
                crossbarDefectiveCountTextField.setVisible(false);
                deckDefectiveCountTextField.setVisible(false);
                supportDefectiveCountTextField.setVisible(false);
            } else if (typeComboBox.getSelectedItem().toString().equals("брак") || typeComboBox.getSelectedItem().toString().equals("утилизация")) {
                countLabel.setVisible(false);
                stairsFrameCountTextField.setVisible(false);
                passFrameCountTextField.setVisible(false);
                diagonalConnectionCountTextField.setVisible(false);
                horizontalConnectionCountTextField.setVisible(false);
                crossbarCountTextField.setVisible(false);
                deckCountTextField.setVisible(false);
                supportCountTextField.setVisible(false);

                defectiveCountLabel.setVisible(true);
                stairsFrameDefectiveCountTextField.setVisible(true);
                passFrameDefectiveCountTextField.setVisible(true);
                diagonalConnectionDefectiveCountTextField.setVisible(true);
                horizontalConnectionDefectiveCountTextField.setVisible(true);
                crossbarDefectiveCountTextField.setVisible(true);
                deckDefectiveCountTextField.setVisible(true);
                supportDefectiveCountTextField.setVisible(true);
            } else {
                countLabel.setVisible(true);
                stairsFrameCountTextField.setVisible(true);
                passFrameCountTextField.setVisible(true);
                diagonalConnectionCountTextField.setVisible(true);
                horizontalConnectionCountTextField.setVisible(true);
                crossbarCountTextField.setVisible(true);
                deckCountTextField.setVisible(true);
                supportCountTextField.setVisible(true);

                defectiveCountLabel.setVisible(true);
                stairsFrameDefectiveCountTextField.setVisible(true);
                passFrameDefectiveCountTextField.setVisible(true);
                diagonalConnectionDefectiveCountTextField.setVisible(true);
                horizontalConnectionDefectiveCountTextField.setVisible(true);
                crossbarDefectiveCountTextField.setVisible(true);
                deckDefectiveCountTextField.setVisible(true);
                supportDefectiveCountTextField.setVisible(true);
            }
            this.validate();
        });

    }

    private void createOperation() {
        try {
            String day = dayComboBox.getSelectedItem().toString();
            String month = monthComboBox.getSelectedItem().toString();
            String year = yearComboBox.getSelectedItem().toString();
            String customer = customersComboBox.getSelectedItem().toString();
            String type = typeComboBox.getSelectedItem().toString();
            if (type.equals("поступление")) {
                customer = "Ринстрой";
            }
            boolean isEditDefectiveBalance = type.equals("восстановление") || type.equals("брак") || type.equals("утилизация");
            if (isEditDefectiveBalance) {
                customer = "Склад";
            }
            if (day.isEmpty() || month.isEmpty() || year.isEmpty() || customer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Укажите дату и контрагента", "Предупреждение", JOptionPane.ERROR_MESSAGE);
            } else {
                int stairsFrameCount = Integer.parseInt(stairsFrameCountTextField.getText());
                int passFrameCount = Integer.parseInt(passFrameCountTextField.getText());
                int diagonalConnectionCount = Integer.parseInt(diagonalConnectionCountTextField.getText());
                int horizontalConnectionCount = Integer.parseInt(horizontalConnectionCountTextField.getText());
                int crossbarCount = Integer.parseInt(crossbarCountTextField.getText());
                int deckCount = Integer.parseInt(deckCountTextField.getText());
                int supportCount = Integer.parseInt(supportCountTextField.getText());
                int stairsFrameBadCount = Integer.parseInt(stairsFrameDefectiveCountTextField.getText());
                int passFrameBadCount = Integer.parseInt(passFrameDefectiveCountTextField.getText());
                int diagonalConnectionBadCount = Integer.parseInt(diagonalConnectionDefectiveCountTextField.getText());
                int horizontalConnectionBadCount = Integer.parseInt(horizontalConnectionDefectiveCountTextField.getText());
                int crossbarBadCount = Integer.parseInt(crossbarDefectiveCountTextField.getText());
                int deckBadCount = Integer.parseInt(deckDefectiveCountTextField.getText());
                int supportBadCount = Integer.parseInt(supportDefectiveCountTextField.getText());
                boolean performed = true;
                String date = year + "-" + month + "-" + day;
                StorageOperation operation = new StorageOperation(date, customer, type,
                        stairsFrameCount,
                        passFrameCount,
                        diagonalConnectionCount,
                        horizontalConnectionCount,
                        crossbarCount,
                        deckCount,
                        supportCount,
                        stairsFrameBadCount,
                        passFrameBadCount,
                        diagonalConnectionBadCount,
                        horizontalConnectionBadCount,
                        crossbarBadCount,
                        deckBadCount,
                        supportBadCount,
                        performed);
                if (isEditDefectiveBalance) {
                    DataBaseController.editDefectiveBalance(operation);
                } else {
                    DataBaseController.createOperation(operation);
                }

                JOptionPane.showMessageDialog(this, "Операция создана!", "Сообщение", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Количетво элементов должно быть указанно цифрами", "Предупреждение", JOptionPane.ERROR_MESSAGE);
        }

    }
}
