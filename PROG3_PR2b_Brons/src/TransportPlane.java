
public class TransportPlane extends Airplane implements Trackable {

	private int passengers;

	public TransportPlane(int x, int y, int h) {
		super(x, y, h);

		this.passengers = 0;
	}

	public void board(int amount) {
		this.passengers = amount;
	}

	public void showPassengerAmount() {
		System.out.println("This transportplane is currently shipping " + this.passengers + " passengers.");
	}

	@Override
	public void showInfoOnRadar() {
		// TODO Auto-generated method stub

	}
}
