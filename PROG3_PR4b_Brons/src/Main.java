import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	final static Color AVANSROOD = Color.rgb(198, 0, 42);
	
	final static int SCENESIZE = 300;
	final static int SQUARESIZE = 200;
	final static Color SQUARECOLOR = Color.WHITE;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {		
		stage.setTitle("PROG3 PR4b Brons");

		// Initialize a square
		int x = (SCENESIZE / 2) - (SQUARESIZE / 2);
		int y = (SCENESIZE / 2) - (SQUARESIZE / 2);
		Rectangle square = new Rectangle(x, y, SQUARESIZE, SQUARESIZE);
		square.setFill(SQUARECOLOR);
		
		// Initialize a pane
		Pane myPane = new Pane();
		myPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(20), new BorderWidths(3))));
		myPane.getChildren().add(square);
		
		// Initialize a scene
		Scene myScene = new Scene(myPane, SCENESIZE, SCENESIZE, AVANSROOD);
		stage.setScene(myScene);

		stage.show();
	}

}
