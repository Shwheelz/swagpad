package swagpad;

/**
 *
 * @author Shane
 */
public class EssayNote extends Note{
    
    
    public void setNoteNumber(long noteNumber) {
        this.noteNumber = noteNumber;
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
    
    public EssayNote(int newNoteDate){
        super(newNoteDate);
        
    }
    
    public EssayNote(long newNoteNumber, int newNoteDate, String newNoteName, String newNoteDescription, String newNoteBody){
        this.noteNumber = newNoteNumber;
        this.noteDate = newNoteDate;
        this.noteName = newNoteName;
        this.noteDescription = newNoteDescription;
        this.noteBody = newNoteBody;
    }
    
    
    public int getNoteDate(){
        return super.getNoteDate();
    }
    
    public void displayNote(){
        System.out.println("This is an EssayNote");
    }
    
    
    public void print(){
        // method to get the note file and send it to the printer
    }

    public void pageSetup(){
        // pagesetup method for formatting
    }
    
}
