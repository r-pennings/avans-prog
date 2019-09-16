import java.util.*;

public class Race {
	private ArrayList<RaceCar> raceCars;
	private Random randomGen;
	private boolean raceStarted;
	private int distance;

	public Race(int distance) {
		raceCars = new ArrayList<RaceCar>();
		randomGen = new Random();
		this.distance = distance;
	}

	public void addRaceCar(RaceCar raceCar) {
		raceCars.add(raceCar);
	}

	public void runRace() {
		int pos = 1;

		for (RaceCar car : raceCars) {
			car.setStartPosition(pos);

			pos++;
		}

		raceStarted = true;

		System.out.println("Aaaaaand the race has started!");
		System.out.println();

		while (raceStarted) {
			for (int i = 0; i < raceCars.size(); i++) {
				RaceCar car = raceCars.get(i);

				int newDistance = car.getCurrentDistance() + (randomGen.nextInt(car.getMaxSpeed()) + 1);
				car.setCurrentDistance(newDistance);

				if (i != 0 && car.getCurrentDistance() > raceCars.get(i - 1).getCurrentDistance())
					Collections.swap(raceCars, i, i - 1);

				if (car.getCurrentDistance() >= distance)
					raceStarted = false;
			}
		}
	}

	public void raceResult() {
		System.out.println("*** AND THE WINNERS ARE...***");
		for (RaceCar car : raceCars) {
			System.out.println(car.getDriver() + ", driving a " + car.getBrand());
			System.out.println("with a distance of " + car.getCurrentDistance());
			System.out.println();
		}

//		System.out.println("The number 1!!!");
//		System.out.println("The number 2!!!");
//		System.out.println("The number 3!!!");
	}
}
