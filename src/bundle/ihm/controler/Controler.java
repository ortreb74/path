package bundle.ihm.controler;

import bundle.ihm.view.Heap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by pierre donzel on 27/04/2016.
 */
public class Controler implements ActionListener
{
    Heap heap;
    List<String> words;

    public Controler(Heap heap, List<String> words) {
        super();
        this.heap = heap;
        this.words = words;
    }

    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField)e.getSource();
        String word = source.getText();

        words.add(word);

        heap.append (word + "\n");

        String prefix = "You typed \"";

    }
}
