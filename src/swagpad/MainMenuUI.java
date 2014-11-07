package swagpad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shane
 */
public class MainMenuUI extends JFrame{
    MainMenuCntl theMainMenuCntl;
    NoteCntl theNoteCntl;
    JPanel mainPanel;
    JButton notesButton;
    JButton createNoteButton;
    JButton scheduleButton;
    JButton todoButtton;
    JButton profileButton;
    JButton settingsButton;
    JButton utilitiesButton;
    JButton logoutButton; 
    JButton aboutButton;
    JButton helpButton;
    
    
    public MainMenuUI(MainMenuCntl theParentMainMenuCntl){
        theMainMenuCntl = theParentMainMenuCntl;
        this.initComponents();
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void initComponents(){
        mainPanel = new JPanel(new GridLayout(5,2));
        JPanel[][] buttonGrid = new JPanel[5][2];
        for(int i = 0; i < buttonGrid.length; i++){
            for(int j = 0; j < buttonGrid[i].length; j++){
                buttonGrid[i][j] = new JPanel();
                mainPanel.add(buttonGrid[i][j]);
            }
        }
        notesButton = new JButton("Notes List");
        notesButton.addActionListener(new NotesButtonListener());
        buttonGrid[0][0].add(notesButton);
        createNoteButton = new JButton("Create Note");
        createNoteButton.addActionListener(new CreateButtonListener());
        buttonGrid[0][1].add(createNoteButton);
        this.getContentPane().add(mainPanel);
        
    }
    
    //Brings up the notes table menu
    public class NotesButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            MainMenuUI.this.setVisible(false);
            MainMenuUI.this.theMainMenuCntl.getNoteController();
        }
    }
    
    //Brings up the NoteDetail window
    public class CreateButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            MainMenuUI.this.setVisible(false);
            theNoteCntl = new NoteCntl();
            MainMenuUI.this.theNoteCntl.getNoteDetailUI(null);
            revalidate();
            repaint();
        }
    }
}
