package bundle.ihm.controler;

import bundle.ihm.data.TypedAffine;
import bundle.ihm.data.QualifiedNumber;
import bundle.ihm.view.ScreenOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * Created by pierre donzel on 27/04/2016.
 */
public class Controler implements ActionListener
{
    private QualifiedNumber qualifiedNumber;
    private TypedAffine typedAffine;

    private final ScreenOutput firstOutput;
    private final ScreenOutput secondOutput;

    private ScreenOutput screenOutput;
    private List<String> words;


    public Controler(ScreenOutput firstOutput, ScreenOutput secondOutput, List<String> words) {
        super();

        qualifiedNumber = new QualifiedNumber();
        typedAffine = new TypedAffine();

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

                for (Map.Entry<String,String> w : typedAffine.getAffine().get().entrySet()) {
                    secondOutput.append (w.getKey() + "\n");
                    secondOutput.append (w.getValue() + "\n");
                }
            }

            qualifiedNumber = new QualifiedNumber();
        }

    }
}
