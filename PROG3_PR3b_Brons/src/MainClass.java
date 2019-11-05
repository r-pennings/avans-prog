import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		List<String> list = fh.readSmallTextFile("files\\flatInfo.txt");

		Flat flat1 = new Flat();

		for (String item : list) {
			Apartment apartment = new Apartment(Integer.parseInt(item));
			flat1.addApartment(apartment);
		}
		
		flat1.drawFlat();
	}

}
