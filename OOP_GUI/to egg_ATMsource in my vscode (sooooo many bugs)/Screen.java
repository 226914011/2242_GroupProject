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
	private static JFrame Mainframe;
	private static MyBGcontentPane contentPane;



	public Screen(){
		Mainframe = new JFrame();
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new MyBGcontentPane();
		contentPane.setLayout(new BorderLayout(0, 0));
		Mainframe.setContentPane(contentPane);
    
		//set panel size
        contentPane.setPreferredSize(new Dimension(1440, 1024));
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

    public JFrame getMainframe(){
	   return Mainframe;
    }

	public JPanel getSrceenContentPane(){
		return contentPane;
	}

	public class MyBGcontentPane extends JPanel{
	    @Override
	    public void paintComponent(Graphics g) {
	          super.paintComponent(g);
	          ImageIcon bgimage = new ImageIcon("ATM_login.png");
	          g.drawImage(bgimage.getImage(), 0, 0, this.getWidth(), this.getHeight(),  null);
	    }
	}
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