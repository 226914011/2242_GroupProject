import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;

public class TransferAccount extends Screen {
    private InsertPagePanel insertPagePanel;
    private Keypad keypad;
    private Keypad.KeypadJPanel keypadPanel;

    public void buildGUI(){

        insertPagePanel = new InsertPagePanel("Please enter the account number for transfer:");
        super.getMainframe().getContentPane().add(insertPagePanel);

        super.getScreenContentPane().add(insertPagePanel, BorderLayout.CENTER);

        keypad = new Keypad();
        keypadPanel = keypad.new KeypadJPanel();
        keypadPanel.setPreferredSize(new Dimension(550,1024));
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