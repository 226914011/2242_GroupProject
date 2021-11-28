import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class WithdrawalConfirm extends Screen {

	private DisplayMessageJPanel withConfirmPanel;
	private JTextField withAmountTextField;
	private JLabel amountWLabel;
	private JLabel confirmationLabel;
	private JButton[] confirmGUIButtons;
	private JButton reEnterButton;
	private JButton cancelButton;


	public WithdrawalConfirm(){
		confirmGUIButtons = new JButton[3];
	}

	public void buildGUI() {
		withConfirmPanel = new DisplayMessageJPanel();	// initialize withConfirmPanel

		// inherits from superclass Screen to get mainframe and panel, and adding the current panel
        super.getMainframe().getContentPane().add(withConfirmPanel);	
		super.getScreenContentPane().add(withConfirmPanel, BorderLayout.CENTER);
		
		amountWLabel = new JLabel("The amount for withdrawal");
		amountWLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		amountWLabel.setBounds(50, 313, 932, 82);
		amountWLabel.setForeground(Color.LIGHT_GRAY);
		withConfirmPanel.add(amountWLabel);

		confirmationLabel = new JLabel("Withdrawal Confirmation");
		confirmationLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		confirmationLabel.setBounds(506, 53, 500, 82);
		confirmationLabel.setForeground(Color.LIGHT_GRAY);
		withConfirmPanel.add(confirmationLabel);

		withAmountTextField = new JTextField();
		withAmountTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		withAmountTextField.setEditable(false);
		withAmountTextField.setBounds(730, 313, 524, 85);
		withAmountTextField.setColumns(10);
		withAmountTextField.setText("");
		withConfirmPanel.add(withAmountTextField);
		
		confirmGUIButtons[0] = new JButton("Confirm");
		confirmGUIButtons[1] = new JButton("Re-enter");
		confirmGUIButtons[2] = new JButton("Cancel");


		//format
		for(int i = 0; i <= 2; i++){
			confirmGUIButtons[i].setFont(new Font("Arial Black", Font.PLAIN, 40));
			confirmGUIButtons[i].setBounds(166 + 408*i, 836, 292, 84);
			withConfirmPanel.add(confirmGUIButtons[i]);
		}

		super.getMainframe().setVisible(true);		// set the panel to visible
		super.getMainframe().pack();				// set the frame to fit the preferred size
		super.getMainframe().repaint();				// refresh the frame

	}

	public void setDisplayWithdrawalAmount(int amount){
		//String.format in this line just accpect double input
		withAmountTextField.setText(String.format( "$%,.2f", Double.valueOf(amount)));
	}

	public JButton[] getConfirmGUIButtons(){
		return confirmGUIButtons;
	}

}
