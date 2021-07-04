package menu;

import com.spiel.Board;
import com.spiel.Spieler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton neustart;
    JButton hauptmenu;

    public Score(){
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel();
        neustart = new JButton();
        hauptmenu = new JButton();

        frame.setTitle("SnikeSnake");
        frame.setResizable(false);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        if (Spieler.getSprache()){
            label.setText(Spieler.getNickname()+" hat einen Score von "+ Board.getScore());
            neustart.setText("Neustart");
            hauptmenu.setText("Hauptmenü");
        }else {
            label.setText(Spieler.getNickname()+" reached a score of "+ Board.getScore());
          neustart.setText("Restart");
           hauptmenu.setText("Main menu");
        }

        label.setBounds(10,10,268,134);
        panel.add(label);

        neustart.setBounds(10,160,268,20);
        panel.add(neustart);

        hauptmenu.setBounds(10,200,268,20);
        panel.add(hauptmenu);

        neustart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpielWahl spielWahl = new SpielWahl();
                frame.setVisible(false);
            }
        });

        hauptmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Startseite startseite = new Startseite();
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);
    }

}
