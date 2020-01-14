import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	final static Color AVANSROOD = Color.rgb(198, 0, 42);
	
	private static final int SCENEWIDTH = 400;
	private static final int SCENEHEIGHT = 400;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		OneButtonPane pane = new OneButtonPane();		
		Scene scene = new Scene(pane, SCENEWIDTH, SCENEHEIGHT, Color.LIGHTGRAY);
		stage.setScene(scene);
		
		stage.setTitle("PROG3 PR4b zilver");
		
		stage.show();
	}

}
