// BalanceInquiry.java
// Represents a balance inquiry ATM transaction
import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.JTextField;

public class BalanceInquiry extends Transaction
{  
   private ATM atm;
   private Screen screen;
   private ViewBalance viewBalance;

   // BalanceInquiry constructor
   public BalanceInquiry( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase , ViewBalance atmViewBalance)
   {
      super( userAccountNumber, atmScreen, atmBankDatabase );
      screen = super.getScreen();
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

      screen.getMainframe().getContentPane().removeAll();
      viewBalance.buildGUI();
      viewBalance.getABalanceTextField().setText(String.valueOf(availableBalance));
      viewBalance.getTBalanceTextField().setText(String.valueOf(totalBalance));
      screen.getMainframe().repaint();
      screen.getMainframe().revalidate();
   } // end method execute
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