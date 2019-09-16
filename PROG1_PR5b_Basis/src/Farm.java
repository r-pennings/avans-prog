
public class Farm {
	private Cow[] cows;
	private Cow[] agedCows;

	void initFarm() {
		cows = new Cow[3];

		Cow cow = new Cow();
		cow.name = "Clara";
		cow.age = 3;
		cow.price = 132.00;
		cow.hasMilk = true;

		cows[0] = cow;
		cows[1] = cow;
		cows[1].name = "Hendrika";

	}

	void print() {
		if (cows != null) {
			for (Cow cow : cows) {
				if (cow != null) {
					cow.print();
				}
			}
		}

		if (agedCows != null) {
			for (Cow agedCow : agedCows) {
				if (agedCow != null) {
					agedCow.print();
				}
			}
		}
	}

	void farming(int nrOfYears) {
		for (int i = 0; i < nrOfYears; i++) {
			for (int x = 0; x < cows.length; x++) {
				Cow cow = cows[x];
				if (cow != null) {
					cow.aging();
					System.out.println("Cow " + cow.name + " is aging... She is now " + cow.age + " years old!");

					if (cow.age > 16) {
						System.out.println("Oh nooo!! Cow " + cow.name + " is going to the butcher...");
						cows[x] = null;
					}
				}
			}

			System.out.println();
			System.out.println("A year has passed...");
			System.out.println();
		}
	}
}
