package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class BirdSprite extends ImageView {
	private final Rectangle2D[] cellClips;
	private int numCells;
	private final Timeline timeline;
	private final IntegerProperty frameCounter = new SimpleIntegerProperty(0);

	public BirdSprite(Image animationImage, int numCells, Duration frameTime) {
		this.numCells = numCells;

		double cellWidth = 175d;
		double cellHeight = 175d;

		cellClips = new Rectangle2D[numCells];

		cellClips[0] = new Rectangle2D(0, 5, cellWidth, cellHeight);
		cellClips[1] = new Rectangle2D(182, 5, cellWidth, cellHeight);
		cellClips[2] = new Rectangle2D(364, 5, cellWidth, cellHeight);
		cellClips[3] = new Rectangle2D(548, 5, cellWidth, cellHeight);
		cellClips[4] = new Rectangle2D(730, 5, cellWidth, cellHeight);
		cellClips[5] = new Rectangle2D(0, 175, cellWidth, cellHeight);
		cellClips[6] = new Rectangle2D(182, 175, cellWidth, cellHeight);
		cellClips[7] = new Rectangle2D(364, 175, cellWidth, cellHeight);
		cellClips[8] = new Rectangle2D(548, 175, cellWidth, cellHeight);
		cellClips[9] = new Rectangle2D(730, 175, cellWidth, cellHeight);
		cellClips[10] = new Rectangle2D(0, 350, cellWidth, cellHeight);
		cellClips[11] = new Rectangle2D(182, 350, cellWidth, cellHeight);
		cellClips[12] = new Rectangle2D(364, 350, cellWidth, cellHeight);
		cellClips[13] = new Rectangle2D(548, 350, cellWidth, cellHeight);

		setImage(animationImage);
		setViewport(cellClips[0]);

		timeline = new Timeline(new KeyFrame(frameTime, event -> {
			frameCounter.set((frameCounter.get() + 1) % numCells);
			setViewport(cellClips[frameCounter.get()]);
		}));
	}

	public void playOnce() {
		frameCounter.set(0);
		timeline.setCycleCount(numCells);
		timeline.stop();
		timeline.playFromStart();
	}

	public void playContinuously() {
		frameCounter.set(0);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.stop();
		timeline.playFromStart();
	}

	public void stop() {
		frameCounter.set(0);
		setViewport(cellClips[frameCounter.get()]);
		timeline.stop();
	}
}
