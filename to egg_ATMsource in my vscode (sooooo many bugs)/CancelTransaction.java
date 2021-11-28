import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class CancelTransaction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelTransaction frame = new CancelTransaction();
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
	public CancelTransaction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
        getContentPane().add(panel);
        

		contentPane.add(panel, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(1440, 1024));
		panel.setLayout(null);
		
		JLabel canTransLabel = new JLabel("Cancelling transaction...");
		canTransLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		canTransLabel.setBounds(50, 471, 925, 58);
		panel.add(canTransLabel);
		
		JLabel ReturnMenuLabel = new JLabel("Returning to the main menu...");
		ReturnMenuLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		ReturnMenuLabel.setBounds(50, 615, 925, 58);
		panel.add(ReturnMenuLabel);

		pack();
	}
}
