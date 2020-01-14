package Controllers;

import java.util.ArrayList;
import java.util.Collections;

import Events.CardEvent;
import Models.Card;
import Models.MemoryFile;
import Views.EndGameAlert;
import Views.FieldPane;
import Views.MainScene;
import javafx.application.Platform;
import javafx.stage.Stage;

public class GameController {

	// Constants
	private static final int NUM_OF_CARDS = 36;
	private static final int NUM_OF_PAIRS = (NUM_OF_CARDS / 2);
	private static final int NUM_OF_PLAYERS = 2;

	// Scene Constants
	private static final int SCENE_WIDTH = 700;
	private static final int SCENE_HEIGHT = 850;
	private static final String SCENE_TITLE = "Memory";

	// Instance Variables
	private Stage stage;
	private FieldPane fieldPane;
	private PlayerController playerController;
	private ArrayList<CardController> playCards;
	private CardController[] selectedCards;

	// Constructor
	public GameController(Stage stage) {
		this.stage = stage;
		this.selectedCards = new CardController[NUM_OF_PLAYERS];
		this.playCards = new ArrayList<>();
	}

	/*
	 * Getters
	 */
	public ArrayList<CardController> getPlayCards() {
		return playCards;
	}

	public Stage getStage() {
		return stage;
	}

	public FieldPane getFieldPane() {
		return fieldPane;
	}

	public PlayerController getPlayerController() {
		return playerController;
	}

	public CardController getFirstCard() {
		return selectedCards[0];
	}

	public CardController getSecondCard() {
		return selectedCards[1];
	}

	/*
	 * Setters
	 */
	public void setFirstCard(CardController card) {
		selectedCards[0] = card;
	}

	public void setSecondCard(CardController card) {
		selectedCards[1] = card;
	}

	/*
	 * Public Methods
	 */
	public void initGame() {
		// Initialise controller if null, else initialise it with the old names
		if (this.playerController == null) {
			this.playerController = new PlayerController();
		} else {
			String playerOne = this.playerController.getPlayerOne().getName();
			String playerTwo = this.playerController.getPlayerTwo().getName();

			this.playerController = new PlayerController();

			this.playerController.getPlayerOne().setName(playerOne);
			this.playerController.getPlayerTwo().setName(playerTwo);
		}

		// Initialise Cards
		playCards.clear();
		for (int i = 1; i <= NUM_OF_PAIRS; i++) {
			playCards.add(new CardController(this, i));
			playCards.add(new CardController(this, i));
		}

		Collections.shuffle(playCards);

		// Initialise Field
		fieldPane = new FieldPane(this);
		fieldPane.initField();

		initScene();
	}

	public void initGameByFile(MemoryFile file) {
		// Initialise Cards
		playCards.clear();
		for (int cardId : file.getPlayCards()) {
			if (cardId > 0)
				playCards.add(new CardController(this, cardId));
			else
				playCards.add(null);
		}

		fieldPane.initField();

		// Set Playernames
		playerController.getPlayerOne().setName(file.getPlayerOne());
		playerController.getPlayerTwo().setName(file.getPlayerTwo());

		// Set Cards Player One
		playerController.getPlayerOne().getCards().clear();
		for (int cardId : file.getCardsByPlayerId(playerController.getPlayerOne().getId())) {
			playerController.getPlayerOne().getCards().add(cardId);
		}

		// Set Cards Player Two
		playerController.getPlayerTwo().getCards().clear();
		for (int cardId : file.getCardsByPlayerId(playerController.getPlayerTwo().getId())) {
			playerController.getPlayerTwo().getCards().add(cardId);
		}

		// Set Current Player
		playerController.setCurrentPlayer(file.getCurrentPlayer());
		Platform.runLater(() -> playerController.getPane().setCurrentPlayer(file.getCurrentPlayer()));

		initScene();
	}

	private void initScene() {
		stage.setScene(new MainScene(this, playerController));
		stage.setTitle(SCENE_TITLE);
		stage.setWidth(SCENE_WIDTH);
		stage.setHeight(SCENE_HEIGHT);
		stage.setResizable(false);

		stage.show();
	}

	public void compareCards() {
		// Set local variables for readability
		Card first = selectedCards[0].getCard();
		Card second = selectedCards[1].getCard();

		// If cards are equal, dissolve both cards. Else turn back
		if (first.getId() == second.getId()) {
			playerController.addCardToCurrentPlayer(first.getId());

			first.setIsCardHidden(!first.isCardHidden());
			second.setIsCardHidden(!second.isCardHidden());

			CardEvent.dissolve(first);
			CardEvent.dissolve(second);

			if (isGameFinished())
				EndGameAlert.show(this);
		} else {
			first.setIsCardShown(!first.isCardShown());
			second.setIsCardShown(!second.isCardShown());

			CardEvent.turn(first, true, null);
			CardEvent.turn(second, true, null);

			playerController.updateCurrentPlayer();
		}

		// Reset selected cards
		selectedCards[0] = null;
		selectedCards[1] = null;
	}

	/*
	 * Private Methods
	 */
	private boolean isGameFinished() {
		int playerOneCards = playerController.getPlayerOne().getCards().size();
		int playerTwoCards = playerController.getPlayerTwo().getCards().size();

		if (Main.isCheatMode)
			return (playerOneCards >= 3 || playerTwoCards >= 3);

		return (playerOneCards + playerTwoCards) == NUM_OF_PAIRS;
	}
}
