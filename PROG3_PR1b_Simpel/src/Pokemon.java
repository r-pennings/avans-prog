import java.util.Random;

public class Pokemon {

	protected String name;
	protected String mainAttack;
	protected String secAttack;
	protected String mainType;

	protected double height;
	protected double weight;

	protected void speak() {
		System.out.println(this.name.toUpperCase() + "!!\n");
	}

	private double damageCalculator() {
		Random rand = new Random();
		double damage = 0;

		damage = rand.nextDouble();

		return damage;
	}

	protected void doMainAttack() {
		System.out.println("Performing " + this.mainAttack);
		if (this.damageCalculator() < 0.75) {
			System.out.println("It's not very effective...");
		} else {
			System.out.println("It's super effective!!!");
		}
		System.out.println();
	}

	protected void doSecAttack() {
		System.out.println("Performing " + this.secAttack);
		if (this.damageCalculator() < 0.5) {
			System.out.println("It's not very effective...");
		} else {
			System.out.println("It's super effective!!!");
		}
		System.out.println();
	}

	protected void showData() {
		int dashes = 20;

		System.out.print("+---" + this.name);

		int restDashes = dashes - 3 - this.name.length();

		for (int i = 0; i < restDashes; i++) {
			System.out.print("-");
		}

		System.out.println("+");

		System.out.println("| Main Attack: " + this.mainAttack);
		System.out.println("| Second Attack: " + this.secAttack);
		System.out.println("| Main Type: " + this.mainType);
		System.out.println("| Height: " + this.height + " m");
		System.out.println("| Weight: " + this.weight + " kg");

		System.out.print("+");
		for (int i = 0; i < dashes; i++) {
			System.out.print("-");
		}

		System.out.println("+");
	}
}
