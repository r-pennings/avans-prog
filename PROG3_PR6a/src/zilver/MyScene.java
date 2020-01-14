package zilver;

import java.util.List;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MyScene extends Scene {

	private static final int SCENEHEIGHT = 400;
	private static final int SCENEWIDTH = 380;

	private TextArea textArea;
	private List<String> fontnames;

	public MyScene(Main main, BorderPane pane) {
		super(pane, SCENEWIDTH, SCENEHEIGHT);

		fontnames = Font.getFontNames();

		// TextArea
		textArea = new TextArea();
		textArea.setWrapText(true);
		textArea.setText("type here");
		textArea.setFont(new Font("arial", 16));
		textArea.setStyle(" -fx-control-inner-background: beige; -fx-highlight-fill: brown;"
				+ " -fx-highlight-text-fill: white; -fx-text-fill: black;");

		pane.setCenter(textArea);
		pane.setBottom(createButtonPane());
	}

	private FlowPane createButtonPane() {
		FlowPane pane = new FlowPane();
		pane.setPrefHeight(50);
		pane.setHgap(10);
		pane.setPadding(new Insets(5, 6, 5, 6));
		pane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		Button changeFont = createButton("Change Font");
		changeFont.setOnAction(e -> changeFont());
		
		pane.getChildren().add(changeFont);
		pane.getChildren().add(createButton("Open File"));
		pane.getChildren().add(createButton("Save File"));
		pane.getChildren().add(createButton("Clear"));

		return pane;
	}

	private Button createButton(String name) {
		Button button = new Button(name);

		button.setPrefHeight(40);
		button.setPrefWidth(85);

		return button;
	}

	private void changeFont() {
		System.out.println("Change Font");
		Random ran = new Random();
		String fontname = fontnames.get(ran.nextInt(fontnames.size()));
		int fontsize = ran.nextInt(8) + 12;
		textArea.setFont(new Font(fontname, fontsize));
	}

	private void clearArea() {
		textArea.clear();
	}

}
