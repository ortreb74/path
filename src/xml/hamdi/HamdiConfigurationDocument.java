package xml.hamdi;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import xml.XmlDocument;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ext-pdonzel on 09/12/2016.
 */
public class HamdiConfigurationDocument {

    protected Map<String, Map<String,String>> data;

    public Map<String,Map<String,String>> getData() {
        return data;
    }

    public HamdiConfigurationDocument(String fileName) throws IOException, SAXException {
        // cas d'erreur :
        // 1. le fichier n'existe pas (IOException)
        // 2. le fichier n'est pas un fichier xml (SaxException)
        // 3. le fichier ne contient pas d'information
        // 4. le fichier ne contient pas des informations au format attendu

        data = new HashMap<String, Map<String,String>>();

        XmlDocument xmlDocument = new XmlDocument(fileName);

        // pour lire le fichier, il faut se placer sur les parents des variables
        // c'est un XPath

        for (Node node : xmlDocument.evaluateXpath("//variable/..")) {
            Map map = new HashMap<String,String>();

            // c'est plus une méthode déléguée
            for (Node couple : xmlDocument.evaluateXPath(node, "variable")) {
                // retrouver les attributs name et value
                NamedNodeMap attributes = couple.getAttributes();
                map.put(attributes.getNamedItem("name"),attributes.getNamedItem("variable"));
            }

            data.put(node.getNodeName(), map);
        }
    }
}
