package bundle.ihm.controler;

import bundle.ihm.data.Affine;
import bundle.ihm.data.QualifiedNumber;
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
    private QualifiedNumber qualifiedNumber;
    private Affine typedAffine;

    private final ScreenOutput firstOutput;
    private final ScreenOutput secondOutput;

    private ScreenOutput screenOutput;
    private List<String> words;


    public Controler(ScreenOutput firstOutput, ScreenOutput secondOutput, List<String> words) {
        super();

        qualifiedNumber = new QualifiedNumber();
        typedAffine = new Affine();

        this.firstOutput = firstOutput;
        this.firstOutput.toggleGeneralFont();

        this.secondOutput = secondOutput;
        this.secondOutput.toggleNumberFont();

        screenOutput = firstOutput;

        this.words = words;
    }

    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField)e.getSource();

        String input = source.getText();
        source.setText(null);

        words.add(input);

        screenOutput.append (input + "\n");
        //screenOutput = firstOutput;
        qualifiedNumber.add(input);
        if (qualifiedNumber.isCompleted()) {
            typedAffine.add(qualifiedNumber);

            if (typedAffine.isCompleted()) {
                secondOutput.setText(null);

                for (String w : typedAffine.getWords()) secondOutput.append (w + "\n");
            }

            qualifiedNumber = new QualifiedNumber();
        }

    }
}