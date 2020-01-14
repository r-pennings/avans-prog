import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static final int MAINWIDTH = 750;
	public static final int MAINHEIGHT = 400;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane pane = new BorderPane();
		TimerScene scene = new TimerScene(pane, MAINWIDTH, MAINHEIGHT);
		
		stage.setScene(scene);
		
		stage.setWidth(MAINWIDTH);
		stage.setHeight(MAINHEIGHT);
		stage.setResizable(false);
		
		stage.show();
	}

}
