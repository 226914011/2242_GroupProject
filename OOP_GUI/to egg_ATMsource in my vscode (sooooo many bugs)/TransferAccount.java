import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;


public class TransferAccount extends Screen {
    private InsertPagePanel insertPagePanel;
    private Keypad keypad;
    private JPanel keypadPanel;

    public void buildGUI(){

        insertPagePanel = new InsertPagePanel("Please enter the account number for transfer:");
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

    public static void main(String[] args) {
        TransferAccount transferAccount = new TransferAccount();
        transferAccount.buildGUI();
    }
}