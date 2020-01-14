package controller;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public class SoundPlayer {

    // instance variables
    private final String explodeFile = "explode.wav";
    private final String shootFile = "shoot.wav";

    public void playExplode() {
        playSound(explodeFile);
    }

    public void playShoot() {
        playSound(shootFile);
    }

    private void playSound(String soundFile) {
        try {
            URL sound = getClass().getResource("/sounds/" + soundFile);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sound);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
