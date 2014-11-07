package swagpad;
import java.io.Serializable;
/**
 * Serializable interface has no methods
 * @author szb5283
 */
public class User implements Serializable {
    private String userName;
    
    //Note that for simplicity's sake this class does not include passwords
    public User(String theUserName){
        userName = theUserName;
    }
    
    public void setUserName(String theUserName){
        userName = theUserName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String toString(){
        return userName;
    }
}
