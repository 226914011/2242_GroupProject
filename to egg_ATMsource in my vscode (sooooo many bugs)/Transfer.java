//  Transfer.java
//  This class represents the transfer function of an ATM
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Transfer extends Transaction{
    //declare instance variable for transfer class
    private Keypad keypad;
    private Screen screen;
    private BankDatabase bankDatabase;
    private int tarAccNum;
    private double amount;
    private boolean CANCELED,accValidate;
    private Validation validation;
    private TransferAccount transferAccount;
    private TransferAmount transferAmount;
    private TransferAmountListener transferamountlistener;
    private ATM atm;
    private InsertPagePanel insertPagePanel;

    //declare a int value for invalid input
    private static final int INVALID = -1;


    //Transfer constructor
    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, Validation atmValidation,ATM theATM, TransferAccount atmTransferAccount, TransferAmount atmTransferAmount) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        
        keypad = atmKeypad; // get reference
        validation = atmValidation; // get reference
        bankDatabase = getBankDatabase();   // get reference
        screen = super.getScreen();   // get reference
        atm = theATM;
        transferAccount = atmTransferAccount;
        transferAmount = atmTransferAmount;
        transferamountlistener = new TransferAmountListener();

    }

    
    

    public void execute() {
        System.out.println("execute");
        BankDatabase bankDatabase = getBankDatabase();
        screen.getMainframe().getContentPane().removeAll();
        transferGUI("Please enter the account number for transfer:");
        System.out.println("transferAccountGUI");
        screen.getMainframe().repaint();
        screen.getMainframe().revalidate();
        
        /**
        //ask user input the transfer information
        do
        {
            //ask user input account number for transfer
            screen.displayMessage("\nPlease enter the account number for transfer: ");
            tarAccNum = validation.checkInt(keypad.getInput());

            //check input is a valid integer
            if(tarAccNum == INVALID)    continue;

            //check input is a valid account number
            accValidate = !accNumValidity();
            if (accValidate)    continue;

            //ask user input amount
            screen.displayMessage("\nPlease enter the amount to transfer (it will ignore digits after two decimal places): ");
            amount = Math.floor(keypad.getDoubleInput()*100)/100.0;
            //clear input buffer
            keypad.getInput();
        } while(tarAccNum == INVALID || accValidate || !amountValidity() ||!confirmUserInput()); //if user inter a invalid information, re-enter the imformation

        //do transfer
        if (!CANCELED){
            //debit the money from owner account number
            bankDatabase.debit(getAccountNumber(), amount);
            //credit the money from transfer target account number
            bankDatabase.credit(tarAccNum, amount);

            //display transfer success message
            screen.displayMessageLine("\nThe transfer is successful. ");

            //Show account updated available balance and total balance
            screen.displayMessageLine( "\nUpdated balance Information:" );
            screen.displayMessage( " - Available balance: " ); 
            screen.displayDollarAmount( bankDatabase.getAvailableBalance( getAccountNumber() ) );
            screen.displayMessage( "\n - Total balance:     " );
            screen.displayDollarAmount( bankDatabase.getTotalBalance( getAccountNumber() ) );
            screen.displayMessageLine( "" );
        }
        else{
            screen.displayMessageLine( "\nCanceling transaction..." );
            return; // return to main menu because user canceled
        }
        **/
    }

    private void transferGUI(String Display){
        insertPagePanel = new InsertPagePanel(Display);
        JButton[] keys = keypad.getKeys();
        screen.getMainframe().getContentPane().removeAll();
        screen.getScreenContentPane().add(insertPagePanel, BorderLayout.CENTER);
        screen.getScreenContentPane().add(keypad.getKeypadJPanel(), BorderLayout.EAST);
        
        keypad.setKeypadColor(true);
        screen.getMainframe().revalidate();
        screen.getMainframe().repaint();
  
        TransferAmountListener  transferamountlistener = new TransferAmountListener();
        //delete ".", "cancel", "enter" actionlistener, and add new actionlistener for withdrawal class
        for (int i = 0; i <= 13 ; i++){
            for (var temp: keys[i].getActionListeners()){
                keys[i].removeActionListener(temp);
            }
        keys[i].addActionListener(transferamountlistener);
        System.out.println("transferamountlistener");
        }
     }

    //boolean method - checkUserAccExistAndNotUserOwnAcc
    private boolean accNumValidity(){
        //return false when account number does not exist
        if(!bankDatabase.checkAccountExist(tarAccNum)){
            screen.displayMessageLine("\tThe account " + tarAccNum + " is an invalid user account.\n\tPlease re-enter the user account.\n");
            return false;
        }
        //return false when transfer account number equal to own account
        if(getAccountNumber() == tarAccNum){
            screen.displayMessageLine("\tThe account " + tarAccNum + " is your own account.\n\tPlease input an valid account number.\n");
            return false;
        }
        return true;
    }

    //boolean method - check the account have enough money to transfer and amount is positive double number
    private boolean amountValidity(){
        double availablebalance = bankDatabase.getAvailableBalance(getAccountNumber());
        //return false when input amount equal to 0
        if (amount == 0){
            screen.displayMessageLine("\tYou have inputted an invalid amount.\n\tPlease re-enter the amount.");
            screen.displayMessageLine("\tAmount should larger than $0.\n");
            return false;
        }
        //return false when input amount larger than Available Balance
        if (amount > availablebalance){
            screen.displayMessageLine("\tYou have inputted an invalid amount.\n\tPlease re-enter the amount.");
            screen.displayMessageLine("\tAmount should smaller or equal to $" + availablebalance + ".\n");
            return false;
        }
        
        return true;
    }


    //boolean method - confirm the information
    private boolean confirmUserInput(){
        /** 
        do{
            //display confrim message
            screen.displayMessageLine("\nThe account number for transfer: " + tarAccNum);
            screen.displayMessage("Your transfer amount: ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine("\n");
            screen.displayMessageLine("Confirm your input?");
            screen.displayMessageLine( "1 - Confirm" );
            screen.displayMessageLine( "2 - re-enter the information" );
            screen.displayMessageLine( "3 - cancel transfer" );

            int input = validation.checkInt(keypad.getInput()); // get user input through keypad
            if (input == INVALID)  continue;    //check is this a valid integer
            
            //determine the next action
            switch(input){
                //confirm input
                case 1: 
                    return true;
                //re-enter the transfer information
                case 2: 
                    return false;
                //cancel transfer
                case 3:
                    CANCELED = true;
                    return true;
                //re-enter the user choice for next action
                default:
                    screen.displayMessageLine( 
                    "\nInvalid selection. Try again." );
                    break;
            } 
        } while(true);
                    **/
                    return true;
    }
    // private inner class for keypad event handling
    private class TransferAmountListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("actionPerformed");
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
                case ".":
                    System.out.println("switch");
                    keypad.getKeypadDisplayTextField().setText(keypad.getKeypadDisplayTextField().getText() +e.getActionCommand());
                    break;
                case "Cancel":
                    screen.getMainframe().getContentPane().removeAll();
                    screen.getMainframe().revalidate();
                    screen.getMainframe().repaint();
                    keypad.getKeypadDisplayTextField().setText("");
                    keypad.closeWarning();
                    atm.mainmenuGUI();
                    break;
                case "Clear":
                    keypad.getKeypadDisplayTextField().setText("");
                    break;
                case "Enter":
                    amount = Double.valueOf(keypad.getKeypadDisplayTextField().getText());
                    keypad.getKeypadDisplayTextField().setText("");
                    keypad.closeWarning();
                    amountValidity();
                    break;
                default:
                    break;
            }
        }
    }
}
