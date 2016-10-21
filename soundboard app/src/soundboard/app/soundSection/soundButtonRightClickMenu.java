/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soundboard.app.soundSection;

import javax.swing.*;
import soundboard.app.soundSection.listeners.addNewSoundListener;

/**
 *  right-click menu builder for sound buttons
 * @author Student
 */
public class soundButtonRightClickMenu extends JPopupMenu{
    JMenuItem menuItem;
    public soundButtonRightClickMenu(){
        menuItem = new JMenuItem("Add sound");
        menuItem.addActionListener(new addNewSoundListener());
        add(menuItem);
    }
  
}
