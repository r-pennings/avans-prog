package view;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Bullet;
import model.Game;
import model.SpaceShip;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
class GamePane extends Pane {

    private final int width = 500;
    private final int height = 500;

    private Game game;

    private Canvas canvas;

    GamePane(Game game) {
        this.game = game;

        canvas = new Canvas(width, height);

        setMinSize(width, height);
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        game.changedFlagProperty().addListener((observable, oldValue, newValue) -> drawAll());

        canvas.setOnMouseClicked(event -> {
            if (game.isPaused()) return;

            switch (event.getButton()) {
                case PRIMARY:
                    interactWithShips(new Point2D(event.getX(), event.getY()));
                    break;
                case SECONDARY:
                    game.selectShip(null);
                    break;
                default:
                    break;
            }
        });

        getChildren().add(canvas);
        drawAll();
    }

    private void drawBullet(Bullet bullet, GraphicsContext gc) {
        double radius = bullet.getRadius();
        Point2D location = bullet.getLocation();

        gc.setFill(bullet.getColor());
        gc.fillOval(location.getX() - (radius / 2), location.getY() - (radius / 2), radius, radius);
    }

    private void drawSpaceShip(SpaceShip spaceShip, GraphicsContext gc) {
        Point2D location = spaceShip.getLocation();

        gc.drawImage(spaceShip.getImage(), location.getX(), location.getY());
    }

    private void interactWithShips(Point2D point) {
        SpaceShip ship = game.findShip(point);

        if (ship == null) { // Move ship
            game.moveCurrentShip(point);
        } else { // Select ship
            game.selectShip(ship);
        }
    }

    private void drawAll() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.clearRect(0, 0, width, height);

        for (SpaceShip spaceShip : game.getSpaceShips()) {
            drawSpaceShip(spaceShip, graphicsContext);
        }

        for (Bullet bullet : game.getBullets()) {
            drawBullet(bullet, graphicsContext);
        }
    }
}
