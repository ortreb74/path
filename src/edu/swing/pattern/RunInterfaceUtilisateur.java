package edu.swing.pattern;

import javax.swing.*;

/**
 * Created by drncl on 08/02/2017.
 */
public class RunInterfaceUtilisateur {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new InterfaceUtilisateur(args));
    }

}
