import java.util.ArrayList;

public class Radar {

	private ArrayList<Trackable> trackables;

	public Radar() {
		trackables = new ArrayList<Trackable>();
	}

	public void addTrackable(Trackable t) {
		trackables.add(t);
	}

	public void showTrackables() {
		for (Trackable trackable : trackables) {
			trackable.showInfoOnRadar();
		}
	}
}
