package zilver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static final int STAGEMINHEIGHT = 200;
	private static final int STAGEMINWIDTH = 400;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {	
		BorderPane pane = new BorderPane();
		Scene scene = new MyScene(this, pane);
		
		stage.setScene(scene);
		
		stage.setMinHeight(STAGEMINHEIGHT);
		stage.setMinWidth(STAGEMINWIDTH);
		
		stage.setTitle("PROG3 PR6a");
		
		stage.show();
	}

}
