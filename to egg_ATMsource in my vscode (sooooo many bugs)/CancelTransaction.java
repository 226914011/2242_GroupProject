// CancelTransaction.java
// Display message for indicating cancell transaction

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;


public class CancelTransaction extends Screen {

	private DisplayMessageJPanel canTransactionPanel;

	public void buildGUI() {
		canTransactionPanel = new DisplayMessageJPanel();

		super.getMainframe().getContentPane().add(canTransactionPanel);	
		super.getScreenContentPane().add(canTransactionPanel, BorderLayout.CENTER);
        
		JLabel canTransLabel = new JLabel("Cancelling transaction...");
		canTransLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		canTransLabel.setBounds(50, 471, 925, 58);
		canTransLabel.setForeground(Color.LIGHT_GRAY);
		canTransactionPanel.add(canTransLabel);
		
		JLabel returnMenuLabel = new JLabel("Returning to the main menu...");
		returnMenuLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		returnMenuLabel.setBounds(50, 615, 925, 58);
		returnMenuLabel.setForeground(Color.LIGHT_GRAY);
		canTransactionPanel.add(returnMenuLabel);

		super.getMainframe().setVisible(true);
		super.getMainframe().pack();
		super.getMainframe().repaint();
	}
}
