
public class Main {

	public static void main(String[] args) {
		Race race = new Race(4000);
		
		race.addRaceCar(new RaceCar("RedBull", "Gerrie", 15));
		race.addRaceCar(new RaceCar("Haas", "Richard", 13));
		race.addRaceCar(new RaceCar("Renault", "Tijmen", 14));
		
		race.runRace();
		race.raceResult();
	}

}
