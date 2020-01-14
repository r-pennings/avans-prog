package Views;

import java.util.ArrayList;

import Controllers.PlayerController;
import Models.Card;
import Models.Player;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PlayerPane extends VBox {

	// Constants
	private static final double HGAP = 5.0;
	private static final double VGAP = 0.0;

	// Border Constants
	private static final BorderStrokeStyle BORDER_STYLE = BorderStrokeStyle.SOLID;
	private static final BorderWidths BORDER_WIDTH = new BorderWidths(2.0);

	private static final Border ACTIVE = new Border(new BorderStroke(Color.BLUE, BORDER_STYLE, null, BORDER_WIDTH));
	private static final Border DEFAULT = new Border(
			new BorderStroke(Color.TRANSPARENT, BORDER_STYLE, null, BORDER_WIDTH));

	// Instance Variables
	private ArrayList<FlowPane> flowPanes;
	private ArrayList<HBox> hboxImages;
	private ArrayList<TextField> textFields;

	private PlayerController playerController;

	// Constructor
	public PlayerPane(PlayerController playerController) {
		this.playerController = playerController;

		setPadding(new Insets(10));
		setSpacing(HGAP);

		flowPanes = new ArrayList<>();
		hboxImages = new ArrayList<>();
		textFields = new ArrayList<>();

		for (int i = 0; i < playerController.getPlayers().size(); i++) {
			flowPanes.add(new FlowPane(HGAP, VGAP));
			hboxImages.add(new HBox(HGAP));

			Player player = playerController.getPlayers().get(i);
			textFields.add(new TextField(player.getName()));
			player.nameProperty().bindBidirectional(textFields.get(i).textProperty());

			flowPanes.get(i).getChildren().addAll(textFields.get(i), hboxImages.get(i));
		}

		getChildren().addAll(flowPanes);
	}

	/*
	 * Setters
	 */
	public void setCurrentPlayer(int currentPlayerId) {
		int otherPlayerId = 0;

		if (currentPlayerId == 0)
			otherPlayerId = 1;

		textFields.get(currentPlayerId).setBorder(ACTIVE);
		textFields.get(otherPlayerId).setBorder(DEFAULT);
		textFields.get(currentPlayerId).requestFocus();
	}

	private void setPlayerImages(Player player, HBox hbox) {
		hbox.getChildren().clear();

		for (int cardId : player.getCards()) {
			ImageView image = new ImageView(Card.getImagePath(cardId));
			image.setFitWidth(Card.CARD_SM_SIZE);
			image.setFitHeight(Card.CARD_SM_SIZE);

			hbox.getChildren().add(image);
		}
	}

	/*
	 * Listeners
	 */
	public ListChangeListener<Integer> playerCardsListener(Player player) {
		return (ListChangeListener<Integer>) change -> {
			while (change.next()) {
				setPlayerImages(player, hboxImages.get(player.getId()));
			}
		};
	}

	public ListChangeListener<Player> playersListener() {
		return (ListChangeListener<Player>) change -> {
			while (change.next()) {
				for (Player player : playerController.getPlayers()) {
					textFields.get(player.getId()).textProperty().set(player.getName());
					setPlayerImages(player, hboxImages.get(player.getId()));
				}
			}
		};
	}
}
