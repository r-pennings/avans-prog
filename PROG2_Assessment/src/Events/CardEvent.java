package Events;

import Controllers.Main;
import Models.Card;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class CardEvent {

	// ROTATE_DURATION = 250ms, because it turns twice. So 2 x 250ms = 500ms
	private static final Duration ROTATE_DURATION = Duration.millis(250);
	private static final Duration SCALE_DURATION = Duration.millis(500);

	public static void turn(Card card, boolean reverse, EventHandler<ActionEvent> event) {
		RotateTransition rt = new RotateTransition(ROTATE_DURATION, card.getImage());

		// If reverse turn negative degrees
		if (reverse)
			rt.setByAngle(-90);
		else
			rt.setByAngle(90);

		rt.setAxis(Rotate.Y_AXIS);
		rt.setOnFinished((e) -> {
			if (Main.isCheatMode || card.isCardShown())
				card.getImage().setImage(new Image(Card.getImagePath(card.getId())));
			else
				card.getImage().setImage(new Image(Card.getImagePath(Card.DEFAULT)));

			rt.setOnFinished(event);
			rt.play();
		});

		rt.play();
	}

	public static void dissolve(Card card) {
		ScaleTransition st = new ScaleTransition(SCALE_DURATION, card.getImage());
		st.setByX(-1);
		st.setByY(-1);
		st.play();
	}
}
