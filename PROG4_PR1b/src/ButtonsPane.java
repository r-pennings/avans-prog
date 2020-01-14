import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ButtonsPane extends HBox {

	private static final Color BG_COLOR = Color.ALICEBLUE;
	private static final BackgroundFill BG_FILL = new BackgroundFill(BG_COLOR, CornerRadii.EMPTY, Insets.EMPTY);
	private static final Background BG_BOX = new Background(BG_FILL);

	public ButtonsPane(TimerScene scene) {
		this.setBackground(BG_BOX);

		Label label = new Label("Automatic:");

		ToggleGroup group = new ToggleGroup();

		EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				scene.switchOnOff();
			}
		};

		RadioButton rbOn = initialiseButton("On", group, false, handler);
		RadioButton rbOff = initialiseButton("Off", group, true, handler);

		this.getChildren().addAll(label, rbOn, rbOff);

		HBox.setMargin(label, new Insets(10));
		HBox.setMargin(rbOn, new Insets(10));
		HBox.setMargin(rbOff, new Insets(10));
	}

	private RadioButton initialiseButton(String title, ToggleGroup group, boolean isSelected,
			EventHandler<ActionEvent> handler) {
		RadioButton radio = new RadioButton(title);

		radio.setSelected(isSelected);

		radio.setToggleGroup(group);

		radio.setOnAction(handler);

		return radio;
	}
}
