package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

class ButtonPane extends HBox {
	// constants
	private final int paneheight = 80;

	// constructor
	public ButtonPane(Controller controller) {
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		setPrefHeight(paneheight);
		setMinHeight(paneheight);
		setMaxHeight(paneheight);
		setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));

		ToggleButton sunsetControl = new ToggleButton("start sunset");
		sunsetControl.setOnAction(event -> {
			if (sunsetControl.isSelected()) {
				sunsetControl.setText("reset sun");
				controller.sunset();
			} else {
				sunsetControl.setText("start sunset");
				controller.reset();
			}
		});

		ToggleButton animationControl = new ToggleButton("animate bird");
		animationControl.setOnAction(event -> {
			if (animationControl.isSelected()) {
				animationControl.setText("stop bird");
				controller.playBird();
			} else {
				animationControl.setText("animate bird");
				controller.stopBird();
			}
		});

		getChildren().addAll(animationControl, sunsetControl);
	}

}
