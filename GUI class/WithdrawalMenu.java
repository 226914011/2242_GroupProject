import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class WithdrawalMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawalMenu frame = new WithdrawalMenu();
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
	public WithdrawalMenu() {
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
		
		JLabel WithMenuLabel = new JLabel("Withdrawal Menu");
		WithMenuLabel.setFont(new Font("Arial", Font.PLAIN, 64));
		WithMenuLabel.setBounds(438, 104, 532, 85);
		panel.add(WithMenuLabel);
		
		JButton W100Button = new JButton("1. $100");
		W100Button.setFont(new Font("Arial", Font.PLAIN, 40));
		W100Button.setBounds(180, 305, 404, 100);
		panel.add(W100Button);
		
		JButton W200Button = new JButton("2. $200");
		W200Button.setFont(new Font("Arial", Font.PLAIN, 40));
		W200Button.setBounds(180, 513, 404, 100);
		panel.add(W200Button);
		
		JButton W500Button = new JButton("3. $500");
		W500Button.setFont(new Font("Arial", Font.PLAIN, 40));
		W500Button.setBounds(180, 720, 404, 100);
		panel.add(W500Button);
		
		JButton W1000Button = new JButton("4. $1000");
		W1000Button.setFont(new Font("Arial", Font.PLAIN, 40));
		W1000Button.setBounds(850, 305, 404, 100);
		panel.add(W1000Button);
		
		JButton WCustomButton = new JButton("5. Custom Amount");
		WCustomButton.setFont(new Font("Arial", Font.PLAIN, 40));
		WCustomButton.setBounds(850, 512, 404, 100);
		panel.add(WCustomButton);
		
		JButton WCancelButton = new JButton("6.Cancel transaction");
		WCancelButton.setFont(new Font("Arial", Font.PLAIN, 40));
		WCancelButton.setBounds(850, 719, 404, 100);
		panel.add(WCancelButton);
		
		pack();
	}
}
