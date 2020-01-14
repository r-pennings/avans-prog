package brons_zilver;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawPane extends BorderPane {

	private static final int WIDTH = 380;
	private static final int HEIGHT = 350;

	private static final int SQUARE = 180;

	private Rectangle square;

	public DrawPane() {
		this.setPrefSize(WIDTH, HEIGHT);

		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		square = new Rectangle();
		square.setWidth(SQUARE);
		square.setHeight(SQUARE);
		square.setFill(Color.RED);
		square.setStroke(Color.BLACK);

		this.setCenter(square);
	}

	public void setColor(Color color) {
		square.setFill(color);
	}

	public void setScaling(double scale	) {
		square.setWidth(SQUARE * scale);
		square.setHeight(SQUARE * scale);
	}
}
