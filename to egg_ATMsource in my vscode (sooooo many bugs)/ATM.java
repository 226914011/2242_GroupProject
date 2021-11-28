import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

// ATM.java
// Represents an automated teller machine

import javax.swing.*;

public class ATM
{
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private BankDatabase bankDatabase; // account information database
   private Validation validation;
   private ExitSystem exitSystem;
   private MainMenu mainmenu;
   private WithdrawalMenu withdrawalmenu;
   private Welcome welcome;
   private LoginDisplayPanel loginCardNumberPanel,loginPinPanel;
   private static int menuChioce,withdrawalmenuChioce;
   private boolean firstInitialize;
   private int accountNumber,pin,ScreenNum;
   private JButton keys [],Buttons [],wButtons [];
   private KeypadHandler keypadHandler;
   private WithdrawalMenuHandler withdrawalMenuHandler;
   private LoginHandler loginHandler;
   private ViewBalance viewbalance;

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int TRANSFER = 3;
   private static final int EXIT = 4;
   private static final int INVALID = -1;

   //
   private MouseListener ml = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
         loginGUI();
      }
   };

   // no-argument ATM constructor initializes instance variables
   public ATM()
   {
      userAuthenticated = false; // user is not authenticated to start
      firstInitialize = true;
      currentAccountNumber = 0; // no current account number to start
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad
      cashDispenser = new CashDispenser(); // create cash dispenser
      bankDatabase = new BankDatabase(); // create acct info database
      validation = new Validation(screen); // create validation
      exitSystem = new ExitSystem();
      mainmenu = new MainMenu();
      welcome = new Welcome();
      viewbalance = new ViewBalance();
      loginCardNumberPanel = new LoginDisplayPanel("Please Enter the Card Number:", "Group_7.png");
      loginPinPanel = new LoginDisplayPanel("Please Enter the password:", "Group_71.png");
      keypadHandler = new KeypadHandler();
      loginHandler= new LoginHandler();
   } // end no-argument ATM constructor

   // start ATM
   public void run()
   {  System.out.println("runed");
      keys = keypad.getKeys();
      screen.getMainframe().setVisible(true);
      screen.getMainframe().setResizable(false);
      welcomeGUI();
      /**
      // loop while user is not yet authenticated
      while ( !userAuthenticated )
      {
         screen.displayMessageLine( "\nWelcome!" );
         authenticateUser(); // authenticate user
      } // end while
      **/
      //displayMainMenu(); // user is now authenticated
   } // end method run

   private void welcomeGUI(){
      screen.getMainframe().getContentPane().removeAll();
      welcome.buildGUI();
      screen.getMainframe().repaint();
      screen.getMainframe().revalidate();
      welcome.getWelcomeLabel().addMouseListener(ml);
   }

   private void loginGUI(){
      welcome.getWelcomeLabel().removeMouseListener(ml);
      screen.getMainframe().getContentPane().removeAll();
      screen.getScreenContentPane().add(loginCardNumberPanel, BorderLayout.CENTER);
      screen.getScreenContentPane().add(keypad.getKeypadJPanel(), BorderLayout.EAST);

      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      for(ActionListener oldListener : keys[12].getActionListeners())
         keys[12].removeActionListener(oldListener);
      for (int i = 0; i <= 13; i++ ){
         if(keys[i].getActionListeners().length == 0){
            keys[i].addActionListener(keypadHandler);
         }
      }
   }

   //
   private void pinGUI(){
      screen.getMainframe().getContentPane().remove(loginCardNumberPanel);
      screen.getScreenContentPane().add(loginPinPanel, BorderLayout.CENTER);
      for(ActionListener oldListener : keys[12].getActionListeners())
         keys[12].removeActionListener(oldListener);
      keys[12].addActionListener(loginHandler);
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
   }

   // attempts to authenticate user against database
   private void authenticateUser(boolean Cancel)
   {
      userAuthenticated =
         bankDatabase.authenticateUser( accountNumber, pin );

      // check whether authentication succeeded
      if ( userAuthenticated )
      {
         currentAccountNumber = accountNumber; // save user's account #
         screen.getMainframe().getContentPane().removeAll();
         mainmenu.buildGUI();
         screen.getMainframe().revalidate();
         screen.getMainframe().repaint();
         mainmenuGUI();
      } // end if
      else{
         //need change
         keypad.getKeypadDisplayTextField().setText("");
         keys[12].removeActionListener(loginHandler);
         keys[12].addActionListener(keypadHandler);
         if(Cancel){
            run();
         }else{
            loginCardNumberPanel.invalidMessage(true);
            loginGUI();
         }
      }

   } // end method authenticateUser

   // display the main menu and perform transactions
   private void performTransactions()
   {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;

      //boolean userExited = false; // user has not chosen to exit

      // show main menu and get user selection
      int mainMenuSelection = menuChioce;

      // decide how to proceed based on user's menu selection
      switch ( mainMenuSelection )
      {
         // user chose to perform one of three transaction types
         case BALANCE_INQUIRY:
         case WITHDRAWAL:
         case TRANSFER:
            // initialize as new object of chosen type
            currentTransaction =
               createTransaction( mainMenuSelection );
            currentTransaction.execute(); // execute transaction
            break;
         case EXIT: // user chose to terminate session
            exitGUI();
            break;
         default: // user did not enter an integer from 1-4
            screen.displayMessageLine(
               "\nYou did not enter a valid selection. Try again." );
            break;
      } // end switch
   } // end method performTransactions

   // display the main menu and return an input selection
   private void mainmenuGUI()
   {
      Buttons = mainmenu.getButtons();
      MainmenuHandler mainmenuHandler = new MainmenuHandler();
      for (var temp : Buttons){
         temp.addActionListener(mainmenuHandler);
      }

      /*
      screen.balanceButton.addActionListener(mainmenuHandler);
      screen.withdrawButton.addActionListener(mainmenuHandler);
      screen.transferButton.addActionListener(mainmenuHandler);
      screen.exitButton.addActionListener(mainmenuHandler);*/

   } // end method displayMainMenu
   
   private void withdrawalmainmenuGUI()
   {
      wButtons = withdrawalmenu.getwButtons();
      WithdrawalMenuHandler withdrawalHandler = new WithdrawalMenuHandler();
      for (var temp : wButtons){
         temp.addActionListener(withdrawalHandler);
      }
   }

   private void exitGUI(){
      screen.getMainframe().getContentPane().removeAll();
      screen.getMainframe().revalidate();
      screen.getMainframe().repaint();
      exitSystem.buildGUI();
      //userExited = true; // this ATM session should end
      userAuthenticated = false; // reset before next ATM session
      currentAccountNumber = 0; // reset before next ATM session
      TimerTask openwelcomeTask = new TimerTask() {
         public void run() {
            accountNumber = 0;
            currentAccountNumber = 0;
            pin = 0;
            screen.getMainframe().getContentPane().removeAll();
            screen.getMainframe().revalidate();
            screen.getMainframe().repaint();

            welcomeGUI();
         }
      };
      Timer timer = new Timer("Timer");
      
      long delay = 2000L;
      timer.schedule(openwelcomeTask, delay);
   }

   // return object of specified Transaction subclass
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // temporary Transaction variable

      // determine which type of Transaction to create
      switch ( type )
      {
         case BALANCE_INQUIRY: // create new BalanceInquiry transaction
            temp = new BalanceInquiry(
               currentAccountNumber, screen, bankDatabase, viewbalance);
            break;
         case WITHDRAWAL: // create new Withdrawal transaction
            temp = new Withdrawal( currentAccountNumber, screen,
               bankDatabase, keypad, cashDispenser, validation, withdrawalmenu);
            break;
         case TRANSFER:
            temp = new Transfer(currentAccountNumber, screen,
               bankDatabase, keypad, validation);
            break;
      } // end switch

      return temp; // return the newly created object
   } // end method createTransaction



   private class KeypadHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
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
               keypad.getKeypadDisplayTextField().setText(keypad.getKeypadDisplayTextField().getText() +e.getActionCommand());
               break;
            case ".":
               //need popup some remind message
               keypad.warning();
               break;
            case "Cancel":
               screen.getMainframe().getContentPane().removeAll();
               screen.getMainframe().revalidate();
               screen.getMainframe().repaint();
               keypad.getKeypadDisplayTextField().setText("");
               loginCardNumberPanel.invalidMessage(false);
               keypad.closeWarning();
               authenticateUser(true);
               break;
            case "Clear":
               keypad.getKeypadDisplayTextField().setText("");
               break;
            case "Enter":
               accountNumber = validation.checkInt(keypad.getKeypadDisplayTextField().getText());            
               keypad.getKeypadDisplayTextField().setText("");
               keypad.closeWarning();
               pinGUI();
               break;
            default:
               break;
         }
      }
   }

   private class LoginHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e){
         pin = validation.checkInt(keypad.getKeypadDisplayTextField().getText());
         authenticateUser(false);
         keypad.getKeypadDisplayTextField().setText("");
         loginCardNumberPanel.invalidMessage(false);
      }
   }

   private class MainmenuHandler implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         switch(e.getActionCommand()){
            case "1. View my balance": menuChioce = 1; break;
            case "2. Withdraw": menuChioce = 2; break;
            case "3. Transfer": menuChioce = 3; break;
            case "4. Exit": menuChioce = 4; break;
         }
         performTransactions();

         /***
         if (e.getSource() == balanceButton){
            menuChioce = 1;
         }
         else if (e.getSource() == WithdrawButton){
            menuChioce = 2;
         }
         else if (e.getSource() == transferButton){
            menuChioce = 3;
         }
         else if (e.getSource() == exitButton){
            menuChioce = 4;
         }
         ***/
     }
   }
   private class WithdrawalMenuHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         switch (e.getActionCommand()) {
            case "1 - $100":withdrawalmenuChioce = 1;break;
            case "2 - $200":withdrawalmenuChioce =2;break;
            case "3 - $500":withdrawalmenuChioce =3;break;
            case "4 - $1000":withdrawalmenuChioce =4;break;
            case "5 - Custom Amount":withdrawalmenuChioce =5;break;
            case "6 - Cancel transaction":withdrawalmenuChioce =6;break;
         }
      }
   }
} // end class ATM



/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
