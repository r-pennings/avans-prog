
public class MainClass {

	public static void main(String[] args) {
		Airport schiphol = new Airport();
		
		CargoPlane cargo1 = new CargoPlane(100, 121, 4500);
		CargoPlane cargo2 = new CargoPlane(45, 980, 1459);
		TransportPlane trans1 = new TransportPlane(167, 12, 100);
		TransportPlane trans2 = new TransportPlane(728, 921, 529);
	}
}
