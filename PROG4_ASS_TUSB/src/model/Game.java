package model;

import java.util.ArrayList;

import controller.MainController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;
import javafx.geometry.Point2D;
/**
 * @author Bob van der Putten, Kevin Richter, Ger Saris
 * @version 3.0
 * @date 26-05-2019
 * 
 *       DEZE UITWERKING NOOIT DELEN MET STUDENTEN
 */
public class Game extends Task<Void> /*extends Observable<Game> implements Runnable*/ {

    private MainController mainController;

    private double gameSpeed = 1;

    private boolean isPaused = true; // If game is paused
    private boolean isRunning = true; // If thread is running

    private ArrayList<SpaceShip> spaceShips = new ArrayList<>();
    private ArrayList<SpaceShip> removableSpaceships = new ArrayList<>();

    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<Bullet> removableBullets = new ArrayList<>();

    private SpaceShip controllingShip;

	
	// flag to signal "update" to view
	private IntegerProperty changedFlag = new SimpleIntegerProperty(this, "changedFlag");

	public int getchangedFlag() {
		return changedFlag.get();
	}

	public void setchangedFlag(int newVal) {
		changedFlag.set(newVal);
	}

	public IntegerProperty changedFlagProperty() {
		return changedFlag;
	}
    
    
    //constructor
    public Game(MainController mainController) {
        this.mainController = mainController;

        createSpaceShips();
    }

    private void createSpaceShips() {
        spaceShips.add(new AllySpaceShip(new Point2D(200, 452), this));
        spaceShips.add(new AllySpaceShip(new Point2D(100, 300), this));
        spaceShips.add(new EnemySpaceShip(new Point2D(0, 0), new Point2D(452, 0), this));
        spaceShips.add(new EnemySpaceShip(new Point2D(300, 0), new Point2D(300, 452), this));
    }

    public void selectShip(SpaceShip spaceShip) {
        if (controllingShip != null) {
            controllingShip.setImage("chaser");
        }

        controllingShip = spaceShip;

        if (controllingShip != null) {
            controllingShip.setImage("chaser_selected");
        }
    }

    public SpaceShip findShip(Point2D point) {
        for (SpaceShip spaceShip : spaceShips) {
            if (!(spaceShip instanceof AllySpaceShip)) continue;

            if (spaceShip.getRectangle().contains(point)) {
                return spaceShip;
            }
        }

        return null;
    }

    public void moveCurrentShip(Point2D point) {
        if (controllingShip == null) return;

        double imageWidth = controllingShip.getImage().getWidth();
        double imageHeight = controllingShip.getImage().getHeight();

        double x = point.getX() - (imageWidth / 2);
        double y = point.getY() - (imageHeight / 2);

        double xPos = Math.min(500 - imageWidth, Math.max(0, x));
        double yPos = Math.min(500 - imageHeight, Math.max(0, y));

        controllingShip.setTarget(new Point2D(xPos, yPos));
    }

    public void togglePaused() {
        isPaused = !isPaused;
    }

    public void reset() {
        gameSpeed = 1;
        isPaused = true;
        controllingShip = null;

        spaceShips.clear();
        removableSpaceships.clear();
        bullets.clear();
        removableBullets.clear();

        createSpaceShips();

		// the flag is just a value to trigger the ChangedListener in the view
		// its implemented as an integer that toggles between 0 and 1
		changedFlag.set((changedFlag.get() + 1) % 2);
    }

    public double getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(double speed) {
        gameSpeed = speed;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public ArrayList<SpaceShip> getSpaceShips() {
        return spaceShips;
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void createBullet(Bullet bullet) {
        bullets.add(bullet);
        mainController.playShoot();
    }

    public void destroyBullet(Bullet bullet) {
        removableBullets.add(bullet);
    }

    public void destroyShip(SpaceShip spaceShip, Bullet bullet) {
        if (
            (bullet.getType() == PlayerType.Ally && spaceShip instanceof EnemySpaceShip) ||
            (bullet.getType() == PlayerType.Enemy && spaceShip instanceof AllySpaceShip)
        ) {
            removableSpaceships.add(spaceShip);
            removableBullets.add(bullet);
            mainController.playExplode();
        }
    }
    
	@Override
	protected Void call() throws InterruptedException {
		myrun();
		return null;
	}
    
    public void myrun() {
        while (isRunning) {
            if (!isPaused) {
                for (SpaceShip spaceShip : spaceShips) {
                    spaceShip.updateLocation(gameSpeed);
                }

                for (Bullet bullet : bullets) {
                    bullet.update(gameSpeed);
                }

                // Remove bullets
                if (!removableBullets.isEmpty()) {
                    bullets.removeAll(removableBullets);
                    removableBullets.clear();
                }

                // Remove spaceships
                if (!removableSpaceships.isEmpty()) {
                    spaceShips.removeAll(removableSpaceships);
                    removableSpaceships.clear();
                }

        		// the flag is just a value to trigger the ChangedListener in the view
        		// its implemented as an integer that toggles between 0 and 1
        		changedFlag.set((changedFlag.get() + 1) % 2);
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
