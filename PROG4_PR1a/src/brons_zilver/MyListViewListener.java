package brons_zilver;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

class MyListViewListener implements ChangeListener<String> {

	private ControlPane controlPane;

	public MyListViewListener(ControlPane controlPane) {
		this.controlPane = controlPane;
	}

	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		controlPane.setColor(newValue);
	}
}
