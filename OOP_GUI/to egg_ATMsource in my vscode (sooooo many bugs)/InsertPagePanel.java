import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsertPagePanel extends JPanel{
    public InsertPagePanel(String displayText){
        setPreferredSize(new Dimension(890, 1024));
        setLayout(null);
        
        JLabel messageLabel = new JLabel(displayText);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        messageLabel.setBounds(50, 339, 840, 92);
        messageLabel.setForeground(Color.LIGHT_GRAY);
        add(messageLabel);

        //background with color
        setBackground(new Color(56, 60, 102));
    }
}