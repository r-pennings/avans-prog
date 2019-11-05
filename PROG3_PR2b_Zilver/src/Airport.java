import java.util.ArrayList;

public class Airport {

	private ArrayList<Airplane> planes;
	private Radar radar;

	public Airport() {
		planes = new ArrayList<Airplane>();
		radar = new Radar();
	}

	public void addPlane(Airplane ap) {
		planes.add(ap);
		if (ap instanceof Trackable) {
			radar.addTrackable((Trackable) ap);
		}

	}

	public Airplane getPlane(int index) {
		return planes.get(index) != null ? planes.get(index) : null;
	}

	public void showAllContents() {
		radar.showTrackables();
		
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
