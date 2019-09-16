public class Ship {

	// CONSTANTS
	private static final int CARRIER_SIZE = 5;
	private static final int BATTLESHIP_SIZE = 4;
	private static final int SUBMARINE_SIZE = 3;
	private static final int DESTROYER_SIZE = 3;
	private static final int PATROL_SIZE = 2;

	// VARIABLES
	private ShipType type;
	private int length;
	private int shotCount;

	public Ship(ShipType type) {
		this.type = type;

		this.setLength();
	}

	public int getLength() {
		return length;
	}

	public boolean hasSunk() {
		return shotCount == length;
	}

	public void addShotCount() {
		this.shotCount++;
	}

	public int getShotCount() {
		return shotCount;
	}

	public char getIcon() {
		return Character.toUpperCase(this.getType().charAt(0));
	}

	/**
	 * Converts the given ShipType type to a string
	 * 
	 * @return the type of the ship as a string
	 */
	public String getType() {
		switch (this.type) {
		case CARRIER:
			return "Vliegdekschip";
		case BATTLESHIP:
			return "Slagschip";
		case SUBMARINE:
			return "Onderzeeër";
		case DESTROYER:
			return "Torpedobootjager";
		case PATROL:
			return "Patrouilleboot";
		default:
			return "Undefined";
		}
	}

	/**
	 * Set the length of the ship by the ship type.
	 */
	private void setLength() {
		switch (this.type) {
		case CARRIER:
			this.length = CARRIER_SIZE;
			break;
		case BATTLESHIP:
			this.length = BATTLESHIP_SIZE;
			break;
		case SUBMARINE:
			this.length = SUBMARINE_SIZE;
			break;
		case DESTROYER:
			this.length = DESTROYER_SIZE;
			break;
		case PATROL:
			this.length = PATROL_SIZE;
			break;
		default:
			this.length = 0;
			break;
		}
	}
}
