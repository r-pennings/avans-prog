package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import model.Game;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public class GameScene extends Scene {

    public GameScene(Game game) {
        super(new VBox(new GamePane(game), new ControlPane(game)));

        new Thread(game).start();
    }
}
