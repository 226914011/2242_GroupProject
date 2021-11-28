import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WithdrawalConfirm extends JFrame {

	private JPanel contentPane;
	private JTextField withAmountTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawalConfirm frame = new WithdrawalConfirm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WithdrawalConfirm() {
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
		
		JLabel amountWLabel = new JLabel("The amount for withdrawal");
		amountWLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		amountWLabel.setBounds(50, 313, 932, 82);
		panel.add(amountWLabel);
		
		withAmountTextField = new JTextField();
		withAmountTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		withAmountTextField.setEditable(false);
		withAmountTextField.setBounds(730, 313, 524, 85);
		panel.add(withAmountTextField);
		withAmountTextField.setColumns(10);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		confirmButton.setBounds(166, 836, 292, 84);
		panel.add(confirmButton);
		
		JButton reEnterButton = new JButton("Re-enter");
		reEnterButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		reEnterButton.setBounds(574, 836, 292, 84);
		panel.add(reEnterButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		cancelButton.setBounds(982, 836, 292, 84);
		panel.add(cancelButton);
		
		JLabel confirmationLabel = new JLabel("Withdrawal Confirmation");
		confirmationLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		confirmationLabel.setBounds(506, 53, 500, 82);
		panel.add(confirmationLabel);

		pack();
	}
}
