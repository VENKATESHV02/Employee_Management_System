package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    private JTextField tusername;
    private JPasswordField tpassword;
    private JButton login, back;

    public Login() {
        setTitle("Login Page");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Background Panel
        JPanel backgroundPanel = new JPanel(null);
        backgroundPanel.setBackground(Color.WHITE);
        add(backgroundPanel, BorderLayout.CENTER);

        // Username Label & Field
        JLabel username = new JLabel("Username:");
        username.setBounds(50, 50, 100, 30);
        username.setFont(new Font("Arial", Font.BOLD, 14));
        backgroundPanel.add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 50, 200, 30);
        backgroundPanel.add(tusername);

        // Password Label & Field
        JLabel password = new JLabel("Password:");
        password.setBounds(50, 100, 100, 30);
        password.setFont(new Font("Arial", Font.BOLD, 14));
        backgroundPanel.add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 100, 200, 30);
        backgroundPanel.add(tpassword);

        // Login Button
        login = new JButton("LOGIN");
        login.setBounds(150, 160, 100, 35);
        login.setBackground(new Color(50, 150, 250));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 14));
        login.setFocusPainted(false);
        login.addActionListener(this);
        backgroundPanel.add(login);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(270, 160, 100, 35);
        back.setBackground(new Color(200, 50, 50));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setFocusPainted(false);
        back.addActionListener(this);
        backgroundPanel.add(back);

        // Adding Images
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));
        Image i22 = i11.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH);
        JLabel img1 = new JLabel(new ImageIcon(i22));
        img1.setBounds(400, 50, 300, 200);
        backgroundPanel.add(img1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 1000, Image.SCALE_SMOOTH);
        JLabel img2 = new JLabel(new ImageIcon(i2));
        img2.setBounds(0, 0, 800, 400);
        backgroundPanel.add(img2);

        setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login)
        {
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                Conn conn = new Conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next())
                {
                    setVisible(false);
                    new Main_class();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }
            catch (Exception E)
            {
                E.printStackTrace();
            }

        }
        else if (e.getSource() == back)
        {
            System.exit(90);
        }
    }

public static void main(String[] args)
{
    new Login();
}
}



