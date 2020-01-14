import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class EmptyPane extends Pane {

	private int width = 200;
	private int height = 200;
	
	private int x = 50;
	private int y = 50;

	public EmptyPane() {
		super();
		setLayoutX(x);
		setLayoutY(y);
		setPrefSize(width, height);
		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	}

}
