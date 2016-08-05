package bundle.ihm;

import bundle.ihm.view.Square;

import javax.swing.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pierre donzel on 27/04/2016.
 */

public class Start {

    public static void main(String[] args) {
        //Schedule a job for the event dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //UIManager.put("swing.boldMetal", Boolean.FALSE); //Turn off metal's use of bold fonts
                JFrame frame = new JFrame("copy");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                List words = new ArrayList<String>();

                //Add content to the window.
                frame.add(new Square(words));
                frame.addWindowListener(new Terminator(words));

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}
