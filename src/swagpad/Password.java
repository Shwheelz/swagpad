package swagpad;
import java.io.Serializable;
/**
 *
 * @author Shane
 */
public class Password implements Serializable{
    private String password;
    
    public Password (String thePassword){
        password = thePassword;
    }
    
    public void setPassword(String thePassword){
        password = thePassword;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String toString(){
        return password;
    }
}
