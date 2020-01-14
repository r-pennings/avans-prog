package Brons;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyPane extends BorderPane {

	public Label label;
	
	public static final int PANEWIDTH = 100;
	public static final int PANEHEIGHT = 100;

	public MyPane(Color backgroundcolor, String labeltext) {
		super();
		
		setPrefSize(PANEWIDTH, PANEHEIGHT);
		setBackground(new Background(new BackgroundFill(backgroundcolor, CornerRadii.EMPTY, Insets.EMPTY)));
		
		label = new Label(labeltext);
		label.setFont(new Font("Consolas", 18));
		this.setCenter(label);
	}
}
