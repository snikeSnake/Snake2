package menu;

import com.spiel.Spieler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Startseite extends JFrame {

    JFrame frame;
    JPanel panel;
    JButton einstellung;
    JButton spielen;
    JLabel nickname;
    JTextField neuNickname;
    JButton nicknameBestätigen;

    public Startseite(){

    frame = new JFrame();
    panel = new JPanel();
    einstellung = new JButton();
    spielen = new JButton();
    nickname = new JLabel();
    neuNickname = new JTextField();
    nicknameBestätigen = new JButton();

    frame.setTitle("SnikeSnake");
    frame.setResizable(false);
    frame.setSize(300,300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);

    panel.setLayout(null);

    if(Spieler.getSprache()){

       einstellung.setText("menu.Einstellungen");

       spielen.setText("Spielen");

       nickname.setText("Nickname");

       nicknameBestätigen.setText("Nickname Bestätigen");
    } else{

        einstellung.setText("Settings");

        spielen.setText("Play");

        nickname.setText("Nickname");

        nicknameBestätigen.setText("Confirm nickname");
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

    frame.setVisible(true);

    einstellung.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Einstellungen einstellungen = new Einstellungen();
            startseiteSchliessen();
        }
    });


    spielen.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SpielWahl spielWahl = new SpielWahl();
            startseiteSchliessen();
        }
    });

    nicknameBestätigen.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           if(neuNickname.getText()!=null){
               Spieler.setNickname(neuNickname.getText());
           }
        }
    });


    }
public void startseiteSchliessen(){
        frame.setVisible(false);
}
}
