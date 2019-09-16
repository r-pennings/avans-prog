
public class ArraySort {

	int[] numbers = { 12, 19, -5, 0, -12 };
	int attempt = 1;

	public static void main(String[] args) {
		ArraySort sort = new ArraySort();

		System.out.println("Begin array");
		sort.printArray();

		sort.sortArray();
	}

	void sortArray() {
		boolean correct = true;

		// Compare 1 - 2
		if (numbers[0] > numbers[1]) {
			int first = numbers[0];
			numbers[0] = numbers[1];
			numbers[1] = first;

			correct = false;
		}

		// Compare 2 - 3
		if (attempt <= 3 && numbers[1] > numbers[2]) {
			int first = numbers[1];
			numbers[1] = numbers[2];
			numbers[2] = first;

			correct = false;
		}

		// Compare 3 - 4
		if (attempt <= 2 && numbers[2] > numbers[3]) {
			int first = numbers[2];
			numbers[2] = numbers[3];
			numbers[3] = first;

			correct = false;
		}

		// Compare 4 - 5
		if (attempt <= 1 && numbers[3] > numbers[4]) {
			int first = numbers[3];
			numbers[3] = numbers[4];
			numbers[4] = first;

			correct = false;
		}

		if (!correct) {
			System.out.println("Poging " + attempt);
			attempt++;
			printArray();

			sortArray();
		} else {
			System.out.println("Sorteren klaar!");
			printArray();
		}
	}

	void printArray() {
		System.out.print("| ");
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
			
			if(i < numbers.length - 1) {
				System.out.print(" ");
			}
		}
		
		System.out.print(" |");
		
		System.out.println();
		System.out.println();
	}

}
