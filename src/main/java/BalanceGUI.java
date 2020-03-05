import javax.swing.*;
import java.awt.*;

public class BalanceGUI extends JFrame {
    private JButton backButton;
    private JPanel RootPanel;
    private JLabel stairsFrameLabel;
    private JLabel passFrameLabel;
    private JLabel diagonalConnectionLabel;
    private JLabel horizontalConnectionLabel;
    private JLabel crossbarLabel;
    private JLabel deckLabel;
    private JLabel supportLabel;
    private JTextField stairsFrameCountTextField;
    private JTextField passFrameCountTextField;
    private JTextField diagonalConnectionCountTextField;
    private JTextField horizontalConnectionCountTextField;
    private JTextField crossbarCountTextField;
    private JTextField deckCountTextField;
    private JTextField supportCountTextField;
    private JTextField stairsFrameBadCountTextField;
    private JTextField passFrameBadCountTextField;
    private JTextField diagonalConnectionBadCountTextField;
    private JTextField horizontalConnectionBadCountTextField;
    private JTextField crossbarBadCountTextField;
    private JTextField deckBadCountTextField;
    private JTextField supportBadCountTextField;
    private JButton inventoryButton;
    private JTextField stairsFrameBuyingPriceTextField;
    private JTextField passFrameBuyingPriceTextField;
    private JTextField diagonalConnectionBuyingPriceTextField;
    private JTextField horizontalConnectionBuyingPriceTextField;
    private JTextField crossbarBuyingPryceTextField;
    private JTextField deckBuyingPriceTextField;
    private JTextField supportBuyingPriceTextField;
    private JTextField stairsFrameWeightTextField;
    private JTextField passFrameWeightTextField;
    private JTextField diagonalConnectionWeightTextField;
    private JTextField horizontalConnectionWeightTextField;
    private JTextField crossbarWeightTextField;
    private JTextField deckWeightTextField;
    private JTextField supportWeightTextField;
    private JLabel countLabel;
    private JLabel defectiveCountLabel;
    private JLabel weightLabel;
    private JLabel buyingPriceLabel;
    private JButton updateButton;
    private MainWindow mainWindow;
    private JFrame fromWindow;

    public BalanceGUI(MainWindow mainWindow, JFrame fromWindow) throws HeadlessException {
        this.mainWindow = mainWindow;
        this.fromWindow = fromWindow;
        setContentPane(RootPanel);
        loadBalance();
        setBackButtonAction();
        setUpdateButtonAction();
        setInventoryButtonAction();
    }


    private void setBackButtonAction() {
        backButton.addActionListener(e -> {
            mainWindow.setContentPane(fromWindow.getContentPane());
            mainWindow.validate();
        });
    }

    private void setUpdateButtonAction () {
        updateButton.addActionListener(e -> {
            DataBaseController.updateBalance();
            loadBalance();
        });
    }

    private void setInventoryButtonAction () {
        inventoryButton.addActionListener(e -> inventory());
    }

    private void loadBalance () {
        ElementScaffold [] balance = DataBaseController.getBalance();

        stairsFrameLabel.setText(balance[0].getName());
        stairsFrameCountTextField.setText(balance[0].getCount() + "");
        stairsFrameBadCountTextField.setText(balance[0].getDefectiveCount() + "");
        stairsFrameWeightTextField.setText(balance[0].getWeight() + "");
        stairsFrameBuyingPriceTextField.setText(balance[0].getBuyingPrice() + "");

        passFrameLabel.setText(balance[1].getName());
        passFrameCountTextField.setText(balance[1].getCount() + "");
        passFrameBadCountTextField.setText(balance[1].getDefectiveCount() + "");
        passFrameWeightTextField.setText(balance[1].getWeight() + "");
        passFrameBuyingPriceTextField.setText(balance[1].getBuyingPrice() + "");

        diagonalConnectionLabel.setText(balance[2].getName());
        diagonalConnectionCountTextField.setText(balance[2].getCount() + "");
        diagonalConnectionBadCountTextField.setText(balance[2].getDefectiveCount() + "");
        diagonalConnectionWeightTextField.setText(balance[2].getWeight() + "");
        diagonalConnectionBuyingPriceTextField.setText(balance[2].getBuyingPrice() + "");

        horizontalConnectionLabel.setText(balance[3].getName());
        horizontalConnectionCountTextField.setText(balance[3].getCount() + "");
        horizontalConnectionBadCountTextField.setText(balance[3].getDefectiveCount() + "");
        horizontalConnectionWeightTextField.setText(balance[3].getWeight() + "");
        horizontalConnectionBuyingPriceTextField.setText(balance[3].getBuyingPrice() + "");

        crossbarLabel.setText(balance[4].getName());
        crossbarCountTextField.setText(balance[4].getCount() + "");
        crossbarBadCountTextField.setText(balance[4].getDefectiveCount() + "");
        crossbarWeightTextField.setText(balance[4].getWeight() + "");
        crossbarBuyingPryceTextField.setText(balance[4].getBuyingPrice() + "");

        deckLabel.setText(balance[5].getName());
        deckCountTextField.setText(balance[5].getCount() + "");
        deckBadCountTextField.setText(balance[5].getDefectiveCount() + "");
        deckWeightTextField.setText(balance[5].getWeight() + "");
        deckBuyingPriceTextField.setText(balance[5].getBuyingPrice() + "");

        supportLabel.setText(balance[6].getName());
        supportCountTextField.setText(balance[6].getCount() + "");
        supportBadCountTextField.setText(balance[6].getDefectiveCount() + "");
        supportWeightTextField.setText(balance[6].getWeight() + "");
        supportBuyingPriceTextField.setText(balance[6].getBuyingPrice() + "");
    }

    private void inventory () {
        int sure = JOptionPane.showConfirmDialog(this, "Вы уверенны, что хотите изменить остатки на складе? \n Изменения нельзя будет отменить!",
                "Предупреждение", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (sure == JOptionPane.YES_OPTION) {
            try {
                ElementScaffold [] balance = new ElementScaffold[7];
                for (int i = 0; i < balance.length; i++) {
                    balance[i] = new ElementScaffold();
                }

                balance[0].setName(stairsFrameLabel.getText());
                balance[0].setCount(Integer.parseInt(stairsFrameCountTextField.getText()));
                balance[0].setDefectiveCount(Integer.parseInt(stairsFrameBadCountTextField.getText()));
                balance[0].setWeight(Double.parseDouble(stairsFrameWeightTextField.getText()));
                balance[0].setBuyingPrice(Double.parseDouble(stairsFrameBuyingPriceTextField.getText()));

                balance[1].setName(passFrameLabel.getText());
                balance[1].setCount(Integer.parseInt(passFrameCountTextField.getText()));
                balance[1].setDefectiveCount(Integer.parseInt(passFrameBadCountTextField.getText()));
                balance[1].setWeight(Double.parseDouble(passFrameWeightTextField.getText()));
                balance[1].setBuyingPrice(Double.parseDouble(passFrameBuyingPriceTextField.getText()));

                balance[2].setName(diagonalConnectionLabel.getText());
                balance[2].setCount(Integer.parseInt(diagonalConnectionCountTextField.getText()));
                balance[2].setDefectiveCount(Integer.parseInt(diagonalConnectionBadCountTextField.getText()));
                balance[2].setWeight(Double.parseDouble(diagonalConnectionWeightTextField.getText()));
                balance[2].setBuyingPrice(Double.parseDouble(diagonalConnectionBuyingPriceTextField.getText()));

                balance[3].setName(horizontalConnectionLabel.getText());
                balance[3].setCount(Integer.parseInt(horizontalConnectionCountTextField.getText()));
                balance[3].setDefectiveCount(Integer.parseInt(horizontalConnectionBadCountTextField.getText()));
                balance[3].setWeight(Double.parseDouble(horizontalConnectionWeightTextField.getText()));
                balance[3].setBuyingPrice(Double.parseDouble(horizontalConnectionBuyingPriceTextField.getText()));

                balance[4].setName(crossbarLabel.getText());
                balance[4].setCount(Integer.parseInt(crossbarCountTextField.getText()));
                balance[4].setDefectiveCount(Integer.parseInt(crossbarBadCountTextField.getText()));
                balance[4].setWeight(Double.parseDouble(crossbarWeightTextField.getText()));
                balance[4].setBuyingPrice(Double.parseDouble(crossbarBuyingPryceTextField.getText()));

                balance[5].setName(deckLabel.getText());
                balance[5].setCount(Integer.parseInt(deckCountTextField.getText()));
                balance[5].setDefectiveCount(Integer.parseInt(deckBadCountTextField.getText()));
                balance[5].setWeight(Double.parseDouble(deckWeightTextField.getText()));
                balance[5].setBuyingPrice(Double.parseDouble(deckBuyingPriceTextField.getText()));

                balance[6].setName(supportLabel.getText());
                balance[6].setCount(Integer.parseInt(supportCountTextField.getText()));
                balance[6].setDefectiveCount(Integer.parseInt(supportBadCountTextField.getText()));
                balance[6].setWeight(Double.parseDouble(supportWeightTextField.getText()));
                balance[6].setBuyingPrice(Double.parseDouble(supportBuyingPriceTextField.getText()));

                ClientController.getInstance().editBalance(balance);
//                DataBaseController.updateBalance();
//                loadBalance();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "В поля могут быть введены только числа! \n Дробные значения пишите через точку!", "Предупреждение", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}
