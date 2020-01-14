package brons;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Message {

	private StringProperty messagetext = new SimpleStringProperty(this, "messagetext", "empty");

	public Message() {
	}

	public void setMessageText(String newtext) {
		messagetext.set(newtext);
	}

	public String getMessageText() {
		return messagetext.get();
	}

	public final StringProperty messagetextProperty() {
		return messagetext;
	}
}
