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

public class MainMenu extends Screen {

	public void buildGUI() {
		DisplayMessageJPanel panel = new DisplayMessageJPanel();
        super.getMainframe().getContentPane().add(panel);
        

		super.getScreenContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
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
		
		JLabel choiceLabel = new JLabel("Enter a choice");
		choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		choiceLabel.setFont(new Font("Arial", Font.PLAIN, 64));
		choiceLabel.setBounds(458, 104, 524, 85);
		choiceLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(choiceLabel);
		
		//copy this
        super.getMainframe().pack();

	}
}
