package view;

import controller.Controller;
import model.Sun;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MyScene extends Scene {
	// constants
	private double canvasSize = 400;
	private double sunDiameter = 100;

	// instance variables
	private Pane drawPane;
	private BorderPane root;
	private Canvas canvas;
	private Sun sun;
	private BirdSprite bird;
	boolean showmarks = false;

	public MyScene(Controller controller, Sun sun, BirdSprite bird) {
		super(new Pane());
		this.sun = sun;
		this.bird = bird;
		drawPane = new Pane();
		drawPane.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, null, null)));
		drawPainting();

		root = new BorderPane();
		root.setCenter(drawPane);

		root.setBottom(new ButtonPane(controller));
		setRoot(root);

		// LISTENERS
		sun.sunYProperty().addListener((observable, oldValue, newValue) -> drawPainting());

	}

	private void drawPainting() {
		canvas = new Canvas(canvasSize, canvasSize);
		GraphicsContext g = canvas.getGraphicsContext2D();
		drawSun(g);
		drawTree(g);
		drawPane.getChildren().clear();
		drawPane.getChildren().add(canvas);
		addBird();
	}

	private void addBird() {
		drawPane.getChildren().add(bird);
		bird.setX(50);
		bird.setY(150);
	}

	private void drawSun(GraphicsContext g) {
		g.setFill(Color.YELLOW);
		g.fillOval(sun.getSunX(), sun.getSunY(), sunDiameter, sunDiameter);
		if (showmarks) {
			g.setFill(Color.BLACK);
			g.fillRect(sun.getSunX(), sun.getSunY(), 4, 4);
		}
	}

	private void drawTree(GraphicsContext g) {
		// tree
		g.setFill(Color.SADDLEBROWN);
		g.fillRect(290, 350, 21, 50);
		g.setFill(Color.FORESTGREEN);
		g.fillOval(230, 230, 140, 140);
		if (showmarks) {
			g.setFill(Color.BLACK);
			g.fillRect(290, 350, 4, 4);
			g.fillRect(230, 200, 4, 4);
		}
	}

}
