package brons_zilver;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

public class ControlPane extends BorderPane {

	private DrawPane drawPane;
	private VBox sliderPane;

	public static final int WIDTH = 120;
	public static final int SLIDERHEIGHT = 200;

	private boolean useButtons = true;

	public ControlPane(DrawPane drawPane) {
		this.drawPane = drawPane;

		this.setPrefSize(WIDTH, Main.HEIGHT);

		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

		ButtonPane buttons = new ButtonPane(this);
		ListViewPane listView = new ListViewPane(this);

		if (useButtons) {
			this.setTop(buttons);
		} else {
			this.setTop(listView);
		}

		createSliderPane();
		this.setBottom(sliderPane);

	}
	
	private void createSliderPane() {
		sliderPane = new VBox();
		sliderPane
				.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		sliderPane.setPrefHeight(SLIDERHEIGHT);
		sliderPane.setAlignment(Pos.CENTER);

		Slider slider = new Slider(0.5, 1.5, 1);
		slider.setOrientation(Orientation.VERTICAL);
		slider.setMajorTickUnit(1);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
//		slider.setMinorTickCount(1);

		slider.setLabelFormatter(new StringConverter<Double>() {
			@Override
			public String toString(Double object) {
				if (object < 1) {
					return "-50%";
				} else if (object > 1) {
					return "+50%";
				} else {
					return "0";
				}
			}

			@Override
			public Double fromString(String string) {
				return null;
			}
		});

		slider.valueProperty().addListener(new MySliderListener(drawPane));

		sliderPane.getChildren().add(slider);
	}

	public void setColor(String value) {
		try {
			drawPane.setColor(Color.valueOf(value));
		} catch (Exception e) {
			drawPane.setColor(Color.WHITE);
		}
	}
}
