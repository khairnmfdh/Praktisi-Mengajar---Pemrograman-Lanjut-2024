package com.mycompany.antreancatsalon;


import test.GUI;
import test.JFAntrean;
import test.JFDataKucing;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
                
            }
        });
    }
}
