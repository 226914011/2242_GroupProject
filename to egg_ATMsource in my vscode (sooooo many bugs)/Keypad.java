// Keypad.java
// Represents the keypad of the ATM
import java.awt.*;
import java.util.Scanner; // program uses Scanner to obtain user input

import javax.swing.*;


public class Keypad
{
   private JTextField keypadDisplayTextField;
	private JButton[] keys;
   private KeypadJPanel keypadJPanel;
   private JLabel warningLabel;
   private Scanner input; // reads data from the command line
   private String userInput = "";
   
   // no-argument constructor initializes the Scanner
   public Keypad()
   {
      input = new Scanner( System.in );    
      keypadJPanel = new KeypadJPanel();
   } // end no-argument Keypad constructor

   // return a string value entered by user 
   public String getInput()
   {
      return userInput; // change user input to string type for validation 
   } // end method getInput

   // return a double value enter by user
   public double getDoubleInput(){
      return input.nextDouble();
   }

   
	public class KeypadJPanel extends JPanel{
      public KeypadJPanel(){
          setPreferredSize(new Dimension(550, 1024));
          //Absolute layout
          setLayout(null);
          
          //transparent background
          setOpaque(false);
          
          
        
          //keypad display textField
        keypadDisplayTextField = new JTextField();
        keypadDisplayTextField.setEditable(false);
        keypadDisplayTextField.setFont(new Font("Arial", Font.PLAIN, 40));
        keypadDisplayTextField.setBounds(100, 339, 400, 56);
        add(keypadDisplayTextField);
        keypadDisplayTextField.setColumns(10);
        keypadDisplayTextField.setText(userInput);
          

        warningLabel = new JLabel("* Please do not use \".\" as input");
        warningLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        warningLabel.setBounds(100, 267, 400, 32);
        warningLabel.setForeground(Color.RED);
        warningLabel.setVisible(false);
        add(warningLabel);

        
          //keypad button setting
        JPanel actualKeypadPanel = new JPanel();
        actualKeypadPanel.setBounds(100, 399, 400, 400);
        actualKeypadPanel.setOpaque(false);

        
        add(actualKeypadPanel);
        actualKeypadPanel.setLayout(new GridLayout(4, 4, 6, 6));
        
        //keypad button from tutor 9
         keys = new JButton[ 14 ]; // array keys contains 16 JButtons 

        // initialize all digit key buttons
        for ( int i = 0; i <= 9; i++ )
           keys[ i ] = new JButton( String.valueOf( i ) );
        
        // initialize all function key buttons
        keys[ 10 ] = new JButton( "Cancel" );
        keys[ 11 ] = new JButton( "Clear" );
        keys[ 12 ] = new JButton( "Enter" );
        keys[ 13 ] = new JButton( "." );
        
         // add buttons to keyPadJPanel panel
         // 7, 8, 9, divide
         for ( int i = 7; i <= 10; i++ )
            actualKeypadPanel.add(keys[i]);
         
         // 4, 5, 6
         for ( int i = 4; i <= 6; i++ )
            actualKeypadPanel.add(keys[i]);
         
         // Clear
         actualKeypadPanel.add(keys[ 11 ]);
         
         // 1, 2, 3
         for ( int i = 1; i <= 3; i++ )
            actualKeypadPanel.add(keys[i]);
         
         //Enter
         actualKeypadPanel.add(keys[ 12 ]);
         
         //0
         actualKeypadPanel.add(keys[ 0 ]);
         
         // "."
         actualKeypadPanel.add(keys[ 13 ]);

         // initialize all button font size and button color
         for (int i = 0; i <= 13; i++) {
            if (i<=9 || i ==13)
               keys[i].setFont(new Font("Arial", Font.PLAIN, 40));
            else
               keys[i].setFont(new Font("Arial", Font.PLAIN, 20));

           keys[i].setBackground(new Color(106,107,138));
           keys[i].setOpaque(true);
           keys[i].setBorderPainted(false);
              
         }
         

          //background with color
          //setBackground(new Color(56, 60, 102));
      }
  }
  
  public KeypadJPanel getKeypadJPanel(){
     return keypadJPanel;
  }

  public JButton[] getKeys(){
     return keys;
  }
  public String getUserInput(){
     return userInput;
  }
  public JTextField getKeypadDisplayTextField(){
     return keypadDisplayTextField;
  }
  public void warning(){
     warningLabel.setVisible(true);
  }

  public void closeWarning(){
   warningLabel.setVisible(false);
  }
} // end class Keypad  



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