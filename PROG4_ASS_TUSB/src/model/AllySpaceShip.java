package model;

import javafx.geometry.Point2D;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
class AllySpaceShip extends SpaceShip {

    AllySpaceShip(Point2D location, Game game) {
        super("chaser", location, game);
    }

    @Override
    public void updateLocation(double gameSpeed) {
        super.updateLocation(gameSpeed);

        shootAtEnemies(gameSpeed, PlayerType.Ally);

        if (location.equals(target)) {
            target = null;
        }
    }
}
