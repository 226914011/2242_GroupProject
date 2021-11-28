import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewBalance extends Screen {

	private JPanel withdrawalPanel;
	private JTextField ABalanceTextField;
	private JTextField TBalanceTextField;


	/**
	 * Create the frame.
	public ViewBalance() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
	public void buildGUI()
	{
		withdrawalPanel = new DisplayMessageJPanel();

		super.getMainframe().getContentPane().add(withdrawalPanel);
		super.getScreenContentPane().add(withdrawalPanel, BorderLayout.CENTER);
		
		JLabel BalanceLabel = new JLabel("Balance");
		BalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BalanceLabel.setFont(new Font("Arial", Font.BOLD, 64));
		BalanceLabel.setBounds(458, 104, 524, 84);
		withdrawalPanel.add(BalanceLabel);
		
		JLabel ABalanceLabel = new JLabel("Available Balance");
		ABalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		ABalanceLabel.setBounds(50, 314, 544, 85);
		withdrawalPanel.add(ABalanceLabel);
		
		JLabel TBalanceLabel = new JLabel("Total Balance");
		TBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		TBalanceLabel.setBounds(50, 524, 544, 85);
		withdrawalPanel.add(TBalanceLabel);
		
		ABalanceTextField = new JTextField();
		ABalanceTextField.setEditable(false);
		ABalanceTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		ABalanceTextField.setBounds(730, 313, 524, 85);
		withdrawalPanel.add(ABalanceTextField);
		ABalanceTextField.setColumns(10);
		
		TBalanceTextField = new JTextField();
		TBalanceTextField.setEditable(false);
		TBalanceTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		TBalanceTextField.setColumns(10);
		TBalanceTextField.setBounds(730, 524, 524, 85);
		withdrawalPanel.add(TBalanceTextField);
		
		JButton ReturnButton = new JButton("Return to main menu");
		ReturnButton.setFont(new Font("Arial", Font.PLAIN, 40));
		ReturnButton.setBounds(458, 837, 524, 85);
		withdrawalPanel.add(ReturnButton);

		super.getMainframe().pack();
		super.getMainframe().repaint();

		System.out.println("Fk you 4everrrrrrrrrrrrrrrrrrrrr");
	}
	public JTextField getABalanceTextField(){
		return ABalanceTextField;
	}
	public JTextField getTBalanceTextField(){
		return TBalanceTextField;
	}
}
