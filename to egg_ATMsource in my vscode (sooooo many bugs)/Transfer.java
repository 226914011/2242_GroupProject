
//  Transfer.java
//  This class represents the transfer function of an ATM
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Transfer extends Transaction {
    // declare instance variable for transfer class
    private Keypad keypad;
    private Screen screen;
    private BankDatabase bankDatabase;
    private int tarAccNum;
    private double amount;
    private boolean accValidate;
    private Validation validation;
    private TransferListener transferlistener;
    private ATM atm;
    private InsertPagePanel insertPagePanel;
    private TransferConfirm transferconfirm;
    private JButton[] tCButton;
    private JTextField[] tCTextField;
    private TransferConfirmListener tconfirmlistener;
    private TransferUpdate transferupdate;

    // declare a int value for invalid input
    private static final int INVALID = -1;

    // Transfer constructor
    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad,
            Validation atmValidation, ATM theATM, TransferConfirm atmtransferConfirm,
            TransferUpdate atmtransferupdate) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = atmKeypad; // get reference
        validation = atmValidation; // get reference
        bankDatabase = getBankDatabase(); // get reference
        screen = super.getScreen(); // get reference
        atm = theATM;
        transferconfirm = atmtransferConfirm;
        transferupdate = atmtransferupdate;
        transferlistener = new TransferListener();
        tconfirmlistener = new TransferConfirmListener();
    }

    public void execute() {
        screen.getMainframe().getContentPane().removeAll();
        accValidate = false;
        transferGUI("Please enter the account number for transfer:");
        screen.getMainframe().repaint();
        screen.getMainframe().revalidate();
    }

    private void transferGUI(String Display) {
        insertPagePanel = new InsertPagePanel(Display);
        JButton[] keys = keypad.getKeys();
        screen.getMainframe().getContentPane().removeAll();
        screen.getScreenContentPane().add(insertPagePanel, BorderLayout.CENTER);
        screen.getScreenContentPane().add(keypad.getKeypadJPanel(), BorderLayout.EAST);

        keypad.setKeypadColor(true);
        screen.getMainframe().revalidate();
        screen.getMainframe().repaint();

        // delete ".", "cancel", "enter" actionlistener, and add new actionlistener
        for (int i = 0; i <= 13; i++) {
            for (var temp : keys[i].getActionListeners()) {
                keys[i].removeActionListener(temp);
            }
            keys[i].addActionListener(transferlistener);
        }
    }

    private void confirmGUI() {
        screen.getMainframe().getContentPane().removeAll();
        transferconfirm.buildGUI();
        tCButton = transferconfirm.getTransferConfirmButton();
        tCTextField = transferconfirm.getTransferConfirmJTextField();
        tCTextField[0].setText(String.valueOf(tarAccNum));
        tCTextField[1].setText(String.format("$%,.2f", Double.valueOf(amount)));
        screen.getMainframe().repaint();
        screen.getMainframe().revalidate();

        // delete ".", "cancel", "enter" actionlistener, and add new actionlistener
        for (int i = 0; i < 3; i++) {
            for (var temp : tCButton[i].getActionListeners()) {
                tCButton[i].removeActionListener(temp);
            }
            tCButton[i].addActionListener(tconfirmlistener);
        }
    }

    private void transfer() {
        // debit the money from owner account number
        bankDatabase.debit(getAccountNumber(), amount);
        // credit the money from transfer target account number
        bankDatabase.credit(tarAccNum, amount);

    }

    private void transferupdateGUI() {
        screen.getMainframe().getContentPane().removeAll();
        transferupdate.buildGUI();
        transferupdate.getAvailableTextField()
                .setText(String.format("$%,.2f", Double.valueOf(bankDatabase.getAvailableBalance(getAccountNumber()))));
        transferupdate.getTotalBalanceTextField()
                .setText(String.format("$%,.2f", Double.valueOf(bankDatabase.getTotalBalance(getAccountNumber()))));
        screen.getMainframe().repaint();
        screen.getMainframe().revalidate();
        JButton backButton = transferupdate.getBackButton();
        for (var temp : backButton.getActionListeners()) {
            backButton.removeActionListener(temp);
        }
        backButton.addActionListener(tconfirmlistener);
    }

    // boolean method - checkUserAccExistAndNotUserOwnAcc
    private boolean accNumValidity() {
        // return false when account number does not exist
        if (!bankDatabase.checkAccountExist(tarAccNum)) {
            insertPagePanel.setInvalidMessage("<html>The account " + tarAccNum
                    + " is an invalid user account.<br>Please re-enter the user account.</html>");
            return false;
        }
        // return false when transfer account number equal to own account
        if (getAccountNumber() == tarAccNum) {
            insertPagePanel.setInvalidMessage("<html>The account " + tarAccNum
                    + " is your own account.<br>Please input an valid account number.</html>");
            return false;
        }
        return true;
    }

    // boolean method - check the account have enough money to transfer and amount
    // is positive double number
    private boolean amountValidity() {
        double availablebalance = bankDatabase.getAvailableBalance(getAccountNumber());
        // return false when input amount equal to 0
        if (amount == 0) {
            insertPagePanel.setInvalidMessage(
                    "<html>You have inputted an invalid amount.<br>Please re-enter the amount.<br>Amount should larger than $0.</hmtl>");
            return false;
        }
        // return false when input amount larger than Available Balance
        if (amount > availablebalance) {
            insertPagePanel.setInvalidMessage(
                    "<html>You have inputted an invalid amount.<br>Please re-enter the amount.<br>Amount should smaller or equal to $"
                            + availablebalance + "</hmtl>");
            return false;
        }

        return true;
    }

    private void mainmenu() {
        screen.getMainframe().getContentPane().removeAll();
        screen.getMainframe().revalidate();
        screen.getMainframe().repaint();
        keypad.getKeypadDisplayTextField().setText("");
        keypad.warning(false);
        atm.mainmenuGUI();
    }

    // private inner class for keypad event handling
    private class TransferListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    if (keypad.getKeypadDisplayTextField().getText().length() < 9)
                        keypad.getKeypadDisplayTextField()
                                .setText(keypad.getKeypadDisplayTextField().getText() + e.getActionCommand());
                    break;
                case ".":
                    if(accValidate)
                        keypad.getKeypadDisplayTextField().setText(keypad.getKeypadDisplayTextField().getText() +e.getActionCommand()); 
                    else 
                        keypad.warning(true);
                    break;
                case "Cancel":
                    mainmenu();
                    break;
                case "Clear":
                    keypad.getKeypadDisplayTextField().setText("");
                    break;
                case "Enter":
                    String input = keypad.getKeypadDisplayTextField().getText();
                    keypad.getKeypadDisplayTextField().setText("");
                    keypad.warning(false);
                    System.out.println("Enter");
                    System.out.println(input);
                    if (accValidate) {
                        amount = Double.valueOf((int) (Double.valueOf(input) * 100)) / 100;
                        if (amountValidity()) {
                            confirmGUI();
                        }
                    } else {
                        tarAccNum = validation.checkInt(input);
                        if (accNumValidity()) {
                            accValidate = true;
                            transferGUI(
                                    "<html>Please enter the amount to transfer:<br/><br/>(It will ignore after two decimal point)</html>");
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    // private inner class for keypad event handling
    private class TransferConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("actionPerformed");
            switch (e.getActionCommand()) {
                case "Re-enter":
                    System.out.println("reenter");
                    execute();
                    break;
                case "Cancel":
                case "Back":
                    mainmenu();
                    break;
                case "Confirm":
                    System.out.println("Confirm");
                    transfer();
                    transferupdateGUI();
                    break;
                default:
                    break;
            }
        }
    }
}
