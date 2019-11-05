import java.util.ArrayList;

public class Flat {

	private ArrayList<Apartment> apartments;

	public Flat() {
		apartments = new ArrayList<Apartment>();
	}

	public void drawFlat() {
		System.out.println("/---\\");

		for (Apartment ap : apartments) {
			System.out.println("|_" + ap.getNumber() + "_|");
		}
	}

	public void addApartment(Apartment a) {
		apartments.add(a);
	}
}
