
public class RaceCar {
	private String brand;
	private String driver;
	private int maxSpeed;
	private int startPosition;
	private int currentDistance;

	public RaceCar(String brand, String driver, int maxSpeed) {
		this.brand = brand;
		this.driver = driver;
		this.maxSpeed = maxSpeed;
	}
	
	public String getBrand() {
		return brand;
	}

	public String getDriver() {
		return driver;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	public int getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(int currentDistance) {
		this.currentDistance = currentDistance;
	}

}
