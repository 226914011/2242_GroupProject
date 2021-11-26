import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;


// Screen.java
// Represents the screen of the ATM

public class Screen extends JFrame
{
   //GUI componnent
	public JFrame Mainframe;
   public JPanel contentPane;
   public JPanel mainmenupanel;
   public JButton balanceButton;
   public JButton withdrawButton;
   public JButton transferButton;
   public JButton exitButton;

   public void menuGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		mainmenupanel = new JPanel();
		mainmenupanel.setSize(1000, 1000);
        getContentPane().add(mainmenupanel);
		contentPane.add(mainmenupanel, BorderLayout.CENTER);
		mainmenupanel.setLayout(null);
		
		balanceButton = new JButton("1. View my balance");
		balanceButton.setBounds(234, 300, 532, 100);
		balanceButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		mainmenupanel.add(balanceButton);
		
		withdrawButton = new JButton("2. Withdraw");
		withdrawButton.setBounds(234, 450, 532, 100);
		withdrawButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		mainmenupanel.add(withdrawButton);
		
		transferButton = new JButton("3. Transfer");
		transferButton.setBounds(234, 600, 532, 100);
		transferButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		mainmenupanel.add(transferButton);
		
		exitButton = new JButton("4. Exit");
		exitButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		exitButton.setBounds(234, 750, 532, 100);
		mainmenupanel.add(exitButton);
		contentPane.setLayout(null);

      setVisible(true);
   }

   // displays a message without a carriage return
   public void displayMessage( String message ) 
   {
      System.out.print( message ); 
   } // end method displayMessage

   // display a message with a carriage return
   public void displayMessageLine( String message ) 
   {
      System.out.println( message );   
   } // end method displayMessageLine

   // display a dollar amount
   public void displayDollarAmount( double amount )
   {
      System.out.printf( "$%,.2f", amount );   
   } // end method displayDollarAmount 


} // end class Screen



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