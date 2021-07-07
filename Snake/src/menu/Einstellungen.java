package menu;

import com.spiel.Spieler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//GUI zum ändern der Einstellungen

public class Einstellungen extends JFrame{


    JFrame frame;
    JPanel panel;
    JLabel steuerung;
    JButton steuerungWahl;
    JLabel sprache;
    JButton spracheWahl;
    JLabel farbe;
    JButton farbeGruen;
    JButton farbeRot;
    JButton farbeBlau;
    JButton farbeGelb;
    JButton zurueck;

    public Einstellungen(){
        //baut das Fenster
        frame = new JFrame();
        panel = new JPanel();
        steuerung = new JLabel();
        steuerungWahl = new JButton();
        sprache = new JLabel();
        spracheWahl = new JButton();
        farbe = new JLabel();
        farbeGruen = new JButton();
        farbeBlau = new JButton();
        farbeRot = new JButton();
        farbeGelb = new JButton();
        zurueck = new JButton();

        frame.setTitle("SnikeSnake");
        frame.setResizable(false);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        //setzt den Text in Abhängigkeit der Sprache
        if(Spieler.getSprache()){
            steuerung.setText("Steuerung");
            sprache.setText("Sprache");
            spracheWahl.setText("Deutsch");
            farbe.setText("Farbe");
            farbeBlau.setText("Blau");
            farbeGruen.setText("Grün");
            farbeRot.setText("Rot");
            farbeGelb.setText("Gelb");
            zurueck.setText("Zurück");
        }else{
            steuerung.setText("Controls");
            sprache.setText("Language");
            spracheWahl.setText("English");
            farbe.setText("Color");
            farbeBlau.setText("Blue");
            farbeGruen.setText("Green");
            farbeRot.setText("Red");
            farbeGelb.setText("Yellow");
            zurueck.setText("Back");
        }

        steuerung.setBounds(10,10,120,20);
        panel.add(steuerung);

        steuerungWahl.setBounds(120,10,150,20);
        if (Spieler.getSteuerung()){
            steuerungWahl.setText("WASD");
        }else{
           if(Spieler.getSprache()){
               steuerungWahl.setText("Pfeiltasten");
           }else {
               steuerungWahl.setText("Arrow keys");
           }
        }
        panel.add(steuerungWahl);

        sprache.setBounds(10,50,120,20);
        panel.add(sprache);

        spracheWahl.setBounds(120,50,150,20);
        panel.add(spracheWahl);

        farbe.setBounds(10,90,120,20);
        panel.add(farbe);

        farbeGruen.setBounds(120,90,150,20);
        panel.add(farbeGruen);

        farbeBlau.setBounds(120,120,150,20);
        panel.add(farbeBlau);

        farbeRot.setBounds(120,150,150,20);
        panel.add(farbeRot);

        farbeGelb.setBounds(120,180,150,20);
        panel.add(farbeGelb);

        zurueck.setBounds(10,230,268,20);
        panel.add(zurueck);


        // wenn steuerungsWahl gedrückt wird ändert sich die Steuerung
        steuerungWahl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Spieler.getSteuerung()){
                    Spieler.setSteuerung(false);
                    if(Spieler.getSprache()){
                        steuerungWahl.setText("Pfeiltasten");
                    }else {
                        steuerungWahl.setText("Arrow keys");
                    }
                }else{
                    Spieler.setSteuerung(true);
                    steuerungWahl.setText("WASD");
                }
            }
        });

        // wenn sprachWahl gedrückt wird ändert sich die Sprache
        spracheWahl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Spieler.getSprache()){
                    Spieler.setSprache(false);

                    steuerung.setText("Controls");

                    sprache.setText("Language");

                    spracheWahl.setText("English");

                    farbe.setText("Color");

                    farbeBlau.setText("Blue");
                    farbeGruen.setText("Green");
                    farbeRot.setText("Red");
                    farbeGelb.setText("Yellow");

                    zurueck.setText("Back");

                    if(Spieler.getSteuerung()){
                        steuerungWahl.setText("WASD");
                    }else {
                        steuerungWahl.setText("Arrow keys");
                    }
                }else{
                    Spieler.setSprache(true);
                    steuerung.setText("Steuerung");

                    sprache.setText("Sprache");

                    spracheWahl.setText("Deutsch");

                    farbe.setText("Farbe");

                    farbeBlau.setText("Blau");
                    farbeGruen.setText("Grün");
                    farbeRot.setText("Rot");
                    farbeGelb.setText("Gelb");

                    zurueck.setText("Zurück");

                    if(Spieler.getSteuerung()){
                        steuerungWahl.setText("WASD");
                    }else {
                        steuerungWahl.setText("Pfeiltasten");
                    }
                }
            }
        });

        // wenn farbeRot gedrückt wird ändert sich die Farbe zu Rot
        farbeRot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Spieler.setFarbe("rot");
            }
        });

        // wenn farbeRot gedrückt wird ändert sich die Farbe zu Blau
        farbeBlau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spieler.setFarbe("blau");
            }
        });

        // wenn farbeRot gedrückt wird ändert sich die Farbe zu Grün
        farbeGruen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spieler.setFarbe("grün");
            }
        });

        // wenn farbeRot gedrückt wird ändert sich die Farbe zu Gelb
        farbeGelb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spieler.setFarbe("gelb");
            }
        });

        // geht zurück auf die Startseite
        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startseite startseite =new Startseite();
                frame.setVisible(false);
            }
        });


        frame.setVisible(true);
    }}

