package com.spiel;

import menu.Score;
import com.spiel.*;

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


    private final int feldanzahl = 30;
    private final int feldgroesse = 16;
    private final int breite = feldanzahl*feldgroesse;
    private final int feldzahl = feldanzahl*feldanzahl;
    private final int geschwindigkeit;

    private final int x[] = new int[feldzahl];
    private final int y[] = new int[feldzahl];

    private static int laenge;
    private int apfel_x;
    private int apfel_y;

    private boolean links = false;
    private boolean rechts = true;
    private boolean hoch = false;
    private boolean runter = false;

    private boolean lebend = true;

    private Timer timer;
    private Image koerper;
    private Image apfel;
    private Image kopf;

    public Spiel(int g) {
        geschwindigkeit = g;
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(breite, breite));
        bildLaden();
        starten();
    }


    private void bildLaden() {

        ImageIcon kp = new ImageIcon("Snake/src/icons/koerper.png");
        koerper = kp.getImage();

        ImageIcon a = new ImageIcon("Snake/src/icons/apfel.png");
        apfel = a.getImage();

        ImageIcon kf = new ImageIcon("Snake/src/icons/kopf.png");
        kopf = kf.getImage();
    }

    private void starten() {

        laenge = 3;

        for (int z = 0; z < laenge; z++) {
            x[z] = 5*feldgroesse - z * feldgroesse;
            y[z] = 5*feldgroesse;
        }
        
        apfelSetzen();

        timer = new Timer(geschwindigkeit, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        zeichnen(g);
    }
    
    private void zeichnen(Graphics g) {
        
        if (lebend) {

            g.drawImage(apfel, apfel_x, apfel_y, this);

            for (int z = 0; z < laenge; z++) {
                if (z == 0) {
                    g.drawImage(kopf, x[z], y[z], this);
                } else {
                    g.drawImage(koerper, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            Score score =new Score();
            Main.setJFrame(false);
        }        
    }

   public static String getScore() {
     String  score = Integer.toString(laenge-3);
        return score;
   }

    private void apfelEssen() {

        if ((x[0] == apfel_x) && (y[0] == apfel_y)) {

            laenge++;
            apfelSetzen();
        }
    }

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

    private void tot() {

        for (int z = laenge; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                lebend = false;
            }
        }

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
        
        if (!lebend) {
            timer.stop();
        }
    }

    private void apfelSetzen() {

        int r = (int) (Math.random() * feldanzahl-1);
        apfel_x = ((r * feldgroesse));

        r = (int) (Math.random() * feldanzahl-1);
        apfel_y = ((r * feldgroesse));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (lebend) {

            apfelEssen();
            tot();
            bewegen();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {

if (Spieler.getSteuerung()){
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_A) && (!rechts)) {
                links = true;
                hoch = false;
                runter = false;
            }

            if ((key == KeyEvent.VK_D) && (!links)) {
                rechts = true;
                hoch = false;
                runter = false;
            }

            if ((key == KeyEvent.VK_W) && (!runter)) {
                hoch = true;
                rechts = false;
                links = false;
            }

            if ((key == KeyEvent.VK_S) && (!hoch)) {
                runter = true;
                rechts = false;
                links = false;
            }
        }else {
    int key = e.getKeyCode();

    if ((key == KeyEvent.VK_LEFT) && (!rechts)) {
        links = true;
        hoch = false;
        runter = false;
    }

    if ((key == KeyEvent.VK_RIGHT) && (!links)) {
        rechts = true;
        hoch = false;
        runter = false;
    }

    if ((key == KeyEvent.VK_UP) && (!runter)) {
        hoch = true;
        rechts = false;
        links = false;
    }

    if ((key == KeyEvent.VK_DOWN) && (!hoch)) {
        runter = true;
        rechts = false;
        links = false;
    }
        }
        }
    }
}
