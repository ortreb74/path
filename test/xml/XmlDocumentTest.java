package xml;

import org.junit.Test;
import xml.XmlDocument;

import static org.junit.Assert.*;

/**
 * Created by ext-pdonzel on 09/12/2016.
 */

public class XmlDocumentTest {

    @Test
    public void testXmlDocumentTestInitialisation() {
        try {
            // écrit comme cela c'est un chemin relatif
            // comment écrire un chemin absolu ?
            XmlDocument a = new XmlDocument("test/data/a.xml");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        assertTrue(true);
    }

}