package controller;

import model.Sun;
import view.BirdSprite;
import view.MyScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {
	// constants
	private final int NUM_CELLS_PER_ANIMATION = 14;
	private final Duration FRAME_TIME = Duration.millis(100);

	// instance variables
	private Sun sun;
	private BirdSprite bird;
	private SoundPlayer soundPlayer;
	private Timeline timeline;

	// constructor
	public Controller(Stage stage) {
		sun = new Sun(290, 50);
		soundPlayer = new SoundPlayer();
		Image tilesheetImage = new Image(getClass().getResourceAsStream("/images/PR5b/sprite-bird-animated.png"));
		bird = new BirdSprite(tilesheetImage, NUM_CELLS_PER_ANIMATION, FRAME_TIME);
		MyScene scene = new MyScene(this, sun, bird);
		stage.setScene(scene);
		stage.setTitle("PROG4 PR5b zilver");
		stage.show();
	}

	public void sunset() {
		timeline = new Timeline(new KeyFrame(Duration.millis(30), event -> {
			sun.setSunY(sun.getSunY() + 1);
		}));

		timeline.setCycleCount(350);
		timeline.play();
	}

	public void reset() {
		timeline.stop();
		sun.reset();

	}

	public void playBird() {
		soundPlayer.playFlap();
		bird.playContinuously();

	}

	public void stopBird() {
		soundPlayer.stopFlap();
		bird.stop();
	}
}
