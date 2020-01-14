package Views;

import Controllers.GameController;
import Models.Player;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class EndGameAlert {

	// Instance Variables
	private static Player winner, loser;

	public static void show(GameController gameController) {
		// Check which player has won the game and which has lost it
		Player playerOne = gameController.getPlayerController().getPlayerOne();
		Player playerTwo = gameController.getPlayerController().getPlayerTwo();

		if (playerOne.getCards().size() > playerTwo.getCards().size()) {
			winner = playerOne;
			loser = playerTwo;
		} else if (playerOne.getCards().size() < playerTwo.getCards().size()) {
			winner = playerTwo;
			loser = playerOne;
		} else {
			winner = loser = null;
		}

		// Initialise Alert
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("Game Over");
		alert.setHeaderText(null);

		String prefix = "";
		if (winner == null && loser == null) {
			prefix = "It's a draw!";
		} else {
			prefix = winner.getName() + " wins with " + winner.getCards().size() + "-" + loser.getCards().size();
		}

		alert.setContentText(prefix + "\n\nAnother game?");

		ButtonType btnYes = new ButtonType("Yes");
		ButtonType btnNo = new ButtonType("No");
		alert.getButtonTypes().setAll(btnYes, btnNo);

		alert.setOnHidden((event) -> {
			ButtonType result = alert.getResult();

			if (result.equals(btnYes)) {
				gameController.initGame();
			} else {
				Alert alertClose = new Alert(AlertType.NONE);
				alertClose.setTitle("Thank you for playing!");
				alertClose.setHeaderText(null);
				alertClose.setContentText("Thank you for playing! See you next time.");
				alertClose.getButtonTypes().setAll(ButtonType.OK);
				alertClose.setOnHidden((e) -> Platform.exit());
				alertClose.show();
			}
		});

		alert.show();
	}
}
