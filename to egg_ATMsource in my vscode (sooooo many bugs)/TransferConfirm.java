import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TransferConfirm extends Screen {

	private DisplayMessageJPanel transferConfirmPanel;
	private JLabel accountNumLabel;
	private JLabel transferAmountLabel;
	private JTextField[] tCTextField = new JTextField[2];
	private JButton[] tCButton = new JButton[3];

	public void buildGUI(){
	transferConfirmPanel = new DisplayMessageJPanel();
		
	super.getMainframe().getContentPane().add(transferConfirmPanel);
	super.getScreenContentPane().add(transferConfirmPanel, BorderLayout.CENTER);
		
		accountNumLabel = new JLabel("The account number for Transfer:");
		accountNumLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		accountNumLabel.setBounds(50, 313, 605, 82);
		accountNumLabel.setForeground(Color.LIGHT_GRAY);
		transferConfirmPanel.add(accountNumLabel);
		
		transferAmountLabel = new JLabel("Your transfer amount:");
		transferAmountLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		transferAmountLabel.setBounds(50, 531, 925, 85);
		transferAmountLabel.setForeground(Color.LIGHT_GRAY);
		transferConfirmPanel.add(transferAmountLabel);
		
		// for loop setting up TextFields
		for (int i = 0; i < 2; i++) {
			tCTextField[i].setFont(new Font("Arial", Font.PLAIN, 40));
			tCTextField[i].setBounds(730, (313 + 218 * i) , 524, 85);
			tCTextField[i].setEditable(false);
			transferConfirmPanel.add(tCTextField[i]);
		}
		

		tCButton[0] = new JButton("Confirm");
		tCButton[1] = new JButton("Re-enter");
		tCButton[2] = new JButton("Cancel");
		// for loop setting up buttons 
		for (int i = 0; i < 3; i++) {
			tCButton[i].setFont(new Font("Arial", Font.PLAIN, 40));
			tCButton[i].setBounds( (166 + 408 * i) , 836, 292, 84);
			transferConfirmPanel.add(tCButton[i]);
		}
		
		super.getMainframe().setVisible(true);
		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JButton[] getTransferConfirmButton(){
		return tCButton;
	}

	public JTextField[] getTransferConfirmJTextField(){
		return tCTextField;
	}
	
}
