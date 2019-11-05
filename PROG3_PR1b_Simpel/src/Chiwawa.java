
public class Chiwawa extends Dog {

	public void bark() {
		System.out.println("...");
	}

	public void walk() {
		if (this.getName() != null) {
			System.out.println("Carrying " + this.getName() + "...");
		} else {
			System.out.println("Just carrying a dog...");
		}
	}
}
