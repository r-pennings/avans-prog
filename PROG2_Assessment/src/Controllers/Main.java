package Controllers;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static final boolean isCheatMode = false;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		new GameController(stage).initGame();
	}
}
