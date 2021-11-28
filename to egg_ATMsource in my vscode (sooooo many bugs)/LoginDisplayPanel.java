import java.awt.*;

import javax.swing.*;

public class LoginDisplayPanel extends JPanel{
    JLabel invalidInputLabel;

    public LoginDisplayPanel(String displayText, String imagePath){
        setPreferredSize(new Dimension(890, 1024));
        setLayout(null);
        
        //transparent jpanel
        setOpaque(false);
        
        
        JLabel userImageLabel = new JLabel("");
        userImageLabel.setBounds(186, 423, 252, 249);
        userImageLabel.setIcon(new ImageIcon(imagePath));
        add(userImageLabel);
        
        JLabel cardNumLabel = new JLabel(displayText);
        cardNumLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        cardNumLabel.setForeground(Color.white);
        cardNumLabel.setBounds(186, 313, 650, 92);
        add(cardNumLabel);

        invalidInputLabel = new JLabel("* Invalid card number or pin");
        invalidInputLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        invalidInputLabel.setForeground(Color.RED);
        invalidInputLabel.setBounds(186, 272, 690, 56);
        invalidInputLabel.setVisible(false);
        add(invalidInputLabel);
    }

    public void invalidMessage(){
        invalidInputLabel.setVisible(true);
    } 

    public void cancelInvalidMessage(){
        invalidInputLabel.setVisible(false);
    } 
}
