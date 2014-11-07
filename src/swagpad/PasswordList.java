package swagpad;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author Shane
 */
public class PasswordList implements Serializable{
    private ArrayList<Password> listOfPasswords = new ArrayList<Password>();
    private String listOfPasswordsFileName = "ListOfPasswords.ser";
    
    public PasswordList(){
        this.readPasswordListFile();
        if(listOfPasswords.isEmpty() || listOfPasswords == null){
            this.createTestPasswordList();
            this.writePasswordListFile();
            this.readPasswordListFile();
        }
        //this.printPasswordList();
    }
    
    public void readPasswordListFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(listOfPasswordsFileName);
            in = new ObjectInputStream(fis);
            listOfPasswords = (ArrayList<Password>)in.readObject();
            in.close();
            if(!listOfPasswords.isEmpty()){
                System.out.println("There are some passwords in the password list");
            }
        } catch (FileNotFoundException ex){
            this.createTestPasswordList();
            this.writePasswordListFile();
            this.readPasswordListFile();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void createTestPasswordList(){
        for (int i = 0; i < 20; i++){
            listOfPasswords.add(new Password("Test Password" + i));
        }
    }
    
    public void writePasswordListFile(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(listOfPasswordsFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listOfPasswords);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public void printPasswordList(){
        System.out.println("The PasswordList has these users: ");
        for(int i = 0; i < listOfPasswords.size(); i++){
            Password currentPassword = (Password)listOfPasswords.get(i);
            System.out.println("[" + i + "] " + currentPassword.getPassword());
        }
    }
    
    public ArrayList<Password> getPasswordList(){
        return listOfPasswords;
    }
}
