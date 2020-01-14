package zilver;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application {

	// Constructor
	public Controller() {
	
	}

	public void startup(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		MyScene myscene = new MyScene(this);
		
		stage.setTitle("PROG4 PR2a Imageviewer");
		
		stage.setScene(myscene);
		
		stage.show();
	}

}
