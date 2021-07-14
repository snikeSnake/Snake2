package com.spiel;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Musik {

public Musik() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    //soielt die Musik
    File file = new File("Snake/src/com/music.wav");//speichert Speicherort
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);// ruft Musikdatei auf
    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);
    clip.loop(Clip.LOOP_CONTINUOUSLY);// Datei im Loop
    clip.start();//spielt Musik ab
}
}
