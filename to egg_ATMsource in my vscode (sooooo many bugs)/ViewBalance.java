import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ViewBalance extends Screen {

	private DisplayMessageJPanel viewbalancePanel;
	private JTextField aBalanceTextField;
	private JTextField tBalanceTextField;
	private JLabel aBalanceLabel;
	private JLabel balanceLabel;
	private JLabel tBalanceLabel;
	private JButton returnButton;

	public void buildGUI() {
		viewbalancePanel = new DisplayMessageJPanel();

		super.getMainframe().getContentPane().add(viewbalancePanel);
		super.getScreenContentPane().add(viewbalancePanel, BorderLayout.CENTER);

		// display balance label
		balanceLabel = new JLabel("Balance");
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setFont(new Font("Arial", Font.BOLD, 64));
		balanceLabel.setBounds(458, 104, 524, 84);
		balanceLabel.setForeground(Color.LIGHT_GRAY);
		viewbalancePanel.add(balanceLabel);

		// display available balance label
		aBalanceLabel = new JLabel("Available Balance");
		aBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		aBalanceLabel.setBounds(50, 314, 544, 85);
		aBalanceLabel.setForeground(Color.LIGHT_GRAY);
		viewbalancePanel.add(aBalanceLabel);

		// displays total balance label
		tBalanceLabel = new JLabel("Total Balance");
		tBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		tBalanceLabel.setBounds(50, 524, 544, 85);
		tBalanceLabel.setForeground(Color.LIGHT_GRAY);
		viewbalancePanel.add(tBalanceLabel);

		// create Available balance textField
		aBalanceTextField = new JTextField();
		aBalanceTextField.setEditable(false);
		aBalanceTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		aBalanceTextField.setBounds(730, 313, 524, 85);
		aBalanceTextField.setColumns(10);
		viewbalancePanel.add(aBalanceTextField);

		// create total balance textField
		tBalanceTextField = new JTextField();
		tBalanceTextField.setEditable(false);
		tBalanceTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		tBalanceTextField.setColumns(10);
		tBalanceTextField.setBounds(730, 524, 524, 85);
		viewbalancePanel.add(tBalanceTextField);

		// create a return Button
		returnButton = new JButton("Return to main menu");
		returnButton.setFont(new Font("Arial", Font.PLAIN, 40));
		returnButton.setBounds(458, 837, 524, 85);
		viewbalancePanel.add(returnButton);

		super.getMainframe().setVisible(true);
		super.getMainframe().pack();
		super.getMainframe().repaint();

	}

	public JTextField getABalanceTextField() {
		return aBalanceTextField;
	}

	public JTextField getTBalanceTextField() {
		return tBalanceTextField;
	}

	public JButton getButton() {
		return returnButton;
	}

}
