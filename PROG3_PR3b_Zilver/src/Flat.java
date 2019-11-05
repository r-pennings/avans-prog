import java.util.ArrayList;
import java.util.List;

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
	
	public void saveFlat(List<String> list) {
		List<String> newList = new ArrayList<String>();
		
		newList.add("/---\\");
		for(String item : list) {
			newList.add("|_" + item + "_|");
		}
		
		FileHandler fh = new FileHandler();
		fh.writeSmallTextFile(newList, "files\\flatOutput.txt");
	}
}
