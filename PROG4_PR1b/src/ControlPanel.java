import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class ControlPanel extends VBox {

	private int red;
	private int green;
	private int blue;

	private Slider redSlider;
	private Slider greenSlider;
	private Slider blueSlider;

	public ControlPanel() {
		this.setWidth(Main.MAINWIDTH * 0.25);

		red = green = blue = 0;
		
		redSlider = initialiseSlider(redSlider, red);
		greenSlider = initialiseSlider(greenSlider, green);
		blueSlider = initialiseSlider(blueSlider, blue);
		
		setRandomColor();

		Label lblRed = new Label("Red");
		Label lblGreen = new Label("Green");
		Label lblBlue = new Label("Blue");

		this.setAlignment(Pos.TOP_CENTER);

		this.getChildren().addAll(lblRed, redSlider, lblGreen, greenSlider, lblBlue, blueSlider);

	}

	public void setRandomColor() {
		Random rand = new Random();

		red = rand.nextInt(256);
		green = rand.nextInt(256);
		blue = rand.nextInt(256);
		
		redSlider.setValue(red);
		greenSlider.setValue(green);
		blueSlider.setValue(blue);
	}

	private Slider initialiseSlider(Slider slider, int value) {
		slider = new Slider();

		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(25);
		slider.setMinorTickCount(25);

		slider.setMin(0);
		slider.setMax(255);
		slider.setValue(value);

		VBox.setMargin(slider, new Insets(10));

		return slider;
	}
}
