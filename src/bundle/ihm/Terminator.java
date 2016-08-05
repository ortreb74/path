package bundle.ihm; /**
 * Created by pierre donzel on 02/04/2016.
 */

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class Terminator extends WindowAdapter {

    List<String> words;

    public Terminator(List<String> words) {
        this.words = words;
    }

    public void windowClosing(WindowEvent e) {
        for (String word : words) {
            System.out.println(word);
        }
    }

}
