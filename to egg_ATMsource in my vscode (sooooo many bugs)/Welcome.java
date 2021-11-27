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

public class Welcome extends Screen {
	private JLabel welcomeLabel;
	private JLabel touchLabel;

	/**
	 * Create the frame.
	 */
	public Welcome() {
		
		//need to change when copy to vscode
		DisplayMessageJPanel panel = new DisplayMessageJPanel();
        super.getMainframe().getContentPane().add(panel);
		super.getSrceenContentPane().add(panel, BorderLayout.CENTER);

	
		welcomeLabel = new JLabel("Welcome to the ATM System!");
		welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 45));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(0, 0, 1440, 1024);
		welcomeLabel.setForeground(Color.WHITE);
		panel.add(welcomeLabel);
		
		touchLabel = new JLabel("Touch the screen to continue...");
		touchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		touchLabel.setFont(new Font("Arial", Font.PLAIN, 35));
		touchLabel.setBounds(0, 570, 1440, 58);
		touchLabel.setForeground(Color.WHITE);
		panel.add(touchLabel);
		
		pack();
	}


	public JLabel getWelcomeLabel(){
		return welcomeLabel;
	}
}
