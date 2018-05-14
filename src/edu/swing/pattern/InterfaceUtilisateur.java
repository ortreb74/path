package edu.swing.pattern;

import javax.swing.*;

public class InterfaceUtilisateur implements Runnable {

    String[] args;

    public InterfaceUtilisateur(String[] args) {
        this.args = args;
    }

    public void run() {
        JFrame frame = new JFrame("interface utilisateur");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // liaison avec le contrôleur
        DataControler controler = new DataControler(args);
        frame.add(controler);

        //
        frame.pack();
        frame.setVisible(true);
    }

}
