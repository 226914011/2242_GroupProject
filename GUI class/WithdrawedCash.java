import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class WithdrawedCash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawedCash frame = new WithdrawedCash();
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
	public WithdrawedCash() {
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
		
		JLabel takeCashLabel = new JLabel("Please take your cash now.");
		takeCashLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		takeCashLabel.setBounds(50, 471, 925, 58);
		panel.add(takeCashLabel);

		pack();
	}

}
