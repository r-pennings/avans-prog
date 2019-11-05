
public class CargoPlane extends Airplane implements Trackable {

	private String cargoType;

	public CargoPlane(int x, int y, int h) {
		super(x, y, h);

		this.cargoType = "";
	}

	public void loadUp(String cargo) {
		this.cargoType = cargo;
	}

	public void showCargo() {
		System.out.println("This cargoplane is currently shipping " + this.cargoType);
	}
}
