
public class PhoneApp {

	private String name;
	private int memorySize;
	private double version;

	public PhoneApp(String name, int memorySize, double version) {
		this.name = name;
		this.memorySize = memorySize;
		this.version = version;
	}

	public String getName() {
		return this.name;
	}

	public int getMemorySize() {
		return this.memorySize;
	}

	public double getVersion() {
		return this.version;
	}

	public void updateApp(double newVersion) {
		System.out.println(this.getName() + " updaten...");

		if (newVersion <= version) {
			this.printNewestExists();
		} else {
			version = newVersion;

			this.printNewVersion();
		}
	}

	public void printApp() {
		System.out.println(this.getName() + " v" + this.getVersion() + " - Memorysize: " + this.getMemorySize() + "MB");
	}

	public void printNewVersion() {
		System.out.println("Versie " + this.version + " van " + this.getName() + " staat op de telefoon!");
	}

	public void printExists() {
		System.out.println("Versie " + this.version + " van " + this.getName() + " is al geïnstalleerd!");
	}

	public void printNewestExists() {
		System.out.println("De nieuwste versie van " + this.getName() + " is al geïnstalleerd!");
	}
}
