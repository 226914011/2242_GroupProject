// DisplayMessageJPanel.java
// Represents the panel for displaying message for different GUI

import javax.swing.*;
import java.awt.*;

public class DisplayMessageJPanel extends JPanel {
    public DisplayMessageJPanel() {
        setPreferredSize(new Dimension(1440, 1024));
        // Absolute layout
        setLayout(null);

        // background with color
        setBackground(new Color(56, 60, 102));
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        DisplayMessageJPanel panel = new DisplayMessageJPanel();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(panel);
        mainFrame.pack();
    }

}
