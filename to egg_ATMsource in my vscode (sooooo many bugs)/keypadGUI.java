import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

public class KeypadGUI extends Screen{

	private JPanel contentPane;
	private JTextField keypadDisplayTextField;
	private JButton keys[];



	/**
	 * Create the frame.
	 */
	public KeypadGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//need to change when copy to vscode
		JPanel DisplayPanel = new JPanel();
        getContentPane().add(DisplayPanel);
        //must ah
        contentPane.setPreferredSize(new Dimension(1440, 1024));


		contentPane.add(DisplayPanel, BorderLayout.CENTER);
		DisplayPanel.setPreferredSize(new Dimension(890, 1024));
		DisplayPanel.setLayout(null);
		
		
		//need to change when I copy it to vscode, this part of code will be paste to KeypadJPanel class
		KeypadJPanel keypadPanel = new KeypadJPanel();	//it need to be change to KeypadJPanel keypadPanel = new KeypadJPanel();
		keypadPanel.setPreferredSize(new Dimension(550, 1024));
		contentPane.add(keypadPanel, BorderLayout.EAST);			// this is sooooooooooooooooooooooooooooooo  usefulllll, pls remember keypad should in BorderLayout.EAST
		keypadPanel.setLayout(null);

		setResizable( false );

        pack();
	}
	
	
	//just copy and paste it to Keypad XD, 
	public class KeypadJPanel extends JPanel{
	    public KeypadJPanel(){
	        setPreferredSize(new Dimension(550, 1024));
	        //Absolute layout
	        setLayout(null);
	        
			
	        //keypad display textField
			keypadDisplayTextField = new JTextField();
			keypadDisplayTextField.setEditable(false);
			keypadDisplayTextField.setFont(new Font("Arial", Font.PLAIN, 40));
			keypadDisplayTextField.setBounds(100, 339, 400, 56);
			this.add(keypadDisplayTextField);
			keypadDisplayTextField.setColumns(10);
	        
	        //keypad button setting
			JPanel actualKeypadPanel = new JPanel();
			actualKeypadPanel.setBounds(100, 399, 400, 400);
			actualKeypadPanel.setOpaque(false);

			
			this.add(actualKeypadPanel);
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

		    // initialize all button font size
		    for (int i = 0; i <= 13; i++) {
		    	if (i<=9 || i ==13)
		    		keys[i].setFont(new Font("Arial", Font.PLAIN, 40));
		    	else
		    		keys[i].setFont(new Font("Arial", Font.PLAIN, 20));
		    }
		    
	        //background with color, can // this in following version
	        setBackground(new Color(56, 60, 102));
	    }
	}
}
