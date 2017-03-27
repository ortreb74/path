package xml.edu;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by drncl on 25/03/2017.
 *
 * je vais être obligé de créer une structure intermédiaire parce que je parse tout le fichier
 * en même temps c'est dommage parce que la différence peut être dès le début
 *
 * avec Stax j'ai la notion de NextEvent
 */

public class StartingPoint {

    public static void main(String args[]) throws FileNotFoundException, XMLStreamException {
        /* ceci est purement formel */
        Map<String,String> fileName = new HashMap<String,String>();

        fileName.put("blue", "c:/els/original/brda1603cx.xml");
        fileName.put("red", "c:/els/flash/brda1603cx.xml");

        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        XMLInputFactory xmlif2 = XMLInputFactory.newInstance();

        XMLEventReader xml1 = xmlif.createXMLEventReader(new FileReader(fileName.get("blue")));
        XMLEventReader xml2 = xmlif.createXMLEventReader(new FileReader(fileName.get("red")));

        /* l'objet est de trouver un moyen de parcourir les deux fichiers en même temps */

        XMLEvent read1;
        XMLEvent read2;

        while (xml1.hasNext() && xml2.hasNext()) {

            read1 = xml1.nextEvent();
            read2 = xml2.nextEvent();

            // il faut que je compare les deux évènements, s'il sont du même type, il faut que je rentre dans le détail

            // je vais commenrcer par comparer le début des deux documents

        }

        if (xml1.hasNext()) {
            System.out.println("Le fichier " + fileName.get("red") + " s'est arrêté avant son alter ego");
        }

        if (xml2.hasNext()) {
            System.out.println("Le fichier " + fileName.get("blue") + " s'est arrêté avant son alter ego");
        }
    }
}
