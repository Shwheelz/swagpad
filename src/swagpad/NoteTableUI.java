package swagpad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shane
 */
public class NoteTableUI extends JFrame{
    
    NoteTableModel theNoteTableModel;
    NoteCntl theNoteCntl;
    JPanel buttonPanel;
    JPanel tablePanel;
    JTable theNoteTable;
    JScrollPane theScrollPane;
    JButton backButton;
    JButton deleteButton;
    JButton editButton;
    JButton newButton;
    
    private int theNoteIDNumber = 9;
    
    public NoteTableUI(NoteCntl theParentNoteCntl){
        theNoteCntl = theParentNoteCntl;
        this.initComponents();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("NoteTableUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initComponents(){
        buttonPanel = new JPanel();
        tablePanel = new JPanel();
        backButton = new JButton("Back");
        backButton.setEnabled(false);
        newButton = new JButton("New");
        newButton.addActionListener(new newButtonListener());
        
        editButton = new JButton("Edit");
        editButton.addActionListener(new editButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new deleteButtonListener());
        theNoteTableModel = theNoteCntl.getNoteTableModel();
        theNoteTable = new JTable(theNoteCntl.getNoteTableModel());
        theScrollPane = new JScrollPane(theNoteTable);
        theNoteTable.setFillsViewportHeight(true);
        tablePanel.add(theScrollPane);
        
        buttonPanel.add(backButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(newButton);
        
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }
    
    //deletes a note and removes the row from the table
    public class deleteButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int selectedRow = theNoteTable.getSelectedRow();
            if (selectedRow == -1){
                System.out.println("No row selected");
            }
            else{
                theNoteTableModel.removeRow(selectedRow);
            }
            theNoteTableModel.writeNotes();
            revalidate();
            repaint();
        }
    }
    
    //adds a new note with the next valid unique ID
    public class newButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            NoteTableUI.this.setVisible(false);
            NoteTableUI.this.theNoteCntl.getNoteDetailUI(null);
            revalidate();
            repaint();
        }
    }
    
    //allows the user to edit the note properties, ID field should be uneditable
    public class editButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int selectedRowID = theNoteTable.getSelectedRow();
            if (selectedRowID == -1){
                System.out.println("Please select a row");
            }
            else{
                NoteTableUI.this.setVisible(false);
                Note selectedNote = theNoteTableModel.getNote(selectedRowID);
                NoteTableUI.this.theNoteCntl.getNoteDetailUI(selectedNote);
            }
            theNoteTableModel.writeNotes();
        }
    }
}
