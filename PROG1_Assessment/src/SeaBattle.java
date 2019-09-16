import java.util.Scanner;

public class SeaBattle {

	// Variables
	private Player[] players;
	private Player currentPlayer;

	/**
	 * Creates the array for players by the players that are given.
	 * 
	 * @param players - An array of players from the type Player
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
		this.currentPlayer = players[0];
	}

	/**
	 * Handles the game and tries to play the game. Loops through the players as
	 * long as a game hasn't finished
	 */
	public void play() {
		while (!currentPlayer.getField().gameIsFinished()) {
			for (Player player : players) {
				if (!currentPlayer.getField().gameIsFinished()) {
					currentPlayer = player;
					printCurrentField();
					guessCoordinate();
				} else {
					break;
				}
			}
		}

		printWinner();

		askForNewGame();
	}

	/**
	 * Asks the player for their wished coordinate. If coordinate incorrect, it
	 * tries again.
	 */
	private void guessCoordinate() {
		System.out.print(currentPlayer.getName() + ", geef de locatie die je wilt beschieten: ");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String coordinate = sc.nextLine();

		if (isValidSquare(coordinate)) {
			Square square = getSquareByCoordinate(coordinate);

			if (!square.isHit()) {
				square.setIsHit();

				if (square.hasShip()) {
					System.out.println("Bravo, je hebt een schip geraakt.");

					Ship ship = square.getShip();
					if (ship.hasSunk()) {
						currentPlayer.getField().addSunkenShip();

						System.out
								.println("Sterker nog, dit schip van het type " + ship.getType() + " is nu gezonken!");
					} else {
						System.out.println();
					}
				} else {
					System.out.println("Helaas, dat was een misser.");
				}
			} else {
				System.out.println("*** Die locatie heb je al eerder beschoten ***");
				guessCoordinate();
			}
		} else {
			if (coordinate.trim().isEmpty()) {
				System.out.println("*** Graag een coordinatie geven alstublieft!");
			} else {
				if (!isValidChar(coordinate.charAt(0))) {
					System.out.println("*** Kolom " + coordinate.charAt(0) + " bestaat niet");
				}

				if (!isValidNr(coordinate.substring(1))) {
					System.out.println("*** Rij " + coordinate.substring(1) + " bestaat niet");
				}
			}

			guessCoordinate();
		}
	}

	/**
	 * Asks if player(s) wants to play a new game of BattleShips.
	 * 
	 * @return an boolean whether the players(s) wants a new game or not
	 */
	private void askForNewGame() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.print("Wil je nog een keer spelen (ja/nee)? ");

			String input = sc.nextLine();

			switch (input.toLowerCase()) {
			case "ja":
				resetGame();
				break;
			case "nee":
				System.out.println("Bedankt voor het spelen van het spelletje Zeeslag.");
				System.out.println("Hopelijk tot een volgende keer!");
				System.exit(0);
			default:
				System.out.println("*** Dat is geen geldig antwoord! ***");
				continue;
			}
		}
	}

	/**
	 * Prints the field of the current player.
	 */
	private void printCurrentField() {
		System.out.println();
		System.out.println("*** Aan de beurt: " + currentPlayer.getName() + " ***");
		System.out.println();
		currentPlayer.printField();
	}

	/**
	 * Prints the currentPlayer, assuming that he is the winner.
	 */
	private void printWinner() {
		if (Main.CHEAT)
			System.out.println("*** Vanwege de cheat mode is het spel nu al afgelopen ***");

		System.out.println(
				"Bravo " + currentPlayer.getName() + ", je hebt alle schepen van je tegenstander tot zinken gebracht!");
		System.out.println("Je bent de trotse winnaar van dit spel!");
	}

	/**
	 * Resets the game, creates new fields for every player and runs the play method
	 * again.
	 */
	private void resetGame() {
		for (Player player : players)
			player.setField(new Field());

		if (players.length > 1) {
			Player playerOne = players[0];
			Player playerTwo = players[1];

			players[0] = playerTwo;
			players[1] = playerOne;
		}

		this.play();
	}

	/**
	 * Returns the square for the given coordinate.
	 * 
	 * @param coordinate - The coordinate the player wants to get.
	 * 
	 * @return the questioned square from the players' input
	 */
	private Square getSquareByCoordinate(String coordinate) {
		return currentPlayer.getField().getSquareByCoordinate(coordinate);
	}

	/**
	 * Checks whether the input character is valid or not. The character has to be a
	 * character between A and J (the field width).
	 * 
	 * @param inputChar - The coordinate character the players' trying to get.
	 * 
	 * @return an boolean whether the character is valid or not
	 */
	private boolean isValidChar(char inputChar) {
		return (inputChar >= 'A' && inputChar <= 'J');
	}

	/**
	 * Checks whether the number is valid or not. The method tries to parse the
	 * string into an Integer. If number is correct, it checks if number is in board
	 * 
	 * @param inputNr - The coordinate number the players' trying to get.
	 * 
	 * @return an boolean whether the number is valid or not
	 */
	private boolean isValidNr(String inputNr) {
		try {
			int input = Integer.parseInt(inputNr);
			return (input >= 1 && input <= Field.SIZE);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
	}

	/**
	 * Checks whether the given input is valid or not. Uses the isValidChar and
	 * isValidNr to check input.
	 * 
	 * @param input - The players' given input
	 * 
	 * @return an boolean whether the questioned coordinate is a valid square or not
	 */
	private boolean isValidSquare(String input) {
		return isValidChar(input.charAt(0)) && isValidNr(input.substring(1));
	}
}
