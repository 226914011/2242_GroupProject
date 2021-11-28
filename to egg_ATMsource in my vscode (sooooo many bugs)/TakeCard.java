import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class TakeCard extends Screen {

	private DisplayMessageJPanel takeCardPanel;
	private JLabel takeCardLabel;

	public void buildGUI() {
		takeCardPanel = new DisplayMessageJPanel();	
		super.getMainframe().getContentPane().add(takeCardPanel);
		super.getScreenContentPane().add(takeCardPanel, BorderLayout.CENTER);

		takeCardLabel = new JLabel("Please take your card now.");
		takeCardLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		takeCardLabel.setBounds(50, 471, 925, 58);
		takeCardPanel.add(takeCardLabel);

		super.getMainframe().setVisible(true);
		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JLabel getTakeCardLabel(){
		return takeCardLabel;
	}
}
