
public class Flat {

	private Apartment[] apartments;

	public Flat(int amount) {
		apartments = new Apartment[amount];

		for (int i = 0; i < amount; i++) {
			apartments[i] = new Apartment(i);
		}
	}

	public void drawFlat() {
		System.out.println("/---\\");

		for (int i = this.apartments.length; i > 0; i--) {
			System.out.println("|_" + i + "_|");
		}
	}

	public void addApartment(Apartment a) {

	}
}
