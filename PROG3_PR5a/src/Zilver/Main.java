package Zilver;

import Brons.ClownPane;
import Brons.EmptyPane;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	final static Color AVANSROOD = Color.rgb(198, 0, 42);

	private Stage stage;

	private MyScene[] scenes;
	private int index;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;

		scenes = new MyScene[2];
		index = 0;
		
		Pane empty = new EmptyPane();
		Pane clown = new ClownPane();
		
		scenes[0] = new MyScene(this, empty, AVANSROOD);
		scenes[1] = new MyScene(this, clown, Color.DARKGOLDENROD);
		
		stage.setScene(scenes[index]);
		stage.setTitle("PROG3 PR5a Zilver");
		stage.setResizable(false);
		stage.show();
	}

	public void switchScenes() {
		index = 1 - index;
		stage.setScene(scenes[index]);
	}

}
