import java.util.ArrayList;

public class Airport {

	private ArrayList<Airplane> planes;

	public Airport() {
		planes = new ArrayList<Airplane>();
	}

	public void addPlane(Airplane ap) {
		planes.add(ap);
	}

	public Airplane getPlane(int index) {
		return planes.get(index) != null ? planes.get(index) : null;
	}

	public void showAllContents() {
		for (Airplane plane : planes) {
			if (plane instanceof CargoPlane) {
				((CargoPlane) plane).showCargo();
			} else if (plane instanceof TransportPlane) {
				((TransportPlane) plane).showPassengerAmount();
			} else {
				System.out.println("This plane is not recognized!");
			}
		}
	}
}
