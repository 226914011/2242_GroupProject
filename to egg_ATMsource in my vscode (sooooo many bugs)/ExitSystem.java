import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.Font;

public class ExitSystem extends Screen {
	int secondsPassed = 30;
	private DisplayMessageJPanel exitsystemPanel;
	private JLabel thankByeLabel;
	private JLabel exitsystemLablel;

	public void buildGUI()
	{
		exitsystemPanel = new DisplayMessageJPanel();

		super.getMainframe().getContentPane().add(exitsystemPanel);
		super.getScreenContentPane().add(exitsystemPanel, BorderLayout.CENTER);

		exitsystemPanel.setPreferredSize(new Dimension(1440, 1024));
		exitsystemPanel.setLayout(null);

		exitsystemLablel = new JLabel("Exiting the system...");
		exitsystemLablel.setFont(new Font("Arial", Font.PLAIN, 40));
		exitsystemLablel.setBounds(50, 427, 925, 58);
		exitsystemLablel.setForeground(Color.LIGHT_GRAY);
		exitsystemPanel.add(exitsystemLablel);

		thankByeLabel = new JLabel("Thank you! Goodbye!");
		thankByeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		thankByeLabel.setBounds(50, 535, 925, 58);
		thankByeLabel.setForeground(Color.LIGHT_GRAY);
		exitsystemPanel.add(thankByeLabel);

		super.getMainframe().pack();
		super.getMainframe().repaint();
		super.getMainframe().setVisible(true);
	}
}
