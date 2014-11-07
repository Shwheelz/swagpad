package swagpad;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Shane
 */
public class LoginCntl { 
    
   private LoginUI theLoginUI;
    
   UserList currentUserList;
   PasswordList currentPasswordList;
    
   private ArrayList<User> theUserList;
   private ArrayList<Password> thePasswordList;
   
    public LoginCntl(){
        currentUserList = new UserList();
        currentPasswordList = new PasswordList();
        theLoginUI = new LoginUI(this);
        theUserList = currentUserList.getUserList();
        thePasswordList = currentPasswordList.getPasswordList();
    }
   
    public void getMainMenuCntl(){
        MainMenuCntl theMainMenuCntl = new MainMenuCntl();
    }
    
    /*
     * This method authenticates a username and password combination
     * Checks against an arraylist of acceptable usernames/passwords
     */
    public boolean authenticate(String username, String password){
        
        
        /*
         * Converts ArrayList<Object> to ArrayList<String>
         * Allos verification against String from text fields
         */
        ArrayList<String> userStrings = new ArrayList();
        for (User u : theUserList){
            userStrings.add(u != null ? u.toString() : null);
        }
        
        ArrayList<String> passwordStrings = new ArrayList();
        for (Password p : thePasswordList){
            passwordStrings.add(p != null ? p.toString() : null);
        }
        
        
        /*
         * Debugging code to view valid usernames and passwords
         */
        System.out.println("userStrings ArrayList");
        for (String s : userStrings){
            System.out.println(s);
        }
        
        System.out.println("passwordStrings ArrayList");
        for (String s : passwordStrings){
            System.out.println(s);
        }
        
        System.out.println("theUserList ArrayList");
        for (User u : theUserList){
            System.out.println(u.toString());
        }
        
        System.out.println("thePasswordList ArrayList");
        for (Password p : thePasswordList){
            System.out.println(p.toString());
        }
        
        System.out.println("UserName: " + username + " Password: " + password);
        /*
         * Ensures that the input username and password combos match a 
         * combo in the .ser files
         */
        for (int i = 0; i < userStrings.size(); i++) {
            if (userStrings.get(i).equals(username) && passwordStrings.get(i).equals(password)) { 
                return true;
            }
        }
        theLoginUI.passwordField.setText("");
        JOptionPane.showMessageDialog(null, "Invalid Login", "Alert", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
}
