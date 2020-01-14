package model;

import javafx.geometry.Point2D;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
class EnemySpaceShip extends SpaceShip {

    private Point2D start;
    private Point2D end;

    EnemySpaceShip(Point2D start, Point2D end, Game game) {
        super("target", start, game);

        this.start = start;
        this.end = end;
        target = end;
    }

    @Override
    public void updateLocation(double gameSpeed) {
        super.updateLocation(gameSpeed);

        shootAtEnemies(gameSpeed, PlayerType.Enemy);

        if (location.equals(target)) {
            target = target == start ? end : start;
        }
    }
}
