import java.util.Collection;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.util.HashSet;
import org.w3c.dom.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class Folders {
    
    
    private static String nodeToString(Node node) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException te) {
            System.out.println("nodeToString Transformer Exception");
        }
        return sw.toString();
    }
        

    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
    
        Collection<String> ret = new HashSet<String>();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));
        Element root = (Element)doc.getDocumentElement();
        
        if (root.getAttribute("name").startsWith(Character.toString(startingLetter))){
                    System.out.println(" root added " + root.getAttribute("name"));
                    ret.add(root.getAttribute("name"));
                }        
        
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);            
            if (currentNode.getNodeType() == Node.ELEMENT_NODE){
                Element currentElement = (Element)currentNode;
                if (currentElement.getAttribute("name").startsWith(Character.toString(startingLetter))){
                    System.out.println(" element added " + currentElement.getAttribute("name"));
                    ret.add(currentElement.getAttribute("name"));
                }
                ret.addAll(folderNames(nodeToString(currentNode), startingLetter));
            }
        }
        return ret;
    }
    
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
        
    }
}
