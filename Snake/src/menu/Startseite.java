package menu;

import com.spiel.Spieler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// GUI lässt den Spieler den Spieler die Einstellungenöffnen, die Spielwahl öffnen und einen Nicknamen wählen
public class Startseite extends JFrame {

    JFrame frame;
    JPanel panel;
    JButton einstellung;
    JButton spielen;
    JLabel nickname;
    JTextField neuNickname;
    JButton nicknameBestätigen;
    JLabel nicknameFalsch;

    public Startseite(){
        //baut Fenster
    frame = new JFrame();
    panel = new JPanel();
    einstellung = new JButton();
    spielen = new JButton();
    nickname = new JLabel();
    neuNickname = new JTextField();
    nicknameBestätigen = new JButton();
    nicknameFalsch = new JLabel();

    frame.setTitle("SnikeSnake");
    frame.setResizable(false);
    frame.setSize(300,300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);

    panel.setLayout(null);

    if(Spieler.getSprache()){

       einstellung.setText("Einstellungen");

       spielen.setText("Spielen");

       nickname.setText("Nickname");

       nicknameBestätigen.setText("Nickname Bestätigen");

       nicknameFalsch.setText("Dieser Nickname ist nicht zugelassen");
    } else{

        einstellung.setText("Settings");

        spielen.setText("Play");

        nickname.setText("Nickname");

        nicknameBestätigen.setText("Confirm nickname");

        nicknameFalsch.setText("This nickname is invalid");
    }

    einstellung.setBounds(0,0,300,30);
    panel.add(einstellung);

    spielen.setBounds(80,60,140,100);
    panel.add(spielen);

    nickname.setBounds(20,200,80,20);
    panel.add(nickname);

    neuNickname.setBounds(90,200,180,20);
    panel.add(neuNickname);

    nicknameBestätigen.setBounds(50,235,180,20);
    panel.add(nicknameBestätigen);

    nicknameFalsch.setBounds(10,170,180,20);
    nicknameFalsch.setVisible(false);
    panel.add(nicknameFalsch);

    frame.setVisible(true);


    //geht zu den Einstellungen
    einstellung.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Einstellungen einstellungen = new Einstellungen();
            frame.setVisible(false);        }
    });

    // geht zur SpielWahl
    spielen.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SpielWahl spielWahl = new SpielWahl();
            frame.setVisible(false);        }
    });

    //setzt einen Nickname
    nicknameBestätigen.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           //bedingung für den Nicknamen:nicht leer, keine Leerzeichen,nur 16 lang
            if(neuNickname.getText()!=null && !neuNickname.getText().contains(" ") && neuNickname.getText().length() <=16 ){
               Spieler.setNickname(neuNickname.getText());
               nicknameFalsch.setVisible(false);
           }
            else{
                //zeigt Fehlermeldung
                nicknameFalsch.setVisible(true);
            }
        }
    });


    }
}

