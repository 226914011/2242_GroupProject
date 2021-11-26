import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainmenu frame = new mainmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//need to change when copy to vscode
		JPanel panel = new JPanel();
        getContentPane().add(panel);
        

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(1440, 1024));
		panel.setLayout(null);

		//copy hold part until this line XD
		
		
		//main menu button, size: 532 * 90
		JButton balanceButton = new JButton("1. View my balance");
		balanceButton.setBounds(458, 313, 524, 90);
		balanceButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		panel.add(balanceButton);
		
		JButton WithdrawButton = new JButton("2. Withdraw");
		WithdrawButton.setBounds(458, 480, 524, 90);
		WithdrawButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		panel.add(WithdrawButton);
		
		JButton transferButton = new JButton("3. Transfer");
		transferButton.setBounds(458, 644, 524, 90);
		transferButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		panel.add(transferButton);
		
		JButton exitButton = new JButton("4. Exit");
		exitButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		exitButton.setBounds(458, 814, 524, 90);
		panel.add(exitButton);
		
		JLabel lblNewLabel = new JLabel("Enter a choice");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 64));
		lblNewLabel.setBounds(458, 104, 524, 85);
		panel.add(lblNewLabel);
		
		//copy this
        pack();

	}
	
	public class DisplayMessageJPanel extends JPanel{
	    public DisplayMessageJPanel(){
	        setSize(new Dimension(1440, 1024));
	        //Absolute layout
	        setLayout(null);


	        //background with color
	        setBackground(new Color(56, 60, 102));
	    }

}
}
