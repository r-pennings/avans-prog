package Exceptions;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InvalidFileException extends Exception {

	private static final long serialVersionUID = -2448293821223355663L;

	public InvalidFileException() {
		super();
	}

	public static void throwAlert(File file) {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Read Error");
		alert.setHeaderText(null);
		alert.setContentText(file.getPath() + " is not a valid memory game file");

		alert.show();
	}
}
