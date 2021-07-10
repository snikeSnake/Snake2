package com.spiel;

import menu.Startseite;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;

public class Main extends JFrame {
   static JFrame frame;

    public Main(int geschwindigkeit,int feld) {
        //baut das Snake Fenster
        frame = new JFrame();
        frame.setVisible(true);
        frame.add(new Spiel(geschwindigkeit, feld));//baut das Spiel
        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Snake");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            Musik musik = new Musik();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void setJFrame (boolean b){
        frame.setVisible(b);
    }
    public static void main(String[] args) {
        //öfnet die Startseite
        Startseite startseite = new Startseite();
        try {
            Musik musik = new Musik();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
