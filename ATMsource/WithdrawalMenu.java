import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

// GUI WithdrawalMenu inherits Screen
public class WithdrawalMenu extends Screen {

	// private instance variables
	private DisplayMessageJPanel withdrawalPanel;
	private JLabel invalidMessageLabel;
	private JLabel withMenuLabel;
	private JButton wButtons[] = new JButton[6];

	// method for building GUI Components
	public void buildGUI() {
		withdrawalPanel = new DisplayMessageJPanel(); // initializing Withdrawal Menu Panel

		// inherits from superclass Screen to get mainframe and panel, and adding the
		// current panel
		super.getMainframe().getContentPane().add(withdrawalPanel);
		super.getScreenContentPane().add(withdrawalPanel, BorderLayout.CENTER);

		withMenuLabel = new JLabel("Withdrawal Menu"); // initializing label with text
		withMenuLabel.setFont(new Font("Arial", Font.PLAIN, 64)); // set font properties of label
		withMenuLabel.setForeground(Color.LIGHT_GRAY);
		withMenuLabel.setBounds(438, 104, 532, 85); // set boundaries of label
		withdrawalPanel.add(withMenuLabel); // adding label to the panel

		invalidMessageLabel = new JLabel("");
		invalidMessageLabel.setFont(new Font("Arial", Font.PLAIN, 25)); // set font properties of label
		invalidMessageLabel.setForeground(Color.RED);
		invalidMessageLabel.setBounds(180, 200, 1068, 90); // set boundaries of label
		withdrawalPanel.add(invalidMessageLabel); // adding label to the panel

		// initializing button array with text
		wButtons[0] = new JButton("1. $100");
		wButtons[1] = new JButton("2. $200");
		wButtons[2] = new JButton("3. $500");
		wButtons[3] = new JButton("4. $1000");
		wButtons[4] = new JButton("5. Custom Amount");
		wButtons[5] = new JButton("6.Cancel transaction");

		// for loop setting up buttons
		for (int i = 0; i <= 5; i++) {
			wButtons[i].setFont(new Font("Arial", Font.PLAIN, 40));
			if (i < 3)
				wButtons[i].setBounds(180, 305 + 207 * (i), 404, 100);
			else
				wButtons[i].setBounds(850, 305 + 207 * (i - 3), 404, 100);
			wButtons[i].setFocusPainted(false);
			withdrawalPanel.add(wButtons[i]);
		}

		super.getMainframe().setVisible(true);
		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JLabel getWithMenuLabel() {
		return withMenuLabel;
	}

	public JButton[] getwButtons() {
		return wButtons;
	}

	public void setInvalidMessage(String displayMessage) {
		invalidMessageLabel.setText(displayMessage);
	}
}
