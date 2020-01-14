package brons;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application {

	private Message message;

	// constants
	final private String[] messagelist = { "Hallo, dit is het eerste bericht uit de lijst.", "Groetjes" };

	// Constructor
	public Controller() {
		message = new Message();
	}

	public void startup(String[] args) {
		launch(args);
	}

	public void showNextMessage() {
		if (messagelist[0].equals(message.getMessageText())) {
			message.setMessageText(messagelist[1]);
		} else {
			message.setMessageText(messagelist[0]);
		}
	}

	@Override
	public void start(Stage stage) {
		MyScene myscene = new MyScene(this, message);
		stage.setTitle("PROG4 PR2a_brons");
		stage.setScene(myscene);
		stage.show();
	}

}
