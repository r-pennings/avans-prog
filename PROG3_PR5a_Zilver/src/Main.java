import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	private MyScene[] scenes;
	private int index;
	
	private static final Color AVANSROOD = Color.rgb();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		scenes = new MyScene[2];
		index = 0;
		Pane empty = new EmptyPane();
		Pane clown = new ClownPane();
		scenes[0] = new MyScene(this, empty, AVANSROOD);
		scenes[1] = new MyScene(this, clown, Color.DARKGOLDENROD);
		
		ClownPane clownpane = new ClownPane();
		Scene scene = new Scene(new Pane(clownpane), 300, 300, Color.DARKGOLDENROD);
		stage.setScene(scene);
		
		stage.setTitle("PR5a brons");
		
		stage.show();
	}

}
