import java.awt.event.*;
import java.awt.*;

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
   private LoginSystem loginSystem;
   private MainMenu mainmenu;
   private Welcome welcome;
   private LoginDisplayPanel loginCardNumberPanel;
   private LoginDisplayPanel loginPinPanel;
   private static int menuChioce;

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int TRANSFER = 3;
   private static final int EXIT = 4;
   private static final int INVALID = -1;

   // no-argument ATM constructor initializes instance variables
   public ATM() 
   {
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad 
      cashDispenser = new CashDispenser(); // create cash dispenser
      bankDatabase = new BankDatabase(); // create acct info database
      validation = new Validation(screen); // create validation
      loginSystem = new LoginSystem();
      //exitSystem = new ExitSystem();
      //mainmenu = new MainMenu();
      //takeCard = new TakeCard();
      //transferComfirm = new TransferComfirm();
      //transferUpdate = new TransferUpdate();
      //viewBalance = new ViewBalance();
      welcome = new Welcome();
      loginCardNumberPanel = new LoginDisplayPanel("Please Enter the Card Number:", "Group_7.png");
      loginPinPanel = new LoginDisplayPanel("Please Enter the password:", "Group_71.png");
      //withdrawalMenu = new WithdrawalMenu();
      //withdrawedCash = new WithdrawedCash();
   } // end no-argument ATM constructor

   // start ATM 
   public void run()
   {
      JButton keys [] = keypad.getKeys();
      screen.getMainframe().setVisible(true);
      screen.getMainframe().setResizable(false);
      welcome.buildGUI();
      screen.getMainframe().repaint();
      
      welcome.getWelcomeLabel().addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            screen.getMainframe().getContentPane().removeAll();
            screen.getMainframe().revalidate();
            screen.getSrceenContentPane().add(loginCardNumberPanel, BorderLayout.CENTER);

            screen.getSrceenContentPane().add(keypad.getKeypadJPanel(), BorderLayout.EAST);
            screen.getMainframe().revalidate();

            KeypadHandler keypadHandler = new KeypadHandler();
            for (int i = 0; i <= 9; i++ ){
               keys[i].addActionListener(keypadHandler);
            }
         }
      });
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

   // attempts to authenticate user against database
   private void authenticateUser() 
   {
      //delare accountNumber and pin
      int accountNumber = 0;
      int pin = 0;

      // promt user for inputting account number and PIN
      do{
         screen.displayMessage( "\nPlease enter your account number: " );
         accountNumber = validation.checkInt(keypad.getInput()); // input account number
         if (accountNumber == INVALID)   continue;
         screen.displayMessage( "\nEnter your PIN: " ); // prompt for PIN
         pin = validation.checkInt(keypad.getInput()); // input PIN

      } while (accountNumber == INVALID || pin == INVALID); //re-enter the informtion when user Type in a invalid input

      // set userAuthenticated to boolean value returned by database
      userAuthenticated = 
         bankDatabase.authenticateUser( accountNumber, pin );
      
      // check whether authentication succeeded
      if ( userAuthenticated )
      {
         currentAccountNumber = accountNumber; // save user's account #
      } // end if
      else
         screen.displayMessageLine( 
             "Invalid account number or PIN. Please try again." );
   } // end method authenticateUser

   // display the main menu and perform transactions
   private void performTransactions() 
   {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit
  
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
            screen.displayMessageLine( "\nExiting the system..." );
            userExited = true; // this ATM session should end
            userAuthenticated = false; // reset before next ATM session
            currentAccountNumber = 0; // reset before next ATM session 
            screen.displayMessageLine( "\nThank you! Goodbye!" );      
            System.exit(1); //exit programme
         default: // user did not enter an integer from 1-4
            screen.displayMessageLine( 
               "\nYou did not enter a valid selection. Try again." );
            break;
      } // end switch
   } // end method performTransactions
   
   // display the main menu and return an input selection
   private void displayMainMenu()
   {
      /**
      screen.menuGUI();

      MainmenuHandler mainmenuHandler = new MainmenuHandler(); 
      screen.balanceButton.addActionListener(mainmenuHandler);
      screen.withdrawButton.addActionListener(mainmenuHandler);
      screen.transferButton.addActionListener(mainmenuHandler);
      screen.exitButton.addActionListener(mainmenuHandler);
      **/

   } // end method displayMainMenu
         
   // return object of specified Transaction subclass
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // temporary Transaction variable
      
      // determine which type of Transaction to create     
      switch ( type )
      {
         case BALANCE_INQUIRY: // create new BalanceInquiry transaction
            temp = new BalanceInquiry( 
               currentAccountNumber, screen, bankDatabase);
            break;
         case WITHDRAWAL: // create new Withdrawal transaction
            temp = new Withdrawal( currentAccountNumber, screen, 
               bankDatabase, keypad, cashDispenser, validation);
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
      public void actionPerformed(ActionEvent e) {   
         keypad.getKeypadDisplayTextField().replaceSelection(e.getActionCommand());
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