package Models;

import Controllers.CardController;
import Controllers.Main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Card {

	// Constants
	public static final String DEFAULT = "reverse";

	// Card Size Constants
	public static final int CARD_SIZE = 100;
	public static final int CARD_SM_SIZE = 25;

	// Instance Variables
	private CardController controller;
	private int id;
	private ImageView imageView;

	private boolean isCardShown;
	private boolean isCardHidden;

	// Constuctor
	public Card(CardController cardController, int id) {
		this.controller = cardController;
		this.id = id;

		isCardShown = false;
		isCardHidden = false;

		if (Main.isCheatMode)
			imageView = new ImageView(getImagePath(this.id));
		else
			imageView = new ImageView(getImagePath(DEFAULT));

		imageView.setFitHeight(CARD_SIZE);
		imageView.setFitWidth(CARD_SIZE);
		imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> controller.turn());
	}

	/*
	 * Getters
	 */
	public int getId() {
		return id;
	}

	public ImageView getImage() {
		return imageView;
	}

	public boolean isCardShown() {
		return isCardShown;
	}

	public boolean isCardHidden() {
		return isCardHidden;
	}

	/*
	 * Setters
	 */
	public void setIsCardShown(boolean isCardShown) {
		this.isCardShown = isCardShown;
	}

	public void setIsCardHidden(boolean isCardHidden) {
		this.isCardHidden = isCardHidden;
	}

	/*
	 * Static Methods
	 */
	public static String getImagePath(int cardId) {
		String path = "image";

		// Add prefix zero if card id is below 10
		if (cardId < 10)
			path += "0";

		path += cardId;

		return Card.class.getResource("/images/" + path + ".jpg").toString();
	}

	public static String getImagePath(String image) {
		return Card.class.getResource("/images/" + image + ".jpg").toString();
	}
}
