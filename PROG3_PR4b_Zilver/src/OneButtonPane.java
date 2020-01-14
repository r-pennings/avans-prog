import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

public class OneButtonPane extends BorderPane {

	private Button myButton;

	private String[] strings;
	private int selectedIndex;

	public OneButtonPane() {
		strings = new String[] { "Een woordje", "Een ander woordje", "Een kindje", "Een boompje" };

		initializeBackground();

		myButton = new Button();
		myButton.setOnMouseClicked(e -> clicked());
		myButton.setPrefSize(200, 100);
		myButton.setText("Start");
		myButton.setFont(new Font(20));
		setCenter(myButton);

	}

	public void clicked() {
		myButton.setText(strings[selectedIndex]);

		selectedIndex++;

		if (selectedIndex >= strings.length) {
			selectedIndex = 0;
		}
	}

	private void initializeBackground() {
		Stop[] stops = new Stop[] { new Stop(0, Main.AVANSROOD), new Stop(1, Color.BLUE) };
		LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
		setBackground(new Background(new BackgroundFill(lg1, null, new Insets(25))));
	}
}
