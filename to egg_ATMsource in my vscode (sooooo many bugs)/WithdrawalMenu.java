import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class WithdrawalMenu extends Screen {

	private DisplayMessageJPanel withdrawalPanel;
	private JLabel withMenuLabel;
	/*
	 * private JButton w100Button;
	 * private JButton w200Button;
	 * private JButton w500Button;
	 * private JButton w1000Button;
	 * private JButton wCustomButton;
	 * private JButton wCancelButton;
	 */

	private JButton wButtons[] = new JButton[6];

	public void buildGUI() {
		withdrawalPanel = new DisplayMessageJPanel();

		super.getMainframe().getContentPane().add(withdrawalPanel);
		super.getScreenContentPane().add(withdrawalPanel, BorderLayout.CENTER);

		withMenuLabel = new JLabel("Withdrawal Menu");
		withMenuLabel.setFont(new Font("Arial", Font.PLAIN, 64));
		withMenuLabel.setBounds(438, 104, 532, 85);
		withdrawalPanel.add(withMenuLabel);

		wButtons[0] = new JButton("1. $100");
		wButtons[1] = new JButton("2. $200");
		wButtons[2] = new JButton("3. $500");
		wButtons[3] = new JButton("4. $1000");
		wButtons[4] = new JButton("5. Custom Amount");
		wButtons[5] = new JButton("6.Cancel transaction");

		for (int i = 0; i < 4; i++) {
			wButtons[i].setFont(new Font("Arial", Font.PLAIN, 40));
			if (i < 3)
				wButtons[i].setBounds(180, 305 + 207 * (i), 404, 100);
			else
				wButtons[i].setBounds(850, 305 + 207 * (i - 3), 404, 100);
			wButtons[i].setFocusPainted(false);
			withdrawalPanel.add(wButtons[i]);
		}
		/*
		 * w100Button = new JButton("1. $100");
		 * w100Button.setFont(new Font("Arial", Font.PLAIN, 40));
		 * w100Button.setBounds(180, 305, 404, 100);
		 * withdrawalPanel.add(w100Button);
		 * 
		 * w200Button = new JButton("2. $200");
		 * w200Button.setFont(new Font("Arial", Font.PLAIN, 40));
		 * w200Button.setBounds(180, 513, 404, 100);
		 * withdrawalPanel.add(w200Button);
		 * 
		 * w500Button = new JButton("3. $500");
		 * w500Button.setFont(new Font("Arial", Font.PLAIN, 40));
		 * w500Button.setBounds(180, 720, 404, 100);
		 * withdrawalPanel.add(w500Button);
		 * 
		 * w1000Button = new JButton("4. $1000");
		 * w1000Button.setFont(new Font("Arial", Font.PLAIN, 40));
		 * w1000Button.setBounds(850, 305, 404, 100);
		 * withdrawalPanel.add(w1000Button);
		 * 
		 * wCustomButton = new JButton("5. Custom Amount");
		 * wCustomButton.setFont(new Font("Arial", Font.PLAIN, 40));
		 * wCustomButton.setBounds(850, 512, 404, 100);
		 * withdrawalPanel.add(wCustomButton);
		 * 
		 * wCancelButton = new JButton("6.Cancel transaction");
		 * wCancelButton.setFont(new Font("Arial", Font.PLAIN, 40));
		 * wCancelButton.setBounds(850, 719, 404, 100);
		 * withdrawalPanel.add(wCancelButton);
		 */

		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JLabel getWithMenuLabel() {
		return withMenuLabel;
	}

	/*
	 * public JButton getw100Button(){
	 * return w100Button;
	 * }
	 * public JButton getw200Button(){
	 * return w200Button;
	 * }
	 * public JButton getw500Button(){
	 * return w500Button;
	 * }
	 * public JButton getw1000Button(){
	 * return w1000Button;
	 * }
	 * public JButton getwCustomButton(){
	 * return wCustomButton;
	 * }
	 * public JButton getwCancelButton(){
	 * return wCancelButton;
	 * }
	 */
	public JButton[] getwButtons() {
		return wButtons;
	}

}
