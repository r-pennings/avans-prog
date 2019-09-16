
public class Tea {
	private String name;
	private boolean hasSugar = false;
	private boolean hasMilk = false;

	void setName(String newName) {
		name = newName;
	}

	String getName() {
		return name;
	}

	void setMilk(boolean yesPlease) {
		hasMilk = yesPlease;
	}

	boolean getMilk() {
		return hasMilk;
	}

	void setSugar(boolean yesPlease) {
		hasSugar = yesPlease;
	}

	boolean getSugar() {
		return hasSugar;
	}

}
