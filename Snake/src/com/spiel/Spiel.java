package com.spiel;

import menu.Score;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Spiel extends JPanel implements ActionListener {

    private boolean freigabe = true;
    private final int feldanzahl ;//Größe des Spielfeldes
    private final int feldgroesse = 16;//Größe in Pixeln eines einzelnen Feldes
    private final int breite ;//Größe in Pixeln des Spielfeldes
    private final int feldzahl;//Anzahl der Felder
    private final int geschwindigkeit;//Geschwindigkeit der Schlange

    private int[] x;//Position x eines Schlangenteils
    private int[] y;//Position y eines Schlangenteils

    private static int laenge;//Die Länge der Schlange
    private int apfel_x;//Position x des Apfels
    private int apfel_y;//Position x des Apfels


    //Bewegungsrichtung der Schlange
    private boolean links = false;
    private boolean rechts = true;
    private boolean hoch = false;
    private boolean runter = false;

    //Status der Schlange:lebend/tot
    private boolean lebend = true;

    //Timer für die Zeitverzögerung
    private Timer timer;
    //Bilder
    private Image koerper;
    private Image apfel;
    private Image kopfw;
    private Image kopfs;
    private Image kopfa;
    private Image kopfd;
    //Kann kopfa/kopfw/kopfs/kopfd sein
    private Image kopf;

    //Konstruktor
    public Spiel(int g,int feld) {
        feldanzahl = feld;
        breite = feldanzahl*feldgroesse;
        feldzahl = feldanzahl*feldanzahl;
        x = new int[feldzahl];
        y = new int[feldzahl];
        geschwindigkeit = g;//setzt die Geschwindigkeit der Schlange fest
        addKeyListener(new TAdapter());//aktiviert einen TAdapter
        setBackground(Color.black);//setzt die Hintergrundfarbe
        setFocusable(true);
        setPreferredSize(new Dimension(breite, breite));//setzt die Breite
        bildLaden();
        starten();
    }

//lädt alle nötigen Bilder (unterschiedlich nach Farbeinstellungen)
    private void bildLaden() {
        ImageIcon a = new ImageIcon("Snake/src/icons/apple.png");
        apfel = a.getImage();
    if (Spieler.getFarbe()== "grün") {
        ImageIcon kp = new ImageIcon("Snake/src/icons/body_green.png");
        koerper = kp.getImage();
        ImageIcon kfw = new ImageIcon("Snake/src/icons/h_g_o.png");
        kopfw = kfw.getImage();
        ImageIcon kfs = new ImageIcon("Snake/src/icons/h_g_u.png");
        kopfs = kfs.getImage();
        ImageIcon kfa = new ImageIcon("Snake/src/icons/h_g_l.png");
        kopfa = kfa.getImage();
        ImageIcon kfd = new ImageIcon("Snake/src/icons/h_g_r.png");
        kopfd = kfd.getImage();
                            }else
    if (Spieler.getFarbe()== "blau") {
        ImageIcon kp = new ImageIcon("Snake/src/icons/body_blue.png");
        koerper = kp.getImage();
        ImageIcon kfw = new ImageIcon("Snake/src/icons/h_b_o.png");
        kopfw = kfw.getImage();
        ImageIcon kfs = new ImageIcon("Snake/src/icons/h_b_u.png");
        kopfs = kfs.getImage();
        ImageIcon kfa = new ImageIcon("Snake/src/icons/h_b_l.png");
        kopfa = kfa.getImage();
        ImageIcon kfd = new ImageIcon("Snake/src/icons/h_b_r.png");
        kopfd = kfd.getImage();
    }else
    if (Spieler.getFarbe()== "rot") {
        ImageIcon kp = new ImageIcon("Snake/src/icons/body_red.png");
        koerper = kp.getImage();
        ImageIcon kfw = new ImageIcon("Snake/src/icons/h_r_o.png");
        kopfw = kfw.getImage();
        ImageIcon kfs = new ImageIcon("Snake/src/icons/h_r_u.png");
        kopfs = kfs.getImage();
        ImageIcon kfa = new ImageIcon("Snake/src/icons/h_r_l.png");
        kopfa = kfa.getImage();
        ImageIcon kfd = new ImageIcon("Snake/src/icons/h_r_r.png");
        kopfd = kfd.getImage();
    }else
    if (Spieler.getFarbe()== "gelb") {
        ImageIcon kp = new ImageIcon("Snake/src/icons/body_yellow.png");
        koerper = kp.getImage();
        ImageIcon kfw = new ImageIcon("Snake/src/icons/h_y_o.png");
        kopfw = kfw.getImage();
        ImageIcon kfs = new ImageIcon("Snake/src/icons/h_y_u.png");
        kopfs = kfs.getImage();
        ImageIcon kfa = new ImageIcon("Snake/src/icons/h_y_l.png");
        kopfa = kfa.getImage();
        ImageIcon kfd = new ImageIcon("Snake/src/icons/h_y_r.png");
        kopfd = kfd.getImage();
    }



    }

    private void starten() {
        laenge = 3;//setzt die Startlänge der Schlange

        //setzt die x und y Positionen für alle Startkörperteile
        for (int z = 0; z < laenge; z++) {
            x[z] = 3*feldgroesse - z * feldgroesse;
            y[z] = 0;
        }
        
        apfelSetzen();

        //startet den timer abhängig von der Geschwindigkeit
        timer = new Timer(geschwindigkeit, this);
        timer.start();
    }

    //zeichnet die Grafik
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        zeichnen(g);
    }

    public void zeichnen(Graphics g) {
        
        if (lebend) {//wenn die Schlange noch lebt


            kopfSetzen();

            //malt den Apfel
                g.drawImage(apfel, apfel_x, apfel_y, this);

                // makt den Schlangenkörper
            for (int z = 0; z < laenge; z++) {
                if (z == 0) {
                    g.drawImage(kopf, x[z], y[z], this);
                } else {
                    g.drawImage(koerper, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            //wenn nicht am leben
            Score score =new Score();//öffnet das Scoreboard
            Main.setJFrame(false);//schliesst das Spiel
        }        
    }

    //berechnet den Score
   public static String getScore() {
     String  score = Integer.toString(laenge-3);
        return score;
   }

   //prüft ob der Apfel gegessen wurde
    private void apfelEssen() {

        if ((x[0] == apfel_x) && (y[0] == apfel_y)) {

            laenge++;
            apfelSetzen();
        }
    }

    //Setzt die Richtung des Kopfes und das daraufhin zu verwendete Bild
    public void kopfSetzen(){
        if(hoch){
            kopf = kopfw;

        }else  if(links){
            kopf = kopfa;

        }else if(rechts){
            kopf = kopfd;

        }else if(runter){
            kopf = kopfs;

        }
    }

    //Bewegt die Schlange um ein Feld in belibige Richtung
    private void bewegen() {

        for (int z = laenge; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (links) {
            x[0] -= feldgroesse;
        }

        if (rechts) {
            x[0] += feldgroesse;
        }

        if (hoch) {
            y[0] -= feldgroesse;
        }

        if (runter) {
            y[0] += feldgroesse;
        }
    }

    //Überprüft ob die Schlange tot ist
    private void tot() {

        //prüft ob die Schlange sich selbst isst
        for (int z = laenge; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                lebend = false;
            }
        }
        // prüft ob die Schlange eine Wand trifft
        if (y[0] >= breite) {
            lebend = false;
        }

        if (y[0] < 0) {
            lebend = false;
        }

        if (x[0] >= breite) {
            lebend = false;
        }

        if (x[0] < 0) {
            lebend = false;
        }


        //stopptden Timerr fals die Schlange tot ist
        if (!lebend) {
            timer.stop();
        }
    }

    //setzt einen neuen Apfel
    private void apfelSetzen() {

        //zufällige Wahl der x und y Koordinate
        int r = (int) (Math.random() * feldanzahl-1);
        apfel_x = ((r * feldgroesse));

        r = (int) (Math.random() * feldanzahl-1);
        apfel_y = ((r * feldgroesse));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //aktualisiert das Spiel im vom Timer gegebenen Zeitinterval
        if (lebend) {

            apfelEssen();
            tot();
            bewegen();
            freigabe=true;
        }
        //zeichnet alle Grafiken neu
        repaint();
    }

    //überprüft ob es Tastenanschläge gab
    private class TAdapter extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {
if (freigabe){
if (Spieler.getSteuerung()){
    //überprüft WASD-Anschläge
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_A) && (!rechts)) {
                links = true;
                hoch = false;
                runter = false;
                kopf = kopfa;
            }

            if ((key == KeyEvent.VK_D) && (!links)) {
                rechts = true;
                hoch = false;
                runter = false;
                kopf = kopfd;
            }

            if ((key == KeyEvent.VK_W) && (!runter)) {
                hoch = true;
                rechts = false;
                links = false;
                kopf = kopfw;
            }

            if ((key == KeyEvent.VK_S) && (!hoch)) {
                runter = true;
                rechts = false;
                links = false;
                kopf = kopfs;
            }
        }else {
    int key = e.getKeyCode();
//überpruft Pfeiltatsenanschläge
    if ((key == KeyEvent.VK_LEFT) && (!rechts)) {
        links = true;
        hoch = false;
        runter = false;
        kopf = kopfa;
    }

    if ((key == KeyEvent.VK_RIGHT) && (!links)) {
        rechts = true;
        hoch = false;
        runter = false;
        kopf = kopfd;
    }

    if ((key == KeyEvent.VK_UP) && (!runter)) {
        hoch = true;
        rechts = false;
        links = false;
        kopf = kopfw;
    }

    if ((key == KeyEvent.VK_DOWN) && (!hoch)) {
        runter = true;
        rechts = false;
        links = false;
        kopf = kopfs;
    }
        }
        }
        freigabe=false;
        }
    }
}
