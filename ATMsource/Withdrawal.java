// Withdrawal.java
// Represents a withdrawal ATM transaction
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

public class Withdrawal extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private Validation validation;
   private CashDispenser cashDispenser; // reference to cash dispenser
   private JButton wButtons[];
   private WithdrawalMenu withdrawalmenu;
   private Screen screen;
   private InsertPagePanel customAmountPanel;
   private WithdrawedCash withdrawedCash;
   private TakeCard takeCard;
   private CancelTransaction cancelTransaction;
   private ATM atm;
   private WithdrawalMenuHandler withdrawalHandler;
   private double availableBalance;
   private BankDatabase bankDatabase;
   private WithdrawalConfirm withdrawalConfirm;

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, Screen atmScreen,
         BankDatabase atmBankDatabase, Keypad atmKeypad,
         CashDispenser atmCashDispenser, Validation atmValidation,
         ATM theATM, WithdrawalMenu atmWithdrawalMenu, InsertPagePanel atmCustomAmountPanel,
         WithdrawedCash atmWithdrawedCash, TakeCard atmTakeCard, CancelTransaction atmCancelTransaction,
         WithdrawalConfirm atmWithdrawalConfirm) {
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
      withdrawedCash = atmWithdrawedCash;
   } // end Withdrawal constructor

   // perform transaction
   public void execute() {
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
      //add withdrawal menu Handler
      for (var temp : wButtons) {
         temp.addActionListener(withdrawalHandler);
      }
   }

   private void checkAmount() {
      // get available balance of account involved
      availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

      // check whether the user has enough money in the account
      if (amount <= availableBalance) {
         // check whether the cash dispenser has enough money
         switch (cashDispenser.isSufficientCashAvailable(amount)) {
            case 1:
               // display invaild message
               withdrawalmenu.setInvalidMessage(
                     "<html>Wrong cash type input in the ATM. <br/>Please input desired amount which is multiple of 100</html>");
               customAmountPanel.setInvalidMessage(
                     "<html>Wrong cash type input in the ATM. <br/>Please input desired amount which is multiple of 100</html>");
               break;
            case 2:
               // display invaild message
               withdrawalmenu.setInvalidMessage(
                     "<html>Insufficient cash available in the ATM. <br/>Please choose a smaller amount.</html>");
               customAmountPanel.setInvalidMessage(
                     "<html>Insufficient cash available in the ATM. <br/>Please choose a smaller amount.</html>");
               break;
            case 3:
               // display invaild message
               withdrawalmenu.setInvalidMessage( 
                     "<html>Insufficient cash available in the ATM. The ATM do not have enough HK$100 and HK$500 dollar notes. <br/>Please choose another amount which is smaller or larger</html>");
               customAmountPanel.setInvalidMessage(
                     "<html>Insufficient cash available in the ATM. The ATM do not have enough HK$100 and HK$500 dollar notes. <br/>Please choose another amount which is smaller or larger</html>");
               break;
            case 4:
               // display invaild message
               withdrawalmenu.setInvalidMessage( 
                     "<html>Insufficient cash available in the ATM. The ATM do not have enough HK$100 dollar notes. <br/>Please choose another amount which is smaller or larger</html>");
               customAmountPanel.setInvalidMessage(
                     "<html>Insufficient cash available in the ATM. The ATM do not have enough HK$100 dollar notes. <br/>Please choose another amount which is smaller or larger</html>");
               break;
            case 5:
               transferConfirmGUI();
               break;
            default:
               break;
         }
      } else {
         // display invaild message
         withdrawalmenu.setInvalidMessage( 
               "<html>Insufficient balance in your bank account. <br/>Please choose a smaller amount.<html/>");
         customAmountPanel.setInvalidMessage(
               "<html>Insufficient balance in your bank account. <br/>Please choose a smaller amount.<html/>");
      }
   }

   //ActionListener for WithdrawalConfirmGUI
   private class WithdrawalConfirmHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case "Confirm":
               // update the account involved to reflect withdrawal
               bankDatabase.debit(getAccountNumber(), amount);
               cashDispenser.takeCash();
               takeCashGUI();
               break;
            case "Re-enter":
               withdrawalmainmenuGUI();
               break;
            case "Cancel":
               atm.mainmenuGUI();
               break;
         }
      }
   }

   //ActionListener for WithdrawalMenuGUI
   private class WithdrawalMenuHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         int userChoice[] = { 100, 200, 500, 1000 };
         switch (e.getActionCommand()) {
            case "1. $100":
            case "2. $200":
            case "3. $500":
            case "4. $1000":
               amount = userChoice[Character.getNumericValue(e.getActionCommand().charAt(0)) - 1];
               checkAmount();
               break;
            case "5. Custom Amount":
               withdrawalmenu.setInvalidMessage("");
               customAmountPanel.setInvalidMessage("");
               insertAmountGUI();
               break;
            case "6.Cancel transaction":
               // display cancel GUI page and go to main menu
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
            default:
               break;
         }
      }
   }

   //take Card and take Cash GUI
   private void takeCashGUI() {
      Timer timer = new Timer("Timer"); // timer for counting

      screen.getMainframe().getContentPane().removeAll();
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      takeCard.buildGUI();

      TimerTask openTakeCardGUI = new TimerTask() {
         public void run() {
            screen.getMainframe().getContentPane().removeAll();
            screen.getMainframe().revalidate();
            screen.getMainframe().repaint();
            withdrawedCash.buildGUI();
         }
      };

      //open take card GUI after 2 second
      timer.schedule(openTakeCardGUI, 2000L);

      TimerTask openTakeCashTask = new TimerTask() {
         public void run() {
            screen.getMainframe().getContentPane().removeAll();
            screen.getMainframe().revalidate();
            screen.getMainframe().repaint();

            atm.welcomeGUI();
         }
      };
      //return welcomeGUI after 4 second
      timer.schedule(openTakeCashTask, 4000L);
   }

   //transfer Confirm GUI
   private void transferConfirmGUI() {
      JButton[] Buttons = withdrawalConfirm.getConfirmGUIButtons();
      screen.getMainframe().getContentPane().removeAll();
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      withdrawalConfirm.buildGUI();
      withdrawalConfirm.setDisplayWithdrawalAmount(amount);

      WithdrawalConfirmHandler withdrawalHandler = new WithdrawalConfirmHandler();
      for (var temp : Buttons) {
         temp.addActionListener(withdrawalHandler);
      }

   }

   //insert custiom amount GUI
   private void insertAmountGUI() {
      JButton[] keys = keypad.getKeys();
      screen.getMainframe().getContentPane().removeAll();
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      screen.getScreenContentPane().add(customAmountPanel, BorderLayout.CENTER);
      screen.getScreenContentPane().add(keypad.getKeypadJPanel(), BorderLayout.EAST);

      keypad.setKeypadColor(true);
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();

      AmountListener amountListener = new AmountListener();
      // delete ".", "cancel", "enter", "clear" actionlistener, and add new actionlistener
      for (int i = 10; i <= 13; i ++) {
         for (var temp : keys[i].getActionListeners()) {
            keys[i].removeActionListener(temp);
         }
         keys[i].addActionListener(amountListener);
      }
   }

   //ActionListener for insert custiom amount
   private class AmountListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case ".":
               keypad.warning(true);
               break;
            case "Cancel":
               keypad.getKeypadDisplayTextField().setText(null);
               keypad.warning(false);
               withdrawalmainmenuGUI();
               break;
            case "Clear":
               keypad.getKeypadDisplayTextField().setText("");
               keypad.getKeypadPasswordField().setText("");
               break;
            case "Enter":
               amount = validation.checkInt(keypad.getKeypadDisplayTextField().getText());
               if (amount != -1){
                  checkAmount();
                  keypad.getKeypadDisplayTextField().setText(null);
               }
               break;
         }
      }
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