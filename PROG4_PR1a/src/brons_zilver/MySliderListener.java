package brons_zilver;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MySliderListener implements ChangeListener<Number> {

	private DrawPane drawPane;

	public MySliderListener(DrawPane drawPane) {
		this.drawPane = drawPane;
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		drawPane.setScaling(newValue.doubleValue());
	}
}
