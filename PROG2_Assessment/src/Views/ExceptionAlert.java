package Views;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ExceptionAlert {

	public static void throwAlert() {
		Alert alert = new Alert(AlertType.ERROR);

		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Oops! Something went wrong..\n\nTry this again later.");

		alert.show();
	}
}
