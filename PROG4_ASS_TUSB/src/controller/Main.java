package controller;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        MainController controller = new MainController(stage);

        stage.setOnCloseRequest(event -> controller.exit());
        stage.show();
    }
}
