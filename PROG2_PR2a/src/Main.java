import java.util.Scanner;

public class Main {

	private static GridNumber[][] gridnumbers;

	public static void main(String[] args) {
		initGridNumbers();

		while (true) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			sc.nextLine();

			increaseNumberValues();
		}
	}

	private static void initGridNumbers() {
		gridnumbers = new GridNumber[5][5];

		for (int x = 0; x < gridnumbers.length; x++) {
			for (int y = 0; y < gridnumbers[x].length; y++) {
				gridnumbers[x][y] = new GridNumber(x, y);
			}
		}
		
		printGridNumbers();
	}

	private static void increaseNumberValues() {
		for (GridNumber[] numbers : gridnumbers) {
			for (GridNumber number : numbers) {
				if (number.isValidValue()) {
					number.increaseValue();
				} else {
					number.resetValue();
				}
			}
		}
		System.out.println();
		
		printGridNumbers();
	}

	private static void printGridNumbers() {
		for (GridNumber[] numbers : gridnumbers) {
			for (GridNumber number : numbers) {
				number.printValue();
			}
			System.out.println();
		}
	}
}
