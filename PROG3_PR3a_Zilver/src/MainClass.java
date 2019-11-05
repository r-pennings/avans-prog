import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		List<String> list = fh.readSmallTextFile("files\\flatInfo.txt");

		int amountOfApartments = Integer.parseInt(list.get(0));

		Flat flat1 = new Flat(amountOfApartments);

		flat1.drawFlat();
	}

}
