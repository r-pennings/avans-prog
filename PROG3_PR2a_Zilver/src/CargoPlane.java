
public class CargoPlane extends Airplane {

	private String cargoType;

	public CargoPlane() {
		super();

		this.cargoType = "";
	}

	public void loadUp(String cargo) {
		this.cargoType = cargo;
	}
	
	public void showCargo() {
		System.out.println("This cargoplane is currently shipping " + this.cargoType);
	}
}
