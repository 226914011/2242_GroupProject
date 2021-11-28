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

	private JButton Buttons[] = new JButton[4];

	public void buildGUI() {
		DisplayMessageJPanel panel = new DisplayMessageJPanel();
		super.getMainframe().getContentPane().add(panel);

		super.getScreenContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// main menu button, size: 532 * 90
		/*
		 * JButton balanceButton = new JButton("1. View my balance");
		 * balanceButton.setBounds(458, 313, 524, 90);
		 * balanceButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		 * balanceButton.setFocusPainted(false);
		 * panel.add(balanceButton);
		 * 
		 * JButton WithdrawButton = new JButton("2. Withdraw");
		 * WithdrawButton.setBounds(458, 480, 524, 90);
		 * WithdrawButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		 * WithdrawButton.setFocusPainted(false);
		 * panel.add(WithdrawButton);
		 * 
		 * JButton transferButton = new JButton("3. Transfer");
		 * transferButton.setBounds(458, 644, 524, 90);
		 * transferButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		 * transferButton.setFocusPainted(false);
		 * panel.add(transferButton);
		 * 
		 * JButton exitButton = new JButton("4. Exit");
		 * exitButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		 * exitButton.setBounds(458, 814, 524, 90);
		 * exitButton.setFocusPainted(false);
		 * panel.add(exitButton);
		 * 
		 * JLabel choiceLabel = new JLabel("Enter a choice");
		 * choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 * choiceLabel.setFont(new Font("Arial", Font.PLAIN, 64));
		 * choiceLabel.setBounds(458, 104, 524, 85);
		 * choiceLabel.setForeground(Color.LIGHT_GRAY);
		 * panel.add(choiceLabel);
		 */

		JLabel choiceLabel = new JLabel("Please choose an option");
		choiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		choiceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		choiceLabel.setBounds(458, 104, 524, 85);
		choiceLabel.setForeground(Color.LIGHT_GRAY);
		panel.add(choiceLabel);

		Buttons[0] = new JButton("1. View my balance");
		Buttons[1] = new JButton("2. Withdrawal");
		Buttons[2] = new JButton("3. Transfer");
		Buttons[3] = new JButton("4. Exit");

		for (int i = 0; i < 4; i++) {
			Buttons[i].setFont(new Font("Arial Black", Font.PLAIN, 40));
			Buttons[i].setBounds(458, (313 + 167 * i), 524, 90);
			Buttons[i].setFocusPainted(false);
			panel.add(Buttons[i]);
		}

		// copy this
		super.getMainframe().pack();

	}

	public JButton[] getButtons() {
		return Buttons;
	}
}
