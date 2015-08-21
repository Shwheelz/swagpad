package swagpad;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author Shane
 */
public class NoteDetailUI extends JFrame{
    
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 500;
    private final int FIELD_WIDTH = 10;
   
    JButton saveButton;
    JButton backButton;
    JTextField idField;
    JTextField dateField;
    JTextField nameField;
    JTextField descriptionField;
    JTextArea noteBody;
    JLabel idLabel;
    JLabel dateLabel;
    JLabel nameLabel;
    JLabel descriptionLabel;
    JPanel buttonPanel;
    JPanel textFieldPanel;
    JPanel textAreaPanel;
    JPanel mainPanel;
    
    NoteTableModel theNoteTableModel;
    NoteDetailCntl theNoteDetailCntl;
    
    NoteCntl theNoteCntl;
    Note theCurrentNote;
    
    private long theNoteIDNumber;
    private String theNoteID;

    public NoteDetailUI(NoteCntl parentNoteCntl, Note theSelectedNote){
        theNoteCntl = parentNoteCntl;
        theCurrentNote = theSelectedNote;
        this.initComponents();
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Note");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initComponents(){
        saveButton = new JButton("Save");
        saveButton.addActionListener(new saveButtonListener());        
        backButton = new JButton("Back");
        backButton.setEnabled(false);

        theNoteTableModel = new NoteTableModel();
        
        idField = new JTextField(FIELD_WIDTH);
        idField.setEditable(false);
        dateField = new JTextField(FIELD_WIDTH);
        nameField = new JTextField(FIELD_WIDTH);
        descriptionField = new JTextField(FIELD_WIDTH);
        noteBody = new JTextArea(25,60);
        
        if (theCurrentNote == null){
            System.out.println("theCurrentNote is null");
            theNoteID = Long.toString(theNoteCntl.getNoteID());
            idField.setText(theNoteID);
            dateField.setText(Integer.toString(20131110));
            nameField.setText("Untitled");
            descriptionField.setText("no description available");
            noteBody.setText("");
        }
        else{
            theNoteID = Long.toString(theCurrentNote.getNoteNumber());
            idField.setText(theNoteID);
            dateField.setText(Integer.toString(theCurrentNote.getNoteDate()));
            nameField.setText(theCurrentNote.getNoteName());
            descriptionField.setText(theCurrentNote.getDescription());
            noteBody.setText(theCurrentNote.getNoteBody());
        }
        
        idLabel = new JLabel("ID");
        dateLabel = new JLabel("Date");
        nameLabel = new JLabel("Name");
        descriptionLabel = new JLabel("Description");
        
        
        buttonPanel = new JPanel();
        textFieldPanel = new JPanel();
        textAreaPanel = new JPanel();
        mainPanel = new JPanel(new BorderLayout());
        
        buttonPanel.add(backButton);
        buttonPanel.add(saveButton);
        textFieldPanel.add(idLabel);
        textFieldPanel.add(idField);
        textFieldPanel.add(dateLabel);
        textFieldPanel.add(dateField);
        textFieldPanel.add(nameLabel);
        textFieldPanel.add(nameField);
        textFieldPanel.add(descriptionLabel);
        textFieldPanel.add(descriptionField);
        textAreaPanel.add(noteBody);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(textFieldPanel, BorderLayout.NORTH);
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);
        
        add(mainPanel);
        
    }

    public class saveButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            /*
             * Access the noteTableData array in NoteTableModel
             * Add the newData fields in order
             */
            int newNoteNumber = Integer.parseInt(NoteDetailUI.this.idField.getText());
            int newNoteDate = Integer.parseInt(NoteDetailUI.this.dateField.getText());
            String newNoteName = NoteDetailUI.this.nameField.getText();
            String newNoteDescription = NoteDetailUI.this.descriptionField.getText();
            String newNoteBody = NoteDetailUI.this.noteBody.getText();
            if(theCurrentNote == null){
                theNoteIDNumber = theNoteCntl.getNoteID();
                NoteDetailUI.this.theCurrentNote = new EssayNote(newNoteNumber,newNoteDate,newNoteName,newNoteDescription,newNoteBody);
                theNoteCntl.addNote(newNoteNumber, newNoteDate, newNoteName, newNoteDescription, newNoteBody);
                theNoteTableModel.addRow(newNoteNumber, newNoteDate, newNoteName, newNoteDescription, newNoteBody);
                
                NoteDetailUI.this.setVisible(false);
                NoteDetailUI.this.dispose();
                NoteDetailUI.this.theNoteCntl.getNoteTableUI();
            }
            else{ 
                theCurrentNote.setNoteDate(newNoteDate);
                theCurrentNote.setNoteName(newNoteName);
                theCurrentNote.setNoteDescription(newNoteDescription);
                theCurrentNote.setNoteNumber(newNoteNumber);
                theCurrentNote.setNoteBody(newNoteBody);
                
                NoteDetailUI.this.setVisible(false);
                NoteDetailUI.this.dispose();
                NoteDetailUI.this.theNoteCntl.getNoteTableUI();
            }
        }
    }
}
