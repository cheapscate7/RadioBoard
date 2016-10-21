/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soundboard.app.FileExplorer;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Student
 */
public class newExplorer {
    File selectedFile;
    final JFileChooser fc;
    public newExplorer(){
        fc = new JFileChooser();
        System.out.println("file chooser loaded");
        int returnVal = fc.showOpenDialog(null);
        
    }
    
    public File getFile(){
        selectedFile = fc.getSelectedFile();
        return selectedFile;
    }
    public String getFileName(){
        selectedFile = fc.getSelectedFile();
        return selectedFile.getName();
    }
    public String getFilePath(){
        selectedFile = fc.getSelectedFile();
        return selectedFile.getAbsolutePath();
    }
}
