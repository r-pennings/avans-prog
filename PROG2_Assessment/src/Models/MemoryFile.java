package Models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import Controllers.CardController;
import Controllers.GameController;
import Exceptions.FileNotSelectedException;
import Exceptions.InvalidFileException;
import Views.ExceptionAlert;

public class MemoryFile {

	// Instance Variables
	private int[] playCards;

	private String playerOne;
	private String playerTwo;
	private int currentPlayer;
	private HashMap<Integer, ArrayList<Integer>> playerCards;

	/*
	 * Getters
	 */
	public int[] getPlayCards() {
		return playCards;
	}

	public String getPlayerOne() {
		return playerOne;
	}

	public String getPlayerTwo() {
		return playerTwo;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public ArrayList<Integer> getCardsByPlayerId(int playerId) {
		return playerCards.get(playerId);
	}

	/*
	 * Create New Memory File
	 */
	public void create(GameController gameController, File file) {
		try {
			if (file != null) {
				PrintWriter writer = new PrintWriter(file);

				StringBuilder sb = new StringBuilder();

				// Print Field
				int column = 1;
				for (CardController card : gameController.getPlayCards()) {
					if (card == null || card.getCard().isCardHidden())
						sb.append("-1");
					else
						sb.append(card.getCard().getId());

					if (column < 6) {
						sb.append(" ");
						column++;
					} else {
						sb.append("\n");
						column = 1;
					}
				}

				// Print Player One
				Player playerOne = gameController.getPlayerController().getPlayerOne();
				sb.append(playerOne.getName()).append("\n");

				if (playerOne.getCards().size() > 0) {
					for (int i = 0; i < playerOne.getCards().size(); i++) {
						sb.append(playerOne.getCards().get(i));

						if (i < playerOne.getCards().size()) {
							sb.append(" ");
						}
					}
				}

				sb.append("\n");

				// Print Player Two
				Player playerTwo = gameController.getPlayerController().getPlayerTwo();
				sb.append(playerTwo.getName()).append("\n");

				if (playerTwo.getCards().size() > 0) {
					for (int i = 0; i < playerTwo.getCards().size(); i++) {
						sb.append(playerTwo.getCards().get(i));

						if (i < playerTwo.getCards().size()) {
							sb.append(" ");
						}
					}
				}

				sb.append("\n");

				// Print Current Player
				sb.append(gameController.getPlayerController().getCurrentPlayer().getId());

				writer.print(sb.toString());
				writer.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Read Memory File
	 */
	@SuppressWarnings("resource")
	public void read(GameController gameController, File file) {
		try {
			if (file == null)
				throw new FileNotSelectedException();

			BufferedReader br = new BufferedReader(new FileReader(file));

			String text;
			int i = 0, x = 0;
			playCards = new int[36];
			playerCards = new HashMap<>();

			while ((text = br.readLine()) != null) {

				// Read Cards
				if (i < 6) {
					for (String str : text.split(" ")) {
						if (!isValidString(str) || !isValidCardId(str))
							throw new InvalidFileException();

						playCards[x] = Integer.valueOf(str);
						x++;
					}
				}

				// Read Player One
				if (i == 6) {
					if (!isValidString(text))
						throw new InvalidFileException();

					playerCards.put(0, new ArrayList<>());
					playerOne = text;
				}

				// Read Cards Player One
				if (i == 7 && text.length() > 0) {
					for (String str : text.split(" ")) {
						if (!isValidString(str) || !isValidCardId(str))
							throw new InvalidFileException();

						playerCards.get(0).add(Integer.valueOf(str));

					}
				}

				// Read Player Two
				if (i == 8) {
					if (!isValidString(text))
						throw new InvalidFileException();

					playerCards.put(1, new ArrayList<>());
					playerTwo = text;
				}

				// Read Cards Player Two
				if (i == 9 && text.length() > 0) {
					for (String str : text.split(" ")) {
						if (!isValidString(str) || !isValidCardId(str))
							throw new InvalidFileException();

						playerCards.get(1).add(Integer.valueOf(str));
					}
				}

				// Read Current Player
				if (i == 10) {
					if (!isValidString(text) || !isValidCurrent(text))
						throw new InvalidFileException();

					currentPlayer = Integer.valueOf(text);
				}

				i++;
			}

			gameController.initGameByFile(this);

			br.close();
		} catch (NullPointerException e) {
			FileNotSelectedException.throwAlert();
		} catch (FileNotSelectedException e) {
			FileNotSelectedException.throwAlert();
		} catch (NumberFormatException e) {
			InvalidFileException.throwAlert(file);
		} catch (InvalidFileException e) {
			InvalidFileException.throwAlert(file);
		} catch (Exception e) {
			ExceptionAlert.throwAlert();
		}
	}

	/*
	 * Private Validators
	 */
	private boolean isValidCardId(String id) {
		return (Integer.valueOf(id) == -1) || (Integer.valueOf(id) > 0 && Integer.valueOf(id) <= 18);
	}

	private boolean isValidString(String str) {
		return !str.isEmpty() && !str.isBlank();
	}

	private boolean isValidCurrent(String id) {
		return Integer.valueOf(id) == 0 || Integer.valueOf(id) == 1;
	}
}
