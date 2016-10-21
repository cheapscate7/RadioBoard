/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soundboard.app.soundSection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import soundboard.app.soundSection.buttondata.button;
import soundboard.app.xmlParser.xmlReader;



/**
 *
 * @author Student
 */
public class palette {
    ArrayList buttons = new ArrayList();
    xmlReader paletteReader;
    public palette(int noButtons, String palettePath) throws LineUnavailableException{
        try {
            System.out.println("reading palette xml...");
            System.out.println("palettePath "+palettePath);
            paletteReader = new xmlReader(palettePath);
            System.out.println("read palette xml...");
            System.out.println("initisalising Nodelist of Buttons..");
            NodeList buttonElements = paletteReader.getNodeArray("button");
            System.out.println("Done");
            for(int i = 1; i < buttonElements.getLength(); i++){
                System.out.println("getting path to sound");
                String pathname = buttonElements.item(i).getChildNodes().item(2).getTextContent();
                System.out.println("making temp button " + i);
                System.out.println(pathname);
                button temp = new button(pathname);
                System.out.println("button created\nadding button " +i);
                buttons.add(temp);
                System.out.println("button " + i + "added");
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(palette.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * .getChildNodes().item(1).getTextContent()
     * 
     * @param buttonNo
     * @return 
     */
    public button getButton(int buttonNo){
        return (button)buttons.get(buttonNo);
    }
    
    public void setButton(int buttonNo, String soundPath) throws LineUnavailableException{
        buttons.set(buttonNo, new button(soundPath));
    }
}
