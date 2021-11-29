import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsertPagePanel extends JPanel{
    JLabel invalidMesssage;

    public InsertPagePanel(String displayText){
        setPreferredSize(new Dimension(890, 1024));
        setLayout(null);
        
        JLabel messageLabel = new JLabel(displayText);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        messageLabel.setBounds(50, 339, 840, 200);
        messageLabel.setForeground(Color.LIGHT_GRAY);
        add(messageLabel);

        invalidMesssage = new JLabel("");
        invalidMesssage.setFont(new Font("Arial", Font.PLAIN, 25));
        invalidMesssage.setBounds(50, 245, 840, 90);
        invalidMesssage.setVisible(true);
        invalidMesssage.setForeground(Color.RED);
        add(invalidMesssage);

        //background with color
        setBackground(new Color(56, 60, 102));
    }

    public void setInvalidMessage(String message){
        invalidMesssage.setText(message);
    }

}