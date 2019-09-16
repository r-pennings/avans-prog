
public class Guest {
	private String name;
	private Tea tea;
	private Cake cake;

	void setName(String newName) {
		name = newName;
	}

	void giveTea(Tea newTea) {
		tea = newTea;
	}

	void giveCake(Cake newCake) {
		cake = newCake;
	}

	void printInformation() {
		System.out.println("Hello, I am " + name);
		System.out.println("I am having a cup of " + tea.getName() + " with a piece of " + cake.getName() + ".");

		if (!tea.getMilk() && !tea.getSugar()) {
			System.out.println("No milk nor sugar, please.");
		} else if (tea.getMilk() && tea.getSugar()) {
			System.out.println("I’d like both milk and sugar please.");
		} else if (tea.getMilk() || tea.getSugar()) {
			if (tea.getMilk()) {
				System.out.println("I’d like some milk, please.");
			} else if (tea.getSugar()) {
				System.out.println("I’d like some sugar, please.");
			}
		}
		
		System.out.println();
	}
}
