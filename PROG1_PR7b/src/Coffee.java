
public class Coffee {

	private String name;
	private int size;

	public Coffee(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}

	public String getSize() {
		String covertedSize = "";

		switch (size) {
		case 1:
			covertedSize = "Klein";
			break;

		case 2:
			covertedSize = "Middel";
			break;

		case 3:
			covertedSize = "Groot";
			break;

		default:
			covertedSize = "Kan grootte niet bepalen.";
			break;
		}

		return covertedSize;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
