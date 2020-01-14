package zilver;

import java.io.File;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class DrawPane extends BorderPane {

	private final int paneWidth = 400;
	private final int paneHeight = 300;

	private ImageView imageView;

	private boolean grayScale = false;

	public DrawPane() {
		imageView = new ImageView();
		imageView.fitWidthProperty().bind(widthProperty());
		imageView.fitHeightProperty().bind(heightProperty());
		imageView.setPreserveRatio(true);

		StackPane stackPaneWrapper = new StackPane(imageView);
		stackPaneWrapper.prefWidthProperty().bind(widthProperty());
		stackPaneWrapper.prefHeightProperty().bind(heightProperty());

		getChildren().add(stackPaneWrapper);

		setPrefSize(paneWidth, paneHeight);

		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		setCenter(imageView);
	}

	public void openFile(File file) {
		if (file == null)
			return;

		if (!file.exists())
			return;

		imageView.setImage(new Image(file.toURI().toString()));
	}

	public void setGrayScale() {
		this.grayScale = true;

		makeGray();
	}

	public void setFullColor() {
		this.grayScale = false;

		makeGray();
	}

	private void makeGray() {
		ColorAdjust effect = new ColorAdjust();

		if (grayScale) {
			effect.setSaturation(-1);
		}

		imageView.setEffect(effect);
	}

}
