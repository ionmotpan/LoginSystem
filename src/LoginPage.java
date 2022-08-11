import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID: ");
    JLabel userPasswordLabel = new JLabel("password: ");
    JLabel messageLabel = new JLabel("");

    HashMap<String, String> loginInfo = new HashMap<String, String>();

    public LoginPage(HashMap<String, String> loginInfoOriginal){

        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(40, 100, 150, 35);
        userPasswordLabel.setFont(new Font(null, Font.BOLD, 20));
        userPasswordLabel.setBounds(40, 150, 150, 35);
        userIDLabel.setFont(new Font(null, Font.BOLD, 20));
        messageLabel.setBounds(75, 10, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(160, 105, 200, 30);
        userPasswordField.setBounds(160, 155, 200, 30);

        loginButton.setBounds(55, 250, 125, 35);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        resetButton.setBounds(225, 250, 125, 35);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

        frame.add(userPasswordLabel);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(userPasswordField);
        frame.add(userIDField);
        frame.add(messageLabel);
        frame.add(userIDLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if(e.getSource() == loginButton) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());
            if(loginInfo.containsKey(userID)){
                if(loginInfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful :)");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                }else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password :( ");
                }
            }else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("User name not found:( ");
            }
        }
    }
}
