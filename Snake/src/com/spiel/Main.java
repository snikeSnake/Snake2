package com.spiel;

import menu.Startseite;

import javax.swing.JFrame;

public class Main extends JFrame {
   static JFrame frame;

    public Main(int geschwindigkeit) {
        frame = new JFrame();
        frame.setVisible(true);
        frame.add(new Spiel(geschwindigkeit));
        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Snake");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void setJFrame (boolean b){
        frame.setVisible(b);
    }
    public static void main(String[] args) {
        Startseite startseite = new Startseite();
    }
}
