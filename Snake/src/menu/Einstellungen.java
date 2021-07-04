package menu;

import com.spiel.Spieler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JButton zurueck;

    public Einstellungen(){
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
        zurueck = new JButton();

        frame.setTitle("SnikeSnake");
        frame.setResizable(false);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        if(Spieler.getSprache()){
            steuerung.setText("Steuerung");
            sprache.setText("Sprache");
            spracheWahl.setText("Deutsch");
            farbe.setText("Farbe");
            farbeBlau.setText("Blau");
            farbeGruen.setText("Grün");
            farbeRot.setText("Rot");
            zurueck.setText("Zurück");
        }else{
            steuerung.setText("Controls");
            sprache.setText("Language");
            spracheWahl.setText("English");
            farbe.setText("Color");
            farbeBlau.setText("Blue");
            farbeGruen.setText("Green");
            farbeRot.setText("Red");
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

        farbeBlau.setBounds(120,130,150,20);
        panel.add(farbeBlau);

        farbeRot.setBounds(120,170,150,20);
        panel.add(farbeRot);

        zurueck.setBounds(10,230,268,20);
        panel.add(zurueck);

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

                    zurueck.setText("Zurück");

                    if(Spieler.getSteuerung()){
                        steuerungWahl.setText("WASD");
                    }else {
                        steuerungWahl.setText("Pfeiltasten");
                    }
                }
            }
        });

        farbeRot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Spieler.setFarbe("rot");
            }
        });

        farbeBlau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spieler.setFarbe("blau");
            }
        });

        farbeRot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Spieler.setFarbe("grün");
            }
        });

        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startseite startseite =new Startseite();
                frame.setVisible(false);
            }
        });


        frame.setVisible(true);
    }}

