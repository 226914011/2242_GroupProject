
// Withdrawal.java
// Represents a withdrawal ATM transaction
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Withdrawal extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private Validation validation;
   private CashDispenser cashDispenser; // reference to cash dispenser
   private WithdrawalMenuHandler withdrawalMenuHandler;
   private static int withdrawalmenuChioce;
   private JButton wButtons[];
   private WithdrawalMenu withdrawalmenu;
   private Screen screen;
   private DisplayMessageJPanel withdrawalPanel;
   private InsertPagePanel customAmountPanel;
   private WithdrawedCash withdrawedCash;
   private TakeCard takeCard;
   private CancelTransaction cancelTransaction;
   private ATM atm;
   private WithdrawalMenuHandler withdrawalHandler;
   private double availableBalance;
   private BankDatabase bankDatabase;
   private WithdrawalConfirm withdrawalConfirm;

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 6;
   private final static int INVAILD = -1;

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, Screen atmScreen,
         BankDatabase atmBankDatabase, Keypad atmKeypad,
         CashDispenser atmCashDispenser, Validation atmValidation, 
         ATM theATM, WithdrawalMenu atmWithdrawalMenu, InsertPagePanel atmCustomAmountPanel, 
         WithdrawedCash atmWithdrawedCash, TakeCard atmTakeCard, CancelTransaction atmCancelTransaction, WithdrawalConfirm atmWithdrawalConfirm) {
      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      // initialize references to keypad and cash dispenser
      keypad = atmKeypad;
      screen = super.getScreen();
      validation = atmValidation;
      cashDispenser = atmCashDispenser;
      withdrawalmenu = atmWithdrawalMenu;
      customAmountPanel = atmCustomAmountPanel;
      takeCard = atmTakeCard;
      cancelTransaction = atmCancelTransaction;
      atm = theATM;
      withdrawalConfirm = atmWithdrawalConfirm;
   } // end Withdrawal constructor

   // perform transaction
   public void execute() {

      boolean cashDispensed = false; // cash was not dispensed yet
      double availableBalance; // amount available for withdrawal

      // get references to bank database and screen
      bankDatabase = getBankDatabase();
      withdrawalmainmenuGUI();
   } // end method execute

   private void withdrawalmainmenuGUI() {
      screen.getMainframe().getContentPane().removeAll();
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      withdrawalmenu.buildGUI();

      wButtons = withdrawalmenu.getwButtons();
      withdrawalHandler = new WithdrawalMenuHandler();
      for (var temp : wButtons) {
         temp.addActionListener(withdrawalHandler);
      }
   }

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference

      // array of amounts to correspond to menu numbers
      int amounts[] = { 0, 100, 200, 500, 1000 };

      // loop while no valid choice has been made
      while (userChoice == 0) {
         // display the menu
         screen.displayMessageLine("\nWithdrawal Menu:");
         screen.displayMessageLine("1 - $100");
         screen.displayMessageLine("2 - $200");
         screen.displayMessageLine("3 - $500");
         screen.displayMessageLine("4 - $1000");
         screen.displayMessageLine("5 - Custom Amount");
         screen.displayMessageLine("6 - Cancel transaction");
         screen.displayMessage("\nChoose a withdrawal option: ");

         int input = validation.checkInt(keypad.getInput()); // get user input through keypad and do validation check
         if (input == INVAILD)
            continue; // continue when user not enter a valid integer input

         // determine how to proceed based on the input value
         switch (input) {
            case 1: // if the user chose a withdrawal amount
            case 2: // (i.e., chose option 1, 2, 3, 4 or 5), return the
            case 3: // corresponding amount from amounts array
            case 4:
               userChoice = amounts[input]; // save user's choice
               break;
            case 5:
               screen.displayMessage("\nPlease input your custom amount: ");
               int userinput = validation.checkInt(keypad.getInput()); // get user input through keypad and do
                                                                       // validation check
               if (userinput == INVAILD)
                  continue; // continue when user not enter a valid integer input
               userChoice = userinput; // save user's choice
               break;
            case CANCELED: // the user chose to cancel
               userChoice = CANCELED; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               screen.displayMessageLine("\nInvalid selection. Try again.");
         } // end switch
      } // end while

      return userChoice; // return withdrawal amount or CANCELED
   } // end method displayMenuOfAmounts

   private void checkAmount(){
      // get available balance of account involved
      availableBalance = 
         bankDatabase.getAvailableBalance( getAccountNumber() );

      // check whether the user has enough money in the account 
      if ( amount <= availableBalance )
      {   
         // check whether the cash dispenser has enough money
         switch (cashDispenser.isSufficientCashAvailable( amount )) {
            case 1:
               withdrawalmenu.setInvalidMessage( 
               "<html>Wrong cash type input in the ATM. <br/>Please input desired amount which is multiple of 100</html>" );
               break;
            case 2:
               withdrawalmenu.setInvalidMessage( 
               "<html>Insufficient cash available in the ATM. <br/>Please choose a smaller amount.</html>" );
               break;
            case 3:
               withdrawalmenu.setInvalidMessage( 
               "<html>Insufficient cash available in the ATM. The ATM do not have enough HK$100 and HK$500 dollar notes. <br/>Please choose another amount which is smaller or larger</html>" );
               break;
            case 4:
               withdrawalmenu.setInvalidMessage( 
               "<html>Insufficient cash available in the ATM. The ATM do not have enough HK$100 dollar notes. <br/>Please choose another amount which is smaller or larger</html>" );
               break;
            case 5:
               transferConfirmGUI();
               break;
            default:
            break;
         }
      } else{
         withdrawalmenu.setInvalidMessage( 
               "<html>Insufficient balance in your bank account. <br/>Please choose a smaller amount.<html/>" );
      }
   }

   private class WithdrawalMenuHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         int userChoice[] = { 0, 100, 200, 500, 1000 };
         switch (e.getActionCommand()) {
            case "1. $100":
            case "2. $200":
            case "3. $500":
            case "4. $1000":
               amount = userChoice[Character.getNumericValue(e.getActionCommand().charAt(0))];
               checkAmount();
               break;
            case "5. Custom Amount":
               insertAmountGUI();
               break;
            case "6.Cancel transaction":
               //display cancel GUI page and go to main menu
               screen.getMainframe().getContentPane().removeAll();
               screen.getMainframe().revalidate();
               screen.getMainframe().repaint();
               cancelTransaction.buildGUI();
               screen.getMainframe().revalidate();
               screen.getMainframe().repaint();
               TimerTask returnToMainMenuTask = new TimerTask() {
                  public void run() {
                     screen.getMainframe().getContentPane().removeAll();
                     screen.getMainframe().revalidate();
                     screen.getMainframe().repaint();
                     atm.mainmenuGUI();
                  }
               };
               Timer timer = new Timer("Timer");
               
               long delay = 3000L;
               timer.schedule(returnToMainMenuTask, delay);
               break;
            default: break;
         }
      }
   }


   public void transferConfirmGUI(){
      screen.getMainframe().getContentPane().removeAll();
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      withdrawalConfirm.buildGUI();
      /** 
      // update the account involved to reflect withdrawal
      bankDatabase.debit( getAccountNumber(), amount );
      //cashDispensed = true; // cash was dispensed
      // instruct user to take cash
      screen.displayMessageLine( 
      "\nPlease take your cash now." );
      **/
   }

   public void insertAmountGUI(){
      screen.getMainframe().getContentPane().removeAll();
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      screen.getScreenContentPane().add(customAmountPanel, BorderLayout.CENTER);
      screen.getScreenContentPane().add(keypad.getKeypadJPanel(), BorderLayout.EAST);

      keypad.setKeypadColor(true);
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();

      //delete ".", "cancel", "enter" actionlistener, and add new actionlistener for withdrawal class
   }

} // end class Withdrawal

/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/