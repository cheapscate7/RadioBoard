package soundboard.app.soundSection;

import soundboard.app.soundSection.listeners.soundButtonRightClickListener;
import java.awt.*;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import soundboard.app.soundSection.buttondata.button;

/**
 *
 * @author Student
 * 
 * Call to create a grid off buttons (a soundboard) on a JPanel to
 * play assigned sounds with
 */
public class soundPanel extends JPanel{
    JPanel sPanel;  //the final panel
    private static palette currentPalette;
    
    /**
     * constructor - assigns a new panel to param sPanel and adds the soundboard
     * buttons
     * @param panel_width width of the panel
     * @param panel_height height of the panel
     * @param x x position of the panel
     * @param y y position of th panel
     * @throws javax.sound.sampled.LineUnavailableException
     */
    public soundPanel(int panel_width, int panel_height, int x, int y) throws LineUnavailableException{
        sPanel = new JPanel();
        
        //set panel properties
        sPanel.setSize(panel_width, panel_height);
        sPanel.setLayout(new GridLayout(3, 6));
        
        //create a new palette
        System.out.println("initialising palatte...");
        currentPalette = new palette(18, "D://Users//Student//Documents//NetBeansProjects//soundboard app//src//soundboard//app//Palettes//defaultPalette.xml");
        
        //add buttons
        addButtonGrid();
     
        
        add(sPanel);
    }
    
    private void addButtonGrid(){
        button currentButton;
        for(int i = 0; i < 18; i++){
            //create button
            currentButton = currentPalette.getButton(i);
            JButton button = new JButton(currentButton.getName());
            button.setSize(100, 50);
            
            
            //add the event listener to bring up the "add new sound" menu when
            //the button is right clicked
            button.addMouseListener(new soundButtonRightClickListener());
            sPanel.add(button);
        }
    }
}
