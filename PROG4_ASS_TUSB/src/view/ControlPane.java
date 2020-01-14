package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Game;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
class ControlPane extends VBox {

    private Button playButton;
    private Button resetButton;
    private Slider speedSlider;

    ControlPane(Game game) {
        setPrefHeight(50);
        setPadding(new Insets(10));

        playButton = new Button("Play");
        resetButton = new Button("Reset");

        playButton.prefWidthProperty().bind(widthProperty().divide(2));
        resetButton.prefWidthProperty().bind(widthProperty().divide(2));

        HBox buttonBox = new HBox(playButton, resetButton);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(5));
        buttonBox.prefWidthProperty().bind(widthProperty());

        speedSlider = new Slider(0, 2, 1);
        speedSlider.setMinorTickCount(5);
        speedSlider.setMajorTickUnit(0.5);
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);

        playButton.setOnAction(event -> {
            game.togglePaused();
            setPlayButtonText(game.isPaused());
        });

        resetButton.setOnAction(event -> game.reset());

        speedSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            game.setGameSpeed(newValue.doubleValue());
        });

        game.changedFlagProperty().addListener((observable, oldValue, newValue) ->handle(game));

        getChildren().addAll(buttonBox, speedSlider);
    }

    private void setPlayButtonText(boolean isPaused) {
        playButton.setText(isPaused ? "Play" : "Pause");
    }

//    private class GameListener implements ChangeListener<Game> {
//
//        @Override
//        public void changed(ObservableValue<? extends Game> observable, Game oldValue, Game game) {
//            speedSlider.setValue(game.getGameSpeed());
//            setPlayButtonText(game.isPaused());
//        }
//    }
    
    private void handle(Game game)
    {
    	 speedSlider.setValue(game.getGameSpeed());
         setPlayButtonText(game.isPaused());
    }
}
