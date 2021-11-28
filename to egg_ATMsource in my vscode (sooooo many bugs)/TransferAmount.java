import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;


public class TransferAmount extends Screen {
    private InsertPagePanel insertPagePanel;
    private Keypad keypad;
    private JPanel keypadPanel;

    public void buildGUI(){

        insertPagePanel = new InsertPagePanel("<html>Please enter the account to transfer:<br/><br/>(It will ignore after two decimal point)</html>");
        super.getMainframe().getContentPane().add(insertPagePanel);

        super.getScreenContentPane().add(insertPagePanel, BorderLayout.CENTER);

        keypad = new Keypad();
        keypadPanel = keypad.getKeypadJPanel();
        keypad.setKeypadColor(true);
        super.getScreenContentPane().add(keypadPanel, BorderLayout.EAST);

        super.getMainframe().pack();
        super.getMainframe().repaint();
        super.getMainframe().setVisible(true);
        
        
    }
}