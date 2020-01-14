package brons_zilver;

import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

public class MyMouseListener implements EventHandler<MouseEvent> {

	private ControlPane controlPane;

	public MyMouseListener(ControlPane controlpane) {
		this.controlPane = controlpane;
	}

	@Override
	public void handle(MouseEvent e) {
		String sender = ((RadioButton) e.getSource()).getText();
		controlPane.setColor(sender);
	}

}
