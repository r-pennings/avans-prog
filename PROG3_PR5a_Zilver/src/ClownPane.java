import java.util.ArrayList;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class ClownPane extends EmptyPane {

	public ClownPane() {
		super();

		setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

		createClown();
	}

	private void createClown() {
		// HEAD
		Ellipse head = new Ellipse(100, 100, 60, 70);
		head.setFill(Color.WHITE);

		this.getChildren().add(head);

		// HAIR
		int hairSize = 20;
		int hairRow1 = 55;
		int hairRow2 = 45;
		int hairRow3 = 35;

		ArrayList<Circle> hairCircles = new ArrayList<Circle>();

		for (int i = 0; i < 5; i++) {
			Circle hair = new Circle(50 + (25 * i), hairRow1, hairSize);
			hair.setFill(Color.ORANGE);
			hairCircles.add(hair);
		}

		for (int i = 0; i < 4; i++) {
			Circle hair = new Circle(62.5 + (25 * i), hairRow2, hairSize);
			hair.setFill(Color.ORANGE);
			hairCircles.add(hair);
		}

		for (int i = 0; i < 3; i++) {
			Circle hair = new Circle(75 + (25 * i), hairRow3, hairSize);
			hair.setFill(Color.ORANGE);
			hairCircles.add(hair);
		}

		this.getChildren().addAll(hairCircles);

		// NOSE
		Circle nose = new Circle(100, 100, 20);
		nose.setFill(Color.RED);

		this.getChildren().add(nose);

		// MOUTH
		Circle mouth1 = new Circle(80, 140, 12.5);
		mouth1.setFill(Color.RED);
		this.getChildren().add(mouth1);

		Circle mouth2 = new Circle(120, 140, 12.5);
		mouth2.setFill(Color.RED);
		this.getChildren().add(mouth2);
	}
}
