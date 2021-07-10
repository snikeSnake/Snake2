package com.spiel;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Musik {

public Musik() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    File file = new File("Snake/src/com/music.wav");
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    clip.open(audioInputStream);

    clip.start();


}
}
