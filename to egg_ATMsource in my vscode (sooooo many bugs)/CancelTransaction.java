// CancelTransaction.java
// Display message for indicating cancell transaction

import javax.swing.JLabel;
import java.awt.Font;

public class CancelTransaction extends Screen {

	private DisplayMessageJPanel canTransactionPanel;
	private JLabel canTransLabel;
	private JLabel returnMenuLabel;

	public void buildGUI() {
		canTransactionPanel = new DisplayMessageJPanel();
        
		canTransLabel = new JLabel("Cancelling transaction...");
		canTransLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		canTransLabel.setBounds(50, 471, 925, 58);
		canTransactionPanel.add(canTransLabel);
		
		returnMenuLabel = new JLabel("Returning to the main menu...");
		returnMenuLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		returnMenuLabel.setBounds(50, 615, 925, 58);
		canTransactionPanel.add(returnMenuLabel);

		super.getMainframe().setVisible(true);
		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JLabel getCanTransLabel(){
		return canTransLabel;
	}

	public JLabel getReturnLabel(){
		return returnMenuLabel;
	}
}
