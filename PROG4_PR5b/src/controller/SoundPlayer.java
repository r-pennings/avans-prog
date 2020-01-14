package controller;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {
	// instance variables
	private final String soundfile = "flap.wav";
	private Clip clip;

	public void playFlap() {
		playSound(soundfile, true);
	}

	public void stopFlap() {
		clip.stop();
	}

	private Clip playSound(String soundFile, boolean shouldLoop) {
		clip = null;
		try {
			URL sound = getClass().getResource("/sounds/" + soundFile);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sound);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			if (shouldLoop) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				clip.start();
			}
		} catch (Exception e) {
			System.err.print("Sound file open error\n " + e.getMessage());
		}
		return clip;
	}

}
