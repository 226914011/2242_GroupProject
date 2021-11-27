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

	private JPanel contentPane;
	private JTextField ABalanceTextField;
	private JTextField TBalanceTextField;

	public ViewBalance() {
		super();
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
		
		JLabel BalanceLabel = new JLabel("Balance");
		BalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BalanceLabel.setFont(new Font("Arial", Font.BOLD, 64));
		BalanceLabel.setBounds(458, 104, 524, 84);
		panel.add(BalanceLabel);
		
		JLabel ABalanceLabel = new JLabel("Available Balance");
		ABalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		ABalanceLabel.setBounds(50, 314, 544, 85);
		panel.add(ABalanceLabel);
		
		JLabel TBalanceLabel = new JLabel("Total Balance");
		TBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		TBalanceLabel.setBounds(50, 524, 544, 85);
		panel.add(TBalanceLabel);
		
		ABalanceTextField = new JTextField();
		ABalanceTextField.setEditable(false);
		ABalanceTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		ABalanceTextField.setBounds(730, 313, 524, 85);
		panel.add(ABalanceTextField);
		ABalanceTextField.setColumns(10);
		
		TBalanceTextField = new JTextField();
		TBalanceTextField.setEditable(false);
		TBalanceTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		TBalanceTextField.setColumns(10);
		TBalanceTextField.setBounds(730, 524, 524, 85);
		panel.add(TBalanceTextField);
		
		JButton ReturnButton = new JButton("Return to main menu");
		ReturnButton.setFont(new Font("Arial", Font.PLAIN, 40));
		ReturnButton.setBounds(458, 837, 524, 85);
		panel.add(ReturnButton);

		pack();
	}
}
