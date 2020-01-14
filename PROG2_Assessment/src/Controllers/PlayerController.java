package Controllers;

import java.util.Random;

import Models.Player;
import Views.PlayerPane;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerController {

	// Variables
	private ObservableList<Player> players;
	private IntegerProperty currentPlayer;
	private PlayerPane playerPane;

	// Constructor
	public PlayerController() {
		// Initialise variables
		players = FXCollections.observableArrayList(new Player(0, "Player 1"), new Player(1, "Player 2"));
		currentPlayer = new SimpleIntegerProperty();
		playerPane = new PlayerPane(this);

		// Set Current Player by Random Integer
		currentPlayer.set(new Random().nextInt(2));
		currentPlayer.addListener((obs, oldPlayer, newPlayer) -> playerPane.setCurrentPlayer(newPlayer.intValue()));

		Platform.runLater(() -> playerPane.setCurrentPlayer(currentPlayer.get()));

		// Bind Player Cards
		for (Player player : players) {
			player.cardsProperty().addListener(playerPane.playerCardsListener(player));
		}

		players.addListener(playerPane.playersListener());
	}

	/*
	 * Players Property
	 */
	public ObservableList<Player> playersProperty() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players.setAll(players);
	}

	public ObservableList<Player> getPlayers() {
		return players;
	}

	/*
	 * Current Player Property
	 */
	public Player getCurrentPlayer() {
		return players.get(currentPlayer.get());
	}

	public void setCurrentPlayer(int player) {
		this.currentPlayer.set(player);
	}

	public IntegerProperty currentPlayerProperty() {
		return currentPlayer;
	}

	/*
	 * Getters
	 */
	public PlayerPane getPane() {
		return playerPane;
	}

	public Player getPlayerOne() {
		return players.get(0);
	}

	public Player getPlayerTwo() {
		return players.get(1);
	}

	/*
	 * Setters
	 */
	public void resetPane() {
		playerPane = new PlayerPane(this);
	}

	public void setPlayerOne(Player player) {
		players.set(0, player);
	}

	public void setPlayerTwo(Player player) {
		players.set(1, player);
	}

	/*
	 * Public Methods
	 */
	public void addCardToCurrentPlayer(int cardId) {
		players.get(currentPlayer.get()).addCard(cardId);
	}

	public void updateCurrentPlayer() {
		if (currentPlayer.get() == players.get(0).getId())
			currentPlayer.set(players.get(1).getId());
		else
			currentPlayer.set(players.get(0).getId());
	}
}
