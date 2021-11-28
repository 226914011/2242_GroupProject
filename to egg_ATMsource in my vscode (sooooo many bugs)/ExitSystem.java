import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class ExitSystem extends Screen {
	int secondsPassed = 30;
	private DisplayMessageJPanel exitsystemPanel;
	private JLabel thankByeLabel;
	private JLabel exitsystemLable;

	/**
	 * Create the frame.
	 */
	public void buildGUI()
	{
		exitsystemPanel = new DisplayMessageJPanel();

			super.getMainframe().getContentPane().add(exitsystemPanel);
		super.getScreenContentPane().add(exitsystemPanel, BorderLayout.CENTER);

		exitsystemPanel.add(exitsystemPanel, BorderLayout.CENTER);
		exitsystemPanel.setPreferredSize(new Dimension(1440, 1024));
		exitsystemPanel.setLayout(null);

		exitsystemLable = new JLabel("Exiting the system...");
		exitsystemLable.setFont(new Font("Arial", Font.PLAIN, 40));
		exitsystemLable.setBounds(50, 427, 925, 58);
		exitsystemPanel.add(exitsystemLable);

		thankByeLabel = new JLabel("Thank you! Goodbye!");
		thankByeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		thankByeLabel.setBounds(50, 535, 925, 58);
		exitsystemPanel.add(thankByeLabel);

		super.getMainframe().pack();
		super.getMainframe().repaint();
	}
}
