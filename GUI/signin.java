import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

public class signin extends JFrame {

    private JFrame frame;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private ImageIcon bgicon;
    private JLabel bglabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signin frame = new signin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public signin() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1000, 1000);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBounds(0, 0, 1000, 1000);
        contentPane.setBackground(new Color(56, 60, 102));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(289, 468, 100, 27);
        contentPane.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);

        textField = new JTextField();
        textField.setBounds(289, 507, 450, 45);
        textField.setBackground(new Color(0, 0, 0, 0));
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(289, 567, 100, 27);
        contentPane.add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setBounds(289, 606, 450, 45);
        passwordField.setBackground(new Color(0, 0, 0, 0));
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("Sign in");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setBounds(447, 692, 117, 36);
        contentPane.add(btnNewButton);

        JLabel Label3 = new JLabel();
        Label3.setBackground(new Color(255, 255, 255));

    }

}
