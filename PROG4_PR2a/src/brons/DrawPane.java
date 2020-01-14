package brons;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class DrawPane extends BorderPane {

	// constants
	private final int paneWidth = 400;
	private final int paneHeight = 300;
	private final int fontsize = 40;
	private final Font myFont = Font.font("Calibri", FontWeight.BOLD, fontsize);
	private final int border = 20;

	// instance variables
	private Text textfield;
	private Message message;

	// constructor
	public DrawPane(Message message) {
		this.message = message;
		
		setPrefSize(paneWidth, paneHeight);
		
		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		textfield = new Text("unknown");
		textfield.setFont(myFont);
		textfield.setWrappingWidth(paneWidth - border);
		textfield.setTextAlignment(TextAlignment.CENTER);
		textfield.setFill(Color.BLUEVIOLET);
		textfield.textProperty().bind(message.messagetextProperty());

		// shadow effect
		DropShadow myShadow = new DropShadow();
		myShadow.setOffsetY(3.0f);
		myShadow.setColor(Color.color(0.4f, 0.4f, 0.4f));
		
		textfield.setEffect(myShadow);
		setCenter(textfield);
	}
}
