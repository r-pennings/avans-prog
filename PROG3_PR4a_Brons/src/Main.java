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
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 400, 300, Color.ALICEBLUE);

		stage.setScene(scene);
		stage.setTitle("PROG3 PR4a Brons");

		stage.show();

		System.out.println("my program has started");
	}

	@Override
	public void stop() throws Exception {
		System.out.println("my program has ended");
		super.stop();
	}
}
