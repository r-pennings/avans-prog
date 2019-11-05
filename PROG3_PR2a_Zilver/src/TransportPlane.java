
public class TransportPlane extends Airplane {

	private int passengers;
	
	public TransportPlane () {
		this.passengers = 0;
	}
	
	public void board(int amount) {
		this.passengers = amount;
	}
	
	public void showPassengerAmount() {
		System.out.println("This transportplane is currently shipping " + this.passengers + " passengers.");
	}
}
