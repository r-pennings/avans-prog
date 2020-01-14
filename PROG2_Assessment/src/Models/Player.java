package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Player {

	// Instance Variables
	private int id;
	private StringProperty name;

	private ObservableList<Integer> cards;

	public Player(int id, String name) {
		this.id = id;

		this.name = new SimpleStringProperty();
		this.name.set(name);

		cards = FXCollections.observableArrayList();
	}

	/*
	 * Player Name Property
	 */
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}

	/*
	 * Player Cards Property
	 */
	public ObservableList<Integer> getCards() {
		return cards;
	}

	public void setCards(ObservableList<Integer> cards) {
		for (int cardId : cards) {
			cards.add(cardId);
		}
	}

	public ObservableList<Integer> cardsProperty() {
		return cards;
	}

	/*
	 * Getters
	 */
	public int getId() {
		return id;
	}

	/*
	 * Public Methods
	 */
	public void addCard(int card) {
		cards.add(card);
	}
}
