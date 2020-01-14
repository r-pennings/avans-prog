package Brons;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		ClownPane clownpane = new ClownPane();
		Scene scene = new Scene(new Pane(clownpane), 300, 300, Color.DARKGOLDENROD);
		stage.setScene(scene);
		
		stage.setTitle("PR5a brons");
		
		stage.show();
	}

}
