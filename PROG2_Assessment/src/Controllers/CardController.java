package Controllers;

import Events.CardEvent;
import Models.Card;

public class CardController {

	// Constants
	private static final int TIME_MS = 1000;

	// Instance variables
	private Card card;
	private GameController gameController;

	// Constructor
	public CardController(GameController gameController, int cardId) {
		this.gameController = gameController;
		this.card = new Card(this, cardId);
	}

	/*
	 * Getters
	 */
	public Card getCard() {
		return card;
	}

	/*
	 * Public Methods
	 */
	public void turn() {
		// Only handle if card is not open and not all selectedcards are set
		if (!card.isCardShown() && (gameController.getFirstCard() == null || gameController.getSecondCard() == null)) {
			card.setIsCardShown(!card.isCardShown());

			if (gameController.getFirstCard() == null) {
				gameController.setFirstCard(this);
				CardEvent.turn(card, false, null);
			} else if (gameController.getFirstCard() != null && gameController.getSecondCard() == null) {
				gameController.setSecondCard(this);
				CardEvent.turn(card, false, (e) -> waitAndCompare());
			}
		}
	}

	/*
	 * Private Methods
	 */
	private void waitAndCompare() {
		try {
			Thread.sleep(TIME_MS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		gameController.compareCards();
	}
}
