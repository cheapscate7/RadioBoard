
package soundboard.app;
import soundboard.app.soundSection.soundPanel;
import java.awt.*;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

public class SoundboardApp{

    /**
     * @param args the command line arguments
     */
    static int x = 800;
    static int y = 700;
    public static void main(String[] args) throws LineUnavailableException {
        JFrame frame = new JFrame();
        
        
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(x, y);
        frame.setTitle("RadioBoard");
        
        frame.add(new soundPanel(x,y,0,0));
        
        frame.pack();
        //frame.pack();
        frame.setVisible(true);
    }
    
}
