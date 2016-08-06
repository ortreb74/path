package bundle.ihm.controler;

import bundle.ihm.view.ScreenOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by pierre donzel on 27/04/2016.
 */
public class Controler implements ActionListener
{
    private final ScreenOutput firstOutput;
    private final ScreenOutput secondOutput;

    private ScreenOutput screenOutput;
    private List<String> words;

    public Controler(ScreenOutput firstOutput, ScreenOutput secondOutput, List<String> words) {
        super();
        this.firstOutput = firstOutput;
        this.firstOutput.toggleGeneralFont();

        this.secondOutput = firstOutput;
        this.secondOutput.toggleNumberFont();

        screenOutput = secondOutput;

        this.words = words;
    }

    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField)e.getSource();
        String word = source.getText();

        words.add(word);

        screenOutput.append (word + "\n");
        screenOutput = firstOutput;

    }
}
