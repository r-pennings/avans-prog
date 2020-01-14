package view;

import controller.MainController;
import javafx.scene.Scene;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public class SplashScene extends Scene {

    public SplashScene(MainController controller) {
        super(new SplashScreen());

        setOnKeyReleased(event -> controller.startGame());
    }
}
