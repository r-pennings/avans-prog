
public class MainClass {

	public static void main(String[] args) {
		Airport schiphol = new Airport();
		
		CargoPlane cargo1 = new CargoPlane(100, 121, 4500);
		CargoPlane cargo2 = new CargoPlane(45, 980, 1459);
		TransportPlane trans1 = new TransportPlane(167, 12, 100);
		TransportPlane trans2 = new TransportPlane(728, 921, 529);
		
		StealthPlane stealth1 = new StealthPlane(468, 198, 2977);
		
		Ship ship1 = new Ship();
		
		schiphol.addPlane(cargo1);
		schiphol.addPlane(cargo2);
		schiphol.addPlane(trans1);
		schiphol.addPlane(trans2);
		schiphol.addPlane(stealth1);

		schiphol.addShip(ship1);
		
		schiphol.showAllContents();
	}
}
