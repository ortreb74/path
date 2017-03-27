package xml.work.deux;

/* un des deux fichiers contient des retours à la ligne */

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by drncl on 25/03/2017.
 */
public class Run {

    public int run() throws FileNotFoundException, XMLStreamException {
        Map<String,String> fileName = new HashMap<String,String>();

        fileName.put("blue", "c:/els/original/brda1603cx.xml");
        fileName.put("red", "c:/els/flash/brda1603cx.xml");

        XMLInputFactory xmlif = XMLInputFactory.newInstance();

        XMLEventReader xml1 = xmlif.createXMLEventReader(new FileReader(fileName.get("blue")));
        XMLEventReader xml2 = xmlif.createXMLEventReader(new FileReader(fileName.get("red")));

        XMLEvent event1;
        XMLEvent event2;

        int i = 0;

        while (xml1.hasNext() && xml2.hasNext() && i++ < 10) {
            event1 = xml1.nextEvent();
            event2 = xml2.nextEvent();

            System.out.println(textualise(event1.getEventType()) + textualise(event2.getEventType()));
        }

        if (xml1.hasNext()) {
            System.out.println("Le fichier " + fileName.get("red") + " s'est arrêté avant son alter ego");
        }

        if (xml2.hasNext()) {
            System.out.println("Le fichier " + fileName.get("blue") + " s'est arrêté avant son alter ego");
        }

        return 0;
    }

    private String textualise(int eventType) {
        String result;

        result = "unknown event : " + String.valueOf(eventType);

        switch (eventType) {
            case XMLEvent.START_ELEMENT : result = "start element"; break;
            case XMLEvent.CHARACTERS : result = "characters"; break;
            case XMLEvent.COMMENT : result = "start element"; break;
        }

        return String.format("%-20s", result);
    }
}
