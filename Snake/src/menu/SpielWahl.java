package menu;

import com.spiel.Main;
import com.spiel.Spieler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpielWahl extends JFrame{
    JFrame frame;
    JPanel panel;
    JButton klassisch;
    JButton schnell;
    JButton langsam;
    JButton gross;
    JButton klein;
    JButton zurueck;

    public SpielWahl (){
        frame = new JFrame();
        panel = new JPanel();
        klassisch = new JButton();
        schnell = new JButton();
        langsam = new JButton();
        gross = new JButton();
        klein = new JButton();
        zurueck = new JButton();

        frame.setTitle("SnikeSnake");
        frame.setResizable(false);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        if(Spieler.getSprache()){
            klassisch.setText("Klassisch");
            schnell.setText("Schnell");
            langsam.setText("Langsam");
            gross.setText("Großes Feld");
            klein.setText("Kleines Feld");
            zurueck.setText("Zurück");
        }else{
            klassisch.setText("Classic");
            schnell.setText("Fast");
            langsam.setText("Slow");
            gross.setText("Big field");
            klein.setText("Small field");
            zurueck.setText("Back");
        }

        klassisch.setBounds(10,10,268,20);
        panel.add(klassisch);

        schnell.setBounds(10,40,268,20);
        panel.add(schnell);

        langsam.setBounds(10,70,268,20);
        panel.add(langsam);

        gross.setBounds(10,100,268,20);
        panel.add(gross);

        klein.setBounds(10,130,268,20);
        panel.add(klein);

        zurueck.setBounds(10,230,268,20);
        panel.add(zurueck);

        zurueck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startseite startseite =new Startseite();
                frame.setVisible(false);
            }
        });

        klassisch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main(140);
                frame.setVisible(false);
            }
        });

        schnell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main(90);
                frame.setVisible(false);
            }
        });

        langsam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main(200);
                frame.setVisible(false);
            }
        });

        gross.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main(140);
                frame.setVisible(false);
            }
        });

        klein.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main(200);
                frame.setVisible(false);
            }
        });





        frame.setVisible(true);

    }
}


