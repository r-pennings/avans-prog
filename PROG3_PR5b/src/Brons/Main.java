package Brons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new MyScene(this, new VBox(), Color.GRAY);

		stage.setScene(scene);
		stage.setTitle("PROG3 PR5b");

		stage.show();
	}

}
