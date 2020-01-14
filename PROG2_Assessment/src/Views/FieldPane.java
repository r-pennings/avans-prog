package Views;

import Controllers.CardController;
import Controllers.GameController;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class FieldPane extends AnchorPane {

	// Constants
	private static final double PANE_PADDING = 15;
	private static final int CARDS_PER_ROW = 6;
	private static final int CARD_GAP = 10;

	// Instance Variables
	private GameController gameController;

	// Constructor
	public FieldPane(GameController gameController) {
		this.gameController = gameController;

		setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
	}

	/*
	 * Public Methods
	 */
	public void initField() {
		getChildren().clear();

		int i = 0;
		for (CardController card : gameController.getPlayCards()) {
			if (card != null) {
				ImageView image = card.getCard().getImage();
				double size = image.getFitWidth();

				// Get grid places
				int column = i % CARDS_PER_ROW;
				int row = i / CARDS_PER_ROW;

				double x = PANE_PADDING + (size * column);
				double y = PANE_PADDING + (size * row);

				// If column > 0, then add it to the x value (including the card gap)
				if (column > 0)
					x += (column * CARD_GAP);

				// If row > 0, then add it to the y value (including the card gap)
				if (row > 0)
					y += (row * CARD_GAP);

				// Add ImageView to AnchorPane
				getChildren().add(image);
				AnchorPane.setLeftAnchor(image, x);
				AnchorPane.setTopAnchor(image, y);
			}

			i++;
		}
	}
}
