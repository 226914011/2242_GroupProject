import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Welcome extends Screen{
	private JLabel welcomeLabel;
	private DisplayMessageJPanel welcomePanel;
	private JLabel touchLabel;


	public Welcome(){

	}

	/**
	 * Create the frame.
	 */
	public void buildGUI() {
		welcomePanel = new DisplayMessageJPanel();


		//need to change when copy to vscode
        super.getMainframe().getContentPane().add(welcomePanel);
        

		super.getSrceenContentPane().add(welcomePanel, BorderLayout.CENTER);

		welcomeLabel = new JLabel("Welcome to the ATM System!");
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(0, 0, 1440, 1024);
		welcomeLabel.setForeground(Color.WHITE);
		welcomePanel.add(welcomeLabel);
		
		touchLabel = new JLabel("Touch the screen to continue...");
		touchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		touchLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		touchLabel.setBounds(0, 570, 1440, 58);
		touchLabel.setForeground(Color.WHITE);
		welcomePanel.add(touchLabel);
		
		pack();

		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JLabel getWelcomeLabel(){
		return welcomeLabel;
	}

}
