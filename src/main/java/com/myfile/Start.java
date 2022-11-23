package com.myfile;

;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start implements ActionListener {

    private JFrame window;
    public Start(){
        window = new JFrame("Калькулятор");
        window.setSize(290, 350);
        window.add(new Panel());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Start();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}