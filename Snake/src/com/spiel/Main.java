package com.spiel;

import menu.Startseite;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;

public class Main extends JFrame {

    static JFrame frame;//Spielbrett

    public Main(int geschwindigkeit,int feld) {
        //baut das Snake Fenster
        frame = new JFrame();
        frame.setVisible(true);//man sieht das Fenster
        frame.add(new Spiel(geschwindigkeit, feld));//baut das Spiel
        frame.setResizable(false);//macht Größe ändern unmöglich
        frame.pack();//min. Fenstergröße
        frame.setTitle("Snake");//Titel vom Fenster
        frame.setLocationRelativeTo(null);//mittig plaziert
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//schließt Spiel wenn man auf X drückt
    }

    public static void setJFrame (boolean b){
        frame.setVisible(b);
    }
    public static void main(String[] args) {
        //öfnet die Startseite
        Startseite startseite = new Startseite();

      //baut ein neues Musikobjekt
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
