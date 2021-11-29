import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TransferUpdate extends Screen {

	private DisplayMessageJPanel transferUpdatePanel;
	private JTextField availableBtxtfield;
	private JTextField totalbaltxtfield;
	private JLabel transferSuccessLabel;
	private JLabel availableBalanceLabel;
	private JLabel totalBalanceLabel;
	private JButton backButton;
	
	public void buildGUI(){
		transferUpdatePanel = new DisplayMessageJPanel();
        
		super.getMainframe().getContentPane().add(transferUpdatePanel);
		super.getScreenContentPane().add(transferUpdatePanel, BorderLayout.CENTER);

		transferSuccessLabel = new JLabel("The transfer is successful. Updated balance:");
		transferSuccessLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		transferSuccessLabel.setBounds(50, 104, 1204, 85);
		transferUpdatePanel.add(transferSuccessLabel);
		
		availableBalanceLabel = new JLabel("available balance:");
		availableBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		availableBalanceLabel.setBounds(50, 308, 532, 85);
		transferUpdatePanel.add(availableBalanceLabel);
		
		totalBalanceLabel = new JLabel("total balance:");
		totalBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		totalBalanceLabel.setBounds(50, 517, 532, 85);
		transferUpdatePanel.add(totalBalanceLabel);
		
		availableBtxtfield = new JTextField();
		availableBtxtfield.setBounds(730, 313, 524, 85);
		availableBtxtfield.setColumns(10);
		availableBtxtfield.setEditable(false);
		transferUpdatePanel.add(availableBtxtfield);
		
		totalbaltxtfield = new JTextField();
		totalbaltxtfield.setColumns(10);
		totalbaltxtfield.setBounds(730, 523, 524, 85);
		totalbaltxtfield.setEditable(false);
		transferUpdatePanel.add(totalbaltxtfield);
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Arial Black", Font.PLAIN, 35));
		backButton.setBounds(574, 835, 292, 85);
		transferUpdatePanel.add(backButton);
		
		super.getMainframe().setVisible(true);
		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JLabel getAvailableBalanceLabel(){
		return availableBalanceLabel;
	}
	
	public JLabel getTotalBalanceLabel(){
		return totalBalanceLabel;
	}
	
	public JButton getBackButton(){
		return backButton;
	}
	
}
