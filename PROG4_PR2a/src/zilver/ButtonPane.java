package zilver;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ButtonPane extends BorderPane {

	private static final int BTN_WIDTH = 94;
	private static final int BTN_HEIGHT = 94;

	private final String iconlight = "/images/open_file-icon.gif";
	private final String icondark = "/images/open_file-icon_dark.gif";

	private Controller controller;
	private MyScene myscene;
	private DrawPane drawPane;
	private Button button;

	private ImageView imagelight;
	private ImageView imagedark;

	private FileChooser chooser;

	public ButtonPane(Controller controller, MyScene myscene, DrawPane drawPane) {
		this.controller = controller;
		this.myscene = myscene;
		this.drawPane = drawPane;

		setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));

		setPrefHeight(110);
		
		createFileChooser();

		imagelight = new ImageView(getClass().getResource(iconlight).toString());
		imagedark = new ImageView(getClass().getResource(icondark).toString());

		button = new Button("", imagelight);
		button.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
		button.setOnMouseClicked(e -> openPicture());
		button.setOnMousePressed(e -> setDark());
		button.setOnMouseReleased(e -> setLight());

		this.setCenter(button);
	}

	private void createFileChooser() {
		File path = new File("resources/images");
		chooser = new FileChooser();
		chooser.getExtensionFilters().add(new ExtensionFilter("Pictures", "*.jpg; *.gif; *.png"));
		chooser.initialDirectoryProperty().set(path);
	}

	private void openPicture() {
		File file = chooser.showOpenDialog(myscene.getWindow());
		if (file == null)
			return;
		drawPane.openFile(file);
	}

	private void setDark() {
		button.setGraphic(imagedark);
	}

	private void setLight() {
		button.setGraphic(imagelight);
	}
}
