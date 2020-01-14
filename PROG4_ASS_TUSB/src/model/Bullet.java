package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public class Bullet {

    private Game game;

    private Color color;
    private PlayerType type;

    private final double radius = 10;
    private final double speed = 1;

    private Point2D location;
    private Point2D target;

    Bullet(Game game, PlayerType type, Point2D location, Point2D target) {
        this.game = game;
        this.location = location;
        this.target = target;
        this.color = type == PlayerType.Ally ? Color.LIME : Color.RED;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public Point2D getLocation() {
        return location;
    }

    public PlayerType getType() {
        return type;
    }

    public void update(double gameSpeed) {
        double movement = speed * gameSpeed;

        double distX = target.getX() - location.getX();
        double distY = target.getY() - location.getY();

        double mod = Math.max(Math.abs(distX), Math.abs(distY));

        double movX = Math.min(Math.abs(distX), Math.abs((distX / mod) * movement));
        double movY = Math.min(Math.abs(distY), Math.abs((distY / mod) * movement));

        location = location.add(
                location.getX() > target.getX() ? -movX : movX,
                location.getY() > target.getY() ? -movY : movY
        );

        for (SpaceShip spaceShip : game.getSpaceShips()) {
            if (spaceShip.getRectangle().contains(location)) {
                game.destroyShip(spaceShip, this);
            }
        }

        if (location.equals(target)) {
            game.destroyBullet(this);
        }
    }
}
