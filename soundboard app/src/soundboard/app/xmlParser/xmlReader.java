package soundboard.app.xmlParser;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * http://www.beingjavaguys.com/2013/06/read-xml-file-with-sax-parser.html
 * @author Student
 */

public class xmlReader{
    
    Document doc;
    
    public xmlReader(String path) throws ParserConfigurationException, SAXException, IOException{
        File fXmlFile = new File(path);
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException | IOException e) {
        }

        doc.getDocumentElement().normalize();
    }
    
    public NodeList getNodeArray(String nodeName){
        return doc.getElementsByTagName(nodeName);
        
    }
}
