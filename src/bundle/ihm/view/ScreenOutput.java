package bundle.ihm.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pierre donzel on 27/04/2016.
 */
public class ScreenOutput extends JTextArea {

    private Font generalFont;
    private Font numberFont;

    ScreenOutput() {
        generalFont = new Font("Serif", Font.BOLD, 16);
        numberFont  = new Font("Verdana", Font.PLAIN, 14);

        toggleGeneralFont();
        setLineWrap(true);
        setWrapStyleWord(true);
    }

    public void toggleGeneralFont() {
        setFont(generalFont);
    }

    public void toggleNumberFont() {
        setFont(numberFont);
    }
}
