package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sun
{
	// instance variables
	private int initX;
	private int initY;

	// properties
	private IntegerProperty sunX = new SimpleIntegerProperty(this, "sunX");
	private IntegerProperty sunY = new SimpleIntegerProperty(this, "sunY");

	public int getSunX() {
		return sunX.get();
	}

	public int getSunY() {
		return sunY.get();
	}

	public void setSunX(int newVal) {
		sunX.set(newVal);
	}

	public void setSunY(int newVal) {
		sunY.set(newVal);
	}

	public IntegerProperty sunXProperty() {
		return sunX;
	}
	public IntegerProperty sunYProperty() {
		return sunY;
	}

	// constructor
	public Sun(int x, int y) {
		initX = x;
		initY = y;
		sunX.set(x);
		sunY.set(y);
	}

	public void reset() {
		sunX.set(initX);
		sunY.set(initY);
	}

}
