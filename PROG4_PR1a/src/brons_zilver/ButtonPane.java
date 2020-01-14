package brons_zilver;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ButtonPane extends VBox {

	private static final int yOffset = 5;
	private static final int xOffset = 10;

	private static final Insets insets = new Insets(yOffset, xOffset, yOffset, xOffset);

	private ToggleGroup group;
	private MyMouseListener mouseListener;

	public ButtonPane(ControlPane controlPane) {
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		mouseListener = new MyMouseListener(controlPane);
		group = new ToggleGroup();

		RadioButton btnRed = createRadioButton("Red", true);
		RadioButton btnBlue = createRadioButton("Blue", false);
		RadioButton btnYellow = createRadioButton("Yellow", false);

		this.getChildren().addAll(btnRed, btnBlue, btnYellow);
	}

	private RadioButton createRadioButton(String name, boolean isSelected) {
		RadioButton radioButton = new RadioButton(name);
		radioButton.setToggleGroup(group);
		radioButton.setSelected(isSelected);
		radioButton.setOnMouseClicked(mouseListener);

		VBox.setMargin(radioButton, insets);
		
		return radioButton;
	}
}
