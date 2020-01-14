package model;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public abstract class SpaceShip {

	//instance variables
    protected Game game;

    protected Point2D location;
    protected Point2D target;

    protected Image image;

    protected double ticks = 0;

    private final double speed = 2;

    public SpaceShip(String image, Point2D location, Game game) {
        this.location = location;
        this.game = game;

        setImage(image);
    }

    public void updateLocation(double gameSpeed) {
        if (target == null) return;
        if (location.equals(target)) return;

        double movement = speed * gameSpeed;

        // Om afrondingsfouten tegen te gaan. De laatste zet plaatst het schip op precies de eindpositie.
        double movX = Math.min(Math.abs(location.getX() - target.getX()), movement);
        double movY = Math.min(Math.abs(location.getY() - target.getY()), movement);

        location = location.add(
                location.getX() > target.getX() ? -movX : movX,
                location.getY() > target.getY() ? -movY : movY
        );
    }

    void shootAtEnemies(double gameSpeed, PlayerType type) {
        boolean foundShips = false;
        ticks += gameSpeed;

        for (SpaceShip spaceShip : game.getSpaceShips()) {
            if (spaceShip instanceof EnemySpaceShip && type == PlayerType.Enemy) continue;
            if (spaceShip instanceof AllySpaceShip && type == PlayerType.Ally) continue;

            if (location.distance(spaceShip.getLocation()) <= 150) {
                foundShips = true;

                if (Math.floor(ticks) >= 20) {
                    game.createBullet(new Bullet(game, type, getCenter(), spaceShip.getCenter()));
                    ticks = 0;
                }
            }
        }

        if (!foundShips) {
            ticks = 0;
        }
    }

    public Point2D getLocation() {
        return location;
    }

    public void setLocation(Point2D location) {
        this.location = location;
    }

    public Point2D getTarget() {
        return target;
    }

    public void setTarget(Point2D target) {
        this.target = target;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle2D getRectangle() {
        return new Rectangle2D(location.getX(), location.getY(), image.getWidth(), image.getHeight());
    }

    public Point2D getCenter() {
        return new Point2D(location.getX() + (image.getWidth() / 2), location.getY() + (image.getHeight() / 2));
    }

    public void setImage(String image) {
        try {
            this.image = new Image(getClass().getResource("/images/ASS_TUSB/" + image + ".png").toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
