import java.util.ArrayList;

public class Main {

	private static final int[] numberCollection = { 1, 3, 4, 1, 5, 2, 3, 6, 6, 6, 4, 1, 2, 6, 2, 3, 1, 2, 1, 5, 5, 1, 1,
			5, 4 };

	private static ArrayList<FoundIntNumber> numberOccurences;

	public static void main(String[] args) {
		numberOccurences = new ArrayList<FoundIntNumber>();

		for (int number : numberCollection) {
			Boolean found = false;
			for (int index = 0; index < numberOccurences.size(); index++) {
				FoundIntNumber nr = numberOccurences.get(index);
				if (nr.getValue() == number) {
					found = true;
					nr.increaseNrCounted();
				}
			}

			if (!found) {
				numberOccurences.add(new FoundIntNumber(number));
			}
		}

		FoundIntNumber currentHighest = getHighestCount();
		System.out.println("The most frequent element is " + currentHighest.getValue() + ". It occurs "
				+ currentHighest.getNrCounted() + " times.");
	}

	private static FoundIntNumber getHighestCount() {
		FoundIntNumber currentHighest = null;
		for (FoundIntNumber nr : numberOccurences) {
			if (currentHighest == null) {
				currentHighest = nr;
			}

			if (currentHighest.getNrCounted() < nr.getNrCounted()) {
				currentHighest = nr;
			}
		}

		return currentHighest;
	}
}
