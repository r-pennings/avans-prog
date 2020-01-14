package brons_zilver;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 350;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		BorderPane pane = new BorderPane();
		MyScene scene = new MyScene(pane);

		stage.setScene(scene);
		
		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT);

		stage.setResizable(false);

		stage.show();
	}

}
