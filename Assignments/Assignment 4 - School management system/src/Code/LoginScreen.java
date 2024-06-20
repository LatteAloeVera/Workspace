package Code;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginScreen extends JFrame { 
    private static LoginScreen instance = null;
    
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton checkButton;
    private JPanel fieldPanel;

    private LoginScreen(){
        super("Login");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        usernameLabel = new JLabel("Username:", JLabel.RIGHT);
        passwordLabel = new JLabel("Password:", JLabel.RIGHT);
        usernameField = new JTextField("...");
        passwordField = new JPasswordField("***");
        checkButton = new JButton("Login");
        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(2,2,5,10));
        fieldPanel.add(usernameLabel);
        fieldPanel.add(usernameField);
        fieldPanel.add(passwordLabel);
        fieldPanel.add(passwordField);

        setLayout(new BorderLayout());
        add(fieldPanel, BorderLayout.NORTH);
        add(checkButton, BorderLayout.SOUTH);

        usernameField.grabFocus();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }    

    public static LoginScreen getInstance(){
        if(instance == null){
            instance = new LoginScreen();
        }
        
        return instance;
    }


}
