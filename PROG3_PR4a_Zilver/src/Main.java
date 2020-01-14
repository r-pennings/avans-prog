import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	private static final double SCREENWIDTH = Screen.getPrimary().getBounds().getWidth();
	private static final double SCREENHEIGHT = Screen.getPrimary().getBounds().getHeight();
	
	// As required at question 5
	private static final Color AVANSRED = Color.rgb(198, 0, 42);
	private static final int STARTWIDTH = 500;
	private static final int STARTHEIGHT = 200;
	
	// As required at question 8
	private static final double QUARTERSCREENWIDTH = (SCREENWIDTH / 4);
	private static final double QUARTERSCREENHEIGHT = (SCREENHEIGHT / 4);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, STARTWIDTH, STARTHEIGHT, AVANSRED);
		stage.setScene(scene);
		
		// As required at question 5
		stage.setTitle("PROG3 PR4a zilver");
		
		// As required at question 6
		// stage.setMaximized(true);
		
		// As required at question 7
		stage.setResizable(false);
		
		// As required at question 8
		stage.setWidth(QUARTERSCREENWIDTH);
		stage.setHeight(QUARTERSCREENHEIGHT);
		
		// As required at question 9
		double centerX = SCREENWIDTH / 2;
		double centerY = SCREENHEIGHT / 2;	
		stage.setX(centerX - (QUARTERSCREENWIDTH / 2));
		stage.setY(centerY - (QUARTERSCREENHEIGHT / 2));

		stage.show();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
