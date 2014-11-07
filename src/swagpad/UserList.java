package swagpad;
import java.util.*;
import java.io.*;
/**
 *
 * @author szb5283
 */
public class UserList implements Serializable{
    private ArrayList<User> listOfUsers = new ArrayList<User>();
    private String listOfUsersFileName = "ListOfUsers.ser";
    
    public UserList(){
        this.readUserListFile();
        if(listOfUsers.isEmpty() || listOfUsers == null){
            this.createTestUserList();
            this.writeUserListFile();
            this.readUserListFile();
        }
        //this.printUserList();
    }
    
    
    // Creates a list of usernames to match with passwords (EX: Test User1)
    public void createTestUserList(){
        for (int i = 0; i < 20; i++){
            listOfUsers.add(new User("Test User" + i));
        }
    }

    
    // Serializes the User List by writing it to a new file
    public void writeUserListFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(listOfUsersFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfUsers);
            out.close();
        } catch(IOException ex){
            System.out.println("writeUserListFile Exception caught");
            ex.printStackTrace();
        }
    }
    
    
    // Reads in the User List from the specified file
    public void readUserListFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(listOfUsersFileName);
            in = new ObjectInputStream(fis);
            listOfUsers = (ArrayList<User>)in.readObject();
            in.close();
            if(!listOfUsers.isEmpty()){
                System.out.println("There are some users in the user list");
            }
        } catch (FileNotFoundException ex){
            this.createTestUserList();
            this.writeUserListFile();
            this.readUserListFile();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void printUserList(){
        System.out.println("The UserList has these users: ");
        for(int i = 0; i < listOfUsers.size(); i++){
            User currentUser = (User)listOfUsers.get(i);
            System.out.println("[" + i + "] " +  currentUser.getUserName());
        }
    }
    
    public ArrayList<User> getUserList(){
        return listOfUsers;
    }
}
