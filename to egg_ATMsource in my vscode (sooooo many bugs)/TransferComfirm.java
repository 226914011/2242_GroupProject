import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TransferComfirm extends Screen {

	private DisplayMessageJPanel transferConfirmPanel;
	private JTextField accountNumTextField;
	private JTextField transferAmountTtextField;
	private JLabel accountNumLabel;
	private JLabel transferAmountLabel;
	private JButton transferConfirmButton;
	private JButton transferReEnterButton;
	private JButton btnCancel;

<<<<<<< Updated upstream:to egg_ATMsource in my vscode (sooooo many bugs)/transferComfirm.java

	public TransferComfirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
=======
	public void buildGUI(){
	transferConfirmPanel = new DisplayMessageJPanel();
>>>>>>> Stashed changes:to egg_ATMsource in my vscode (sooooo many bugs)/TransferComfirm.java
		
	super.getMainframe().getContentPane().add(transferConfirmPanel);
	super.getScreenContentPane().add(transferConfirmPanel, BorderLayout.CENTER);
		
		accountNumLabel = new JLabel("The account number for Transfer:");
		accountNumLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		accountNumLabel.setBounds(50, 313, 605, 82);
		transferConfirmPanel.add(accountNumLabel);
		
		transferAmountLabel = new JLabel("Your transfer amount:");
		transferAmountLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		transferAmountLabel.setBounds(50, 531, 925, 85);
		transferConfirmPanel.add(transferAmountLabel);
		
		accountNumTextField = new JTextField();
		accountNumTextField.setEditable(false);
		accountNumTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		accountNumTextField.setBounds(730, 313, 524, 85);
		accountNumTextField.setColumns(10);
		transferConfirmPanel.add(accountNumTextField);
		
		
		transferAmountTtextField = new JTextField();
		transferAmountTtextField.setFont(new Font("Arial", Font.PLAIN, 40));
		transferAmountTtextField.setEditable(false);
		transferAmountTtextField.setColumns(10);
		transferAmountTtextField.setBounds(730, 531, 524, 85);
		transferConfirmPanel.add(transferAmountTtextField);
		
		transferConfirmButton = new JButton("Confirm");
		transferConfirmButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		transferConfirmButton.setBounds(166, 836, 292, 84);
		transferConfirmPanel.add(transferConfirmButton);
		
		transferReEnterButton = new JButton("Re-enter");
		transferReEnterButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		transferReEnterButton.setBounds(574, 836, 292, 84);
		transferConfirmPanel.add(transferReEnterButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Arial Black", Font.PLAIN, 40));
		btnCancel.setBounds(982, 836, 292, 84);
		transferConfirmPanel.add(btnCancel);
		
		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JButton getTransferConfirmButton(){
		return transferConfirmButton;
	}

	public JButton getTransferReEnterButton(){
		return transferReEnterButton;
	}

	public JButton getBtnCancelButton(){
		return btnCancel;
	}
	
}
