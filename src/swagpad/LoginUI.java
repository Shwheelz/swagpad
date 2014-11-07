package swagpad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * EXAMPLE LOGIN: Test User1, Test Password1
 * @author Shane
 */
public class LoginUI extends JFrame{
    LoginCntl theLoginCntl;
    JButton cancelButton;
    JButton submitButton;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel usernameLabel;
    JLabel passwordLabel;
    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel fieldPanel;
    
    public LoginUI(LoginCntl theCreatingCntl){
        this.theLoginCntl = theCreatingCntl;
        this.initComponents();
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initComponents(){
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new CancelListener());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitListener());
        
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 40));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 40));
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        
        mainPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout());
        fieldPanel = new JPanel(new GridLayout(5,2));
        
        fieldPanel.add(usernameLabel);
        fieldPanel.add(usernameField);
        fieldPanel.add(passwordLabel);
        fieldPanel.add(passwordField);
        buttonPanel.add(cancelButton);
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        this.add(mainPanel);
    }
    
    //Submits login information for authentication
    public class SubmitListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            System.out.println("Submit button pressed");
            String usernameToPass = usernameField.getText();
            String passwordToPass = passwordField.getText();
            System.out.println("username and password: "+usernameToPass+" "+passwordToPass);
            if(theLoginCntl.authenticate(usernameToPass, passwordToPass)){      //Getting NullPointerException here
                LoginUI.this.setVisible(false);
                theLoginCntl.getMainMenuCntl();
            }else{
                System.out.println("Invalid Password!");
            }
            
        }
    }
    
    //Cancels the login and exits the program
    public class CancelListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            System.out.println("Cancel button pressed");
            System.exit(1);
        }
    }
    
}
