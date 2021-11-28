import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;



public class TransferAccount extends Screen {
    private InsertPagePanel insertPagePanel;
    private Keypad keypad;
    private JPanel keypadPanel;
    private Screen screen;
    private KeypadHandler keypadHandler;
    private JButton keys [],Buttons [],wButtons []; 
    private TransferAmount transferAmount;

    public void buildGUI(){
        transferAmount = new TransferAmount();
        insertPagePanel = new InsertPagePanel("Please enter the account number for transfer:");
        super.getMainframe().getContentPane().add(insertPagePanel);

        super.getScreenContentPane().add(insertPagePanel, BorderLayout.CENTER);

        keypad = new Keypad();
        keypadPanel = keypad.getKeypadJPanel();
        keypad.setKeypadColor(true);
        super.getScreenContentPane().add(keypadPanel, BorderLayout.EAST);
      keypadHandler = new KeypadHandler();

        super.getMainframe().pack();
        super.getMainframe().repaint();
        super.getMainframe().setVisible(true);
        keys = keypad.getKeys();
        for(ActionListener oldListener : keys[12].getActionListeners())
         keys[12].removeActionListener(oldListener);
      for (int i = 0; i <= 13; i++ ){
         if(keys[i].getActionListeners().length == 0){
            keys[i].addActionListener(keypadHandler);
         }
      }
    }
    private class KeypadHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           switch (e.getActionCommand()) {
              case "0":
              case "1":
              case "2":
              case "3":
              case "4": 
              case "5":
              case "6":
              case "7":
              case "8":
              case "9":
                 keypad.getKeypadDisplayTextField().setText(keypad.getKeypadDisplayTextField().getText() +e.getActionCommand());
                 break;
              case ".":
                 //need popup some remind message
                 keypad.warning();
                 break;
              case "Cancel":
                 screen.getMainframe().getContentPane().removeAll();
                 screen.getMainframe().revalidate();
                 screen.getMainframe().repaint();
                 keypad.getKeypadDisplayTextField().setText("");
                 //loginCardNumberPanel.invalidMessage(false);
                 keypad.closeWarning();
                 //authenticateUser(true);
                 break;
              case "Clear":
                 keypad.getKeypadDisplayTextField().setText("");
                 break;
              case "Enter":
                 //accountNumber = validation.checkInt(keypad.getKeypadDisplayTextField().getText());            
                 keypad.getKeypadDisplayTextField().setText("");
                 keypad.closeWarning();
                 screen.getMainframe().getContentPane().removeAll();
                 screen.getMainframe().revalidate();
                 screen.getMainframe().repaint();
                transferAmount.buildGUI();
                 //pinGUI();
                 break;
              default:
                 break;
           }
        }
     }
}