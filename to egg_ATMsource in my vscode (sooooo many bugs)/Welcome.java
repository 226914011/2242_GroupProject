// Welcome.java
// Displaying welcome screen of system

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

// Welcome class inherits Screen
public class Welcome extends Screen{

	//private instance variables
	private JLabel welcomeLabel;				// Label displaying welcome message
	private DisplayMessageJPanel welcomePanel;	// DisplayMessageJPanel class for creating welcomepanel with size and bg color 
	private JLabel touchLabel;					// Label displaying touch the screen message

	//method for building GUI Components
	public void buildGUI() {
		welcomePanel = new DisplayMessageJPanel();	// initialize welcomePanel

        super.getMainframe().getContentPane().add(welcomePanel);	// inherits from superclass Screen to get mainframe and panel
		super.getScreenContentPane().add(welcomePanel, BorderLayout.CENTER);	

		welcomeLabel = new JLabel("Welcome to the ATM System!");		// initializing label with text
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 45));		// set font properties of label
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);		// set alignment of label
		welcomeLabel.setBounds(0, 0, 1440, 1024);						// set boundaries of label
		welcomeLabel.setForeground(Color.LIGHT_GRAY);					// set color of label
		welcomePanel.add(welcomeLabel);									// adding label to the panel
		
		touchLabel = new JLabel("Touch the screen to continue...");				
		touchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		touchLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		touchLabel.setBounds(0, 570, 1440, 58);
		touchLabel.setForeground(Color.LIGHT_GRAY);
		welcomePanel.add(touchLabel);

		super.getMainframe().setVisible(true);		// set the panel to visible
		super.getMainframe().pack();				// set the frame to fit the preferred size
		super.getMainframe().repaint();				// refresh the frame
	}

	// get method to access welcome label
	public JLabel getWelcomeLabel(){									
		return welcomeLabel;
	}

}
