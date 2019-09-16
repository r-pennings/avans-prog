
public class Hand {

	Die[] dice = new Die[6];

	void addDie(int sides) {
		for (int i = 0; i < dice.length; i++) {
			if (dice[i] == null) {
				dice[i] = new Die();
				dice[i].setNumberOfSides(sides);
				break;
			}
		}
	}

	void empty() {
		for (int i = 0; i < dice.length; i++)
			dice[i] = null;
	}

	void throwDice() {
		System.out.println("*** Throw ***");
		for (Die die : dice) {
			if (die != null)
				die.throwDie();
		}
	}

	void showThrow() {
		for (Die die : dice) {
			if (die != null) {
				System.out.println("Die: D" + die.getNumberOfSides() + " Result: " + die.getThrow());
			}
		}
		
		System.out.println("Total: " + total() + " Average: " + average());
	}
	
	private int total() {
		int total = 0;

		for (Die die : dice) {
			if (die != null)
				total += die.getThrow();
		}

		return total;
	}

	private float average() {
		float total = 0;
		float amount = 0;

		for (Die die : dice) {
			if (die != null) {
				total += die.getThrow();
				amount++;
			}
		}
		
		float avg = (total/amount);
		return avg;
	}
}
