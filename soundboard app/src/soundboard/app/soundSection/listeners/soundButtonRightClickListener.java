package soundboard.app.soundSection.listeners;

import java.awt.event.*;
import soundboard.app.soundSection.soundButtonRightClickMenu;

/**
 * Listener for the sound buttons to display the right-click menu to assign a
 * sound to the button
 * @author Student
 */
public class soundButtonRightClickListener  extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e){
        soundButtonRightClickMenu menu = new soundButtonRightClickMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
        
    }
}
