package swagpad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.table.*;
import java.util.*;
/**
 *
 * @author Shane
 */
public class NoteTableModel extends AbstractTableModel{
    private String[] columnNames = {"ID", "Date", "Name", "Description"};
    private ArrayList<Note> noteTableData = new ArrayList();
    private String listOfNotesFileName = "ListOfNotes.ser";
    
    NoteCntl theNoteCntl;

    public NoteTableModel(){
        this.readNotes();
        if(noteTableData.isEmpty() || noteTableData == null){
            this.buildTestNoteTable();
            this.writeNotes();
            this.readNotes();
        }
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return noteTableData.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    

    public Object getValueAt(int row, int col) {
        Object objectToReturn = new Object();
        switch(col){
            case 0: objectToReturn = noteTableData.get(row).getNoteNumber();break;
            case 1: objectToReturn = noteTableData.get(row).getNoteDate();break;
            case 2: objectToReturn = noteTableData.get(row).getNoteName();break;
            case 3: objectToReturn = noteTableData.get(row).getDescription();break;
            case 4: objectToReturn = noteTableData.get(row).getNoteBody();break;
        }
        return objectToReturn;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    
    /*
     * Don't need to implement this method unless the table menu is editable
     */
    public boolean isCellEditable(int row, int col) {
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
    
    //Builds first 10 rows (0-9) of test note data
    public void buildTestNoteTable(){
        for(int i = 1; i <= 10; i++){
            EssayNote newNote = new EssayNote(i, 20131105, "New Test Note"+i, "Blah blah blah", "");
            noteTableData.add(newNote);
        }
    }
    
    //Removes a row from the table
    public void removeRow(int row){
        noteTableData.remove(row);
        fireTableDataChanged();
    }
    
    //adds a row to the table
    public void addRow(long id, int date, String name, String description, String body){
        noteTableData.add(new EssayNote(id, date, name, description, body));
        writeNotes();
        fireTableDataChanged();
    }
    
    //creates a new file to serialize notes
    public void writeNotes(){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try{
            fos = new FileOutputStream(listOfNotesFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(noteTableData);
            out.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    //reads the notes file
    public void readNotes(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try{
            fis = new FileInputStream(listOfNotesFileName);
            in = new ObjectInputStream(fis);
            noteTableData = (ArrayList<Note>)in.readObject();
            in.close();
            if(!noteTableData.isEmpty()){
                System.out.println("There are some notes in noteTableData");
            }
        } catch (FileNotFoundException ex){
            this.buildTestNoteTable();
            this.writeNotes();
            this.readNotes();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    //returns the note object from the table
    public Note getNote(int row){
        Note theNote = noteTableData.get(row);
        return theNote;
    }

}

    
