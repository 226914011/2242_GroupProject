// BalanceInquiry.java
// Represents a balance inquiry ATM transaction
import java.awt.event.*;

public class BalanceInquiry extends Transaction
{  
   private ATM atm;
   private Screen screen;
   private ViewBalance viewBalance;

   // BalanceInquiry constructor
   public BalanceInquiry( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, ATM theATM , ViewBalance atmViewBalance)
   {
      super( userAccountNumber, atmScreen, atmBankDatabase );
      screen = super.getScreen();
      atm = theATM;
      viewBalance = atmViewBalance;
   } // end BalanceInquiry constructor

   // performs the transaction
   public void execute()
   {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();

      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance( getAccountNumber() );

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance( getAccountNumber() );

      // remove all the components in the current content panel of the main frame
      screen.getMainframe().getContentPane().removeAll();
      viewBalance.buildGUI();  // method for building GUI of viewing account balance
      viewBalance.getABalanceTextField().setText(String.valueOf(availableBalance));    // get method to receive account available balance and changed to String type
      viewBalance.getTBalanceTextField().setText(String.valueOf(totalBalance));        // get method to receive account total balance and changed to String type
      screen.getMainframe().repaint();
      screen.getMainframe().revalidate();

      ViewBalanceHandler viewBalanceHandler = new ViewBalanceHandler();   // create event handler for viewing balance
      viewBalance.getButton().addActionListener(viewBalanceHandler);      // register button for event handler
   } // end method execute

   // private inner class ViewBalanceHandler for event handling
   private class ViewBalanceHandler implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         screen.getMainframe().getContentPane().removeAll();   // remove all the components in the content panel
         screen.getMainframe().repaint();                      // refresh the frame
         screen.getMainframe().revalidate();                   // validate the frame
         atm.mainmenuGUI();                                    // return to main menu
      }
   }
} // end class BalanceInquiry



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