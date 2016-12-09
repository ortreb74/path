package xml.hamdi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ext-pdonzel on 09/12/2016.
 */
public class HamdiConfigurationDocumentTest {

    @Test
    public void testHamdiConfigurationDocumentTestInitialisation() {
        try {
            HamdiConfigurationDocument a = new HamdiConfigurationDocument("test/data/hcd.xml");

            if (a.getData().size() != 3) {
                assertEquals("Le fichier ne contient pas le nombre de map attendu", 3, a.getData().size());
            }

            if (! a.getData().containsKey("mementos")) {
                assertTrue("Le fichier ne contient pas la balise mementos", false);
            }

            if (a.getData().get("mementos").size() != 7) {
                assertEquals("Le fichier ne contient pas le nombre de mememtos attendus", 7, a.getData().get("mementos").size());

                a.getData();
            }


        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

}