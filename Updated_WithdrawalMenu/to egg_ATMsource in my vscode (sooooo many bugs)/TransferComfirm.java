import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TransferComfirm extends Screen {

	private JPanel contentPane;
	private JTextField accountNumTextField;
	private JTextField transferAmountTtextField;


	/**
	 * Create the frame.
	 */
	public TransferComfirm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//need to change when copy to vscode
		JPanel panel = new JPanel();
        getContentPane().add(panel);
        //setPreferredSize(new Dimension(1440, 1024));
        

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(1440, 1024));
		panel.setLayout(null);
		
		JLabel accountNumLabel = new JLabel("The account number for Transfer:");
		accountNumLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		accountNumLabel.setBounds(50, 313, 605, 82);
		panel.add(accountNumLabel);
		
		JLabel transferAmountLabel = new JLabel("Your transfer amount:");
		transferAmountLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		transferAmountLabel.setBounds(50, 531, 925, 85);
		panel.add(transferAmountLabel);
		
		accountNumTextField = new JTextField();
		accountNumTextField.setEditable(false);
		accountNumTextField.setFont(new Font("Arial", Font.PLAIN, 40));
		accountNumTextField.setBounds(730, 313, 524, 85);
		panel.add(accountNumTextField);
		accountNumTextField.setColumns(10);
		
		transferAmountTtextField = new JTextField();
		transferAmountTtextField.setFont(new Font("Arial", Font.PLAIN, 40));
		transferAmountTtextField.setEditable(false);
		transferAmountTtextField.setColumns(10);
		transferAmountTtextField.setBounds(730, 531, 524, 85);
		panel.add(transferAmountTtextField);
		
		//y is 836
		JButton transferConfirmButton = new JButton("Confirm");
		transferConfirmButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		transferConfirmButton.setBounds(166, 836, 292, 84);
		panel.add(transferConfirmButton);
		
		JButton transferReEnterButton = new JButton("Re-enter");
		transferReEnterButton.setFont(new Font("Arial Black", Font.PLAIN, 40));
		transferReEnterButton.setBounds(574, 836, 292, 84);
		panel.add(transferReEnterButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Arial Black", Font.PLAIN, 40));
		btnCancel.setBounds(982, 836, 292, 84);
		panel.add(btnCancel);
		
		
		pack();
	}
	
	
	public class DisplayMessageJPanel extends JPanel{
	    public DisplayMessageJPanel(){
	        setSize(new Dimension(1440, 1024));
	        //Absolute layout
	        setLayout(null);


	        //background with color
	        setBackground(new Color(56, 60, 102));
	    }
	}
}
