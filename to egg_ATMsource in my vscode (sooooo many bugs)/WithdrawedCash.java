import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

public class WithdrawedCash extends Screen {
	private DisplayMessageJPanel withCashPanel;
	private JLabel takeCashLabel;

	public void buildGUI(){
		withCashPanel = new DisplayMessageJPanel();

        super.getMainframe().getContentPane().add(withCashPanel);
		super.getScreenContentPane().add(withCashPanel, BorderLayout.CENTER);
		
		takeCashLabel = new JLabel("Please take your cash now.");
		takeCashLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		takeCashLabel.setForeground(Color.DARK_GRAY);
		takeCashLabel.setBounds(50, 471, 925, 58);
		withCashPanel.add(takeCashLabel);

		super.getMainframe().pack();
		super.getMainframe().repaint();
	}

	public JLabel getTakeCashLabel(){
		return takeCashLabel;
	}

}
