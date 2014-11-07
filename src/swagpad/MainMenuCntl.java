package swagpad;

/**
 *
 * @author Shane
 */
public class MainMenuCntl {
    
    public MainMenuCntl(){
        MainMenuUI theMainMenuUI = new MainMenuUI(this);  
    }
    
    public void getNoteController(){
        
        NoteCntl theNoteCntl = new NoteCntl();
    }
    
}
