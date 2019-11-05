
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Airport schiphol = new Airport();

		CargoPlane cargo1 = new CargoPlane();
		cargo1.loadUp("flowers");
		
		CargoPlane cargo2 = new CargoPlane();
		cargo1.loadUp("teapots");
		
		TransportPlane trans1 = new TransportPlane();
		trans1.board(10);
		
		TransportPlane trans2 = new TransportPlane();
		trans1.board(100);

		schiphol.addPlane(cargo1);
		schiphol.addPlane(cargo2);
		schiphol.addPlane(trans1);
		schiphol.addPlane(trans2);
		
		schiphol.showAllContents();
	}

}
