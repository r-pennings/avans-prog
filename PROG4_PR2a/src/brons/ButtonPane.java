package brons;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class ButtonPane extends BorderPane {

	private static final String BTN_TEXT = "Next";
	private static final int BTN_WIDTH = 94;
	private static final int BTN_HEIGHT = 94;
	
	private Controller controller;
	
	public ButtonPane(Controller controller) {
		this.controller = controller;
		
		setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
		
		this.setPrefHeight(110);

		Button btn = new Button(BTN_TEXT);
		btn.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
		btn.setOnMouseClicked(e -> showNextMessage());

		this.setCenter(btn);
	}

	private void showNextMessage() {
		controller.showNextMessage();
	}

}
