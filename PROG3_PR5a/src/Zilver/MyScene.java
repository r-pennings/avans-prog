package Zilver;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MyScene extends Scene {

	private Main main;
	private Button btnSwitch;
	private BorderPane rootnode;
	
	public MyScene(Main main, Pane pane, Color backgroundcolor) {
		super(pane, 400, 300, null);
			
		this.main = main;
		
		btnSwitch = new Button();
		btnSwitch.setText("Show\rClown");
		btnSwitch.setOnAction(e -> clicked());
		
		BorderPane btnPane = new BorderPane();
		btnPane.setCenter(btnSwitch);
		btnPane.setStyle("-fx-background-color: " + toRGBCode(Color.LIGHTBLUE));
		btnPane.setPrefWidth(100);
		
		rootnode = new BorderPane();
		rootnode.setCenter(new Pane(pane));
		rootnode.setRight(btnPane);
		
		rootnode.setBackground(new Background(new BackgroundFill(backgroundcolor, CornerRadii.EMPTY, Insets.EMPTY)));
		
		setRoot(rootnode);
	}

	private void clicked() {
		main.switchScenes();
	}

	private static String toRGBCode( Color color )
    {
        return String.format( "#%02X%02X%02X",
            (int)( color.getRed() * 255 ),
            (int)( color.getGreen() * 255 ),
            (int)( color.getBlue() * 255 ) );
    }
}
