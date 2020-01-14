package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FileNotSelectedException extends Exception {

	private static final long serialVersionUID = -3218470264087137912L;

	public FileNotSelectedException() {
		super();
	}

	public static void throwAlert() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("No file selected!");

		alert.show();
	}
}
