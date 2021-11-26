import javax.swing.*;
import java.awt.*;


public class DisplayMessageJPanel extends JPanel{
    public DisplayMessageJPanel(){
        setSize(new Dimension(1440, 1024));
        //Absolute layout
        setLayout(null);


        //background with color
        setBackground(new Color(56, 60, 102));
    }

    /***
    //for image background
    @Override
    public void paintComponent(Graphics g) {
          super.paintComponent(g);
          ImageIcon bgimage = new ImageIcon("withdraw_1-4.png");
          g.drawImage(bgimage.getImage(), 0, 0, this.getWidth(), this.getHeight(),  null);
    }
    ***/

    //this is for testing, pls don't copy it in screen
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        DisplayMessageJPanel hihi = new DisplayMessageJPanel();

        mainFrame.setPreferredSize(new Dimension(1440, 1024));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(hihi);
        //this is very important XD
        mainFrame.pack();
    }
}
