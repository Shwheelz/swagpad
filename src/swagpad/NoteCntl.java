package swagpad;

/**
 *
 * @author Shane
 */
public class NoteCntl {
    
    private NoteTableModel theNoteTableModel = new NoteTableModel();;
    private NoteTableUI theNoteTableUI;
    private NoteDetailUI theNoteDetailUI;
    
    public NoteCntl(){
        theNoteTableUI = new NoteTableUI(this);
    }
    
    public NoteTableModel getNoteTableModel(){
        theNoteTableModel.fireTableDataChanged();
        return theNoteTableModel;
    }
    
    
    //Bring up the Note Detail interface to edit the note
    public void getNoteDetailUI(Note theNote){
        theNoteDetailUI = new NoteDetailUI(this,theNote);
        theNoteDetailUI.setVisible(true);
    }
    
    
    /*
     * Get the ID at the last row
     * return the next available note ID
     */
    public long getNoteID(){
        int row = theNoteTableModel.getRowCount()-1;
        int col = 0;
        String noteIDString = theNoteTableModel.getValueAt(row, col).toString();
        return Long.parseLong(noteIDString)+1;
    }
    
    // Returns the Date from the Date text field
    public int getNoteDate(){
        int dateToReturn = Integer.parseInt(theNoteDetailUI.dateField.getText());
        return dateToReturn;
    }
    
    // Returns the name of the note from the text field
    public String getNoteName(){
        return theNoteDetailUI.dateField.getText();
    }
    
    public String getNoteDescription(){
        return theNoteDetailUI.descriptionField.getText();
    }
    
    public int getRowCount() {
        return theNoteTableModel.getRowCount();
    }
    
    public Object getValueAt(int row, int col) {
        return theNoteTableModel.getValueAt(row, col);
    }
    
    // Refreshes table data and brings up the table menu
    public NoteTableUI getNoteTableUI(){
        theNoteTableModel.fireTableDataChanged();
        theNoteTableUI.revalidate();
        theNoteTableUI.repaint();
        theNoteTableUI.setVisible(true);
        return theNoteTableUI;
    }
    
    
    // Delete a note from the table model
    public void deleteNote(int noteToDelete){
        theNoteTableModel.removeRow(noteToDelete);
    }
    
    
    // Adds a new note to the table model
    public void addNote(long id, int date, String name, String description, String body){
        theNoteTableModel.addRow(id, date, name, description, body);
    }
}
