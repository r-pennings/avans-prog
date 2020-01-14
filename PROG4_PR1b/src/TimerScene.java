import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class TimerScene extends Scene {

	private Stop[] stops;
	private LinearGradient gradient;
	private AnimationTimer timer;

	private Color left;
	private Color right;

	private boolean automatic;

	private ControlPanel leftControlPanel;
	private ControlPanel rightControlPanel;

	public TimerScene(BorderPane root, int width, int height) {
		super(root, width, height);

		left = Color.rgb(255, 255, 0);
		right = Color.rgb(100, 255, 80);

		stops = new Stop[] { new Stop(0, left), new Stop(1, right) };
		gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

		leftControlPanel = new ControlPanel();
		rightControlPanel = new ControlPanel();

		Rectangle rect = new Rectangle(Main.MAINWIDTH * 0.5, 100, gradient);

		createTimer();

		ButtonsPane buttons = new ButtonsPane(this);		
		root.setBottom(buttons);
		
		root.setLeft(leftControlPanel);
		root.setCenter(rect);
		root.setRight(rightControlPanel);
	}

	private void createTimer() {
		timer = new AnimationTimerExt(1000) {
			@Override
			public void doAction() {
				leftControlPanel.setRandomColor();
				rightControlPanel.setRandomColor();
			}
		};
	}

	
	public void switchOnOff() {
		automatic = !automatic;

		if (automatic)
			timer.start();
		else
			timer.stop();
	}
}
