package bundle.ihm.view;

import bundle.ihm.controler.Controler;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by pierre donzel on 27/04/2016.
 */
public class Square extends JPanel {

    public Square(List words) {
        setLayout(new BorderLayout());

        ScreenOutput screenOutput = new ScreenOutput();

        //Create a regular text field.
        JTextField mainInput = new JTextField(10);
        mainInput.setActionCommand("textFieldString");

        //Create some labels for the fields.
        JLabel textFieldLabel = new JLabel("textFieldString : ");
        textFieldLabel.setLabelFor(mainInput);

        //Lay out the text controls and the labels.
        JPanel textControlsPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        textControlsPane.setLayout(gridbag);

        // peut être que cette ligne construit le composant
        // mais que fait le panneau ?
        JLabel[] labels = {textFieldLabel};
        JTextField[] textFields = {mainInput};
        addLabelTextRows(labels, textFields, gridbag, textControlsPane);

        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        //textControlsPane.add(actionLabel, c);
        textControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Text Fields"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));

        JScrollPane areaScrollPane = createScrollPane(screenOutput);

        // le panel de droite
        ScreenOutput screenAlternateOutput = new ScreenOutput();
        JScrollPane secondAreaScrollPane = createScrollPane(screenAlternateOutput);

        // le panel de droite
        JPanel rightPane = new JPanel(new BorderLayout());
        rightPane.add(secondAreaScrollPane,  BorderLayout.PAGE_START);
        add(rightPane, BorderLayout.LINE_END);

        // la ligne qui lie les objets visuels aux données
        // les quatres objets sont évoqués :
        // - mainInput
        // - un objet de type controleur
        // - screenOutput
        // - les mots

        mainInput.addActionListener(new Controler(screenOutput, screenAlternateOutput, words));

        // le panel de gauche
        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(textControlsPane,  BorderLayout.PAGE_START);
        leftPane.add(areaScrollPane,   BorderLayout.CENTER);
        add(leftPane, BorderLayout.LINE_START);
    }

    private JScrollPane createScrollPane(ScreenOutput screenOutput) {
        JScrollPane areaScrollPane = new JScrollPane(screenOutput);
        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));

        areaScrollPane.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Plain Text"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                        areaScrollPane.getBorder()));

        return areaScrollPane;
    }

    private void addLabelTextRows(JLabel[] labels,
                                  JTextField[] textFields,
                                  GridBagLayout gridbag,
                                  Container container) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        int numLabels = labels.length;

        for (int i = 0; i < numLabels; i++) {
            c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
            c.fill = GridBagConstraints.NONE;      //reset to default
            c.weightx = 0.0;                       //reset to default
            container.add(labels[i], c);

            c.gridwidth = GridBagConstraints.REMAINDER;     //end row
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1.0;
            container.add(textFields[i], c);
        }
    }
}
