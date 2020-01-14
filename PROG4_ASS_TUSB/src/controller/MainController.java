package controller;

import javafx.stage.Stage;
import model.Game;
import view.GameScene;
import view.SplashScene;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public class MainController {

    // instance variables
    private SoundPlayer soundplayer = new SoundPlayer();
    private Game game;
    private Stage stage;

    //constructor
    public MainController(Stage stage) {
        this.stage = stage;

        stage.setTitle("The Ultimate Space Battle");
        stage.setScene(new SplashScene(this));
    }

    public void startGame() {
        game = new Game(this);
        stage.setScene(new GameScene(game));
    }

    public void exit() {
        if (game != null) {
            game.setRunning(false);
        }
    }

    public void playExplode() {
        soundplayer.playExplode();
    }

    public void playShoot() {
        soundplayer.playShoot();
    }
}
