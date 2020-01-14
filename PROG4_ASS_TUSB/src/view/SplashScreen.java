package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
class SplashScreen extends VBox {

    SplashScreen() {
        setPrefSize(500, 500);
        setPadding(new Insets(20));
        setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

        Label title = new Label("THE ULTIMATE SPACE BATTLE");
        Label action = new Label("Press any key...");

        title.setFont(new Font("Arial", 20));
        action.setFont(new Font("Arial", 16));

        title.setTextFill(Color.WHITE);
        action.setTextFill(Color.WHITE);

        title.setAlignment(Pos.CENTER);
        action.setAlignment(Pos.CENTER);

        title.prefWidthProperty().bind(widthProperty());
        action.prefWidthProperty().bind(widthProperty());

        getChildren().addAll(title, action);
    }
}
