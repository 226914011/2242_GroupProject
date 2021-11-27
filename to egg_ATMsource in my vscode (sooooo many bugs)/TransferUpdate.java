import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TransferUpdate extends Screen {

	private JPanel contentPane;
	private JTextField availableBtxtfield;
	private JTextField totalbaltxtfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferUpdate frame = new TransferUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TransferUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//need to change when copy to vscode
		JPanel panel = new JPanel();
        getContentPane().add(panel);
        

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(1440, 1024));
		panel.setLayout(null);
		
		JLabel transfersuccesslabel = new JLabel("The transfer is successful. Updated balance information:");
		transfersuccesslabel.setFont(new Font("Arial", Font.PLAIN, 40));
		transfersuccesslabel.setBounds(50, 104, 1204, 85);
		panel.add(transfersuccesslabel);
		
		JLabel availableBalanceLabel = new JLabel("available balance:");
		availableBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		availableBalanceLabel.setBounds(50, 308, 532, 85);
		panel.add(availableBalanceLabel);
		
		JLabel totalBalanceLabel = new JLabel("total balance:");
		totalBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		totalBalanceLabel.setBounds(50, 517, 532, 85);
		panel.add(totalBalanceLabel);
		
		availableBtxtfield = new JTextField();
		availableBtxtfield.setBounds(730, 313, 524, 85);
		panel.add(availableBtxtfield);
		availableBtxtfield.setColumns(10);
		availableBtxtfield.setEditable(false);
		
		totalbaltxtfield = new JTextField();
		totalbaltxtfield.setColumns(10);
		totalbaltxtfield.setBounds(730, 523, 524, 85);
		panel.add(totalbaltxtfield);
		totalbaltxtfield.setEditable(false);
		
		JButton EnterButton = new JButton("Enter");
		EnterButton.setFont(new Font("Arial Black", Font.PLAIN, 35));
		EnterButton.setBounds(574, 835, 292, 85);
		panel.add(EnterButton);
		
		pack();
	}
}
