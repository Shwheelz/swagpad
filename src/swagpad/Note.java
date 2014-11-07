package swagpad;
import java.io.Serializable;
/**
 *
 * @author Shane
 */
public abstract class Note implements Serializable{
   
    protected long noteNumber = 0;
    protected int noteDate = 0;
    protected String noteName = "";
    protected String noteDescription = "";
    protected String noteBody;
    
    NoteCntl theNoteCntl;
    
    public Note(){
        initNote();
    }
    
    public Note(int newNoteDate){
        noteDate = newNoteDate;
        initNote();
    }

    public abstract void displayNote();
    
    // Accessors
    public long getNoteNumber(){
        return noteNumber;
    }
    public int getNoteDate(){
        return noteDate;
    }
    public String getNoteName(){
        return noteName;
    }
    public String getDescription(){
        return noteDescription;
    }
    public String getNoteBody(){
        return noteBody;
    }

    
    // Mutators
    public void setNoteNumber(long noteNumber) {
        this.noteNumber = noteNumber;
    }
    public void setNoteDate(int newNoteDate){
        noteDate = newNoteDate;
    }
    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }
    public void setNoteBody(String noteBody){
        this.noteBody = noteBody;
    }
    
    private void initNote(){
        
    }
}
