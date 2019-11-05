
public class Dog {

	private String name;

	protected void bark() {
		System.out.println("Wroof!");
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getName() {
		return this.name;
	}

	protected void walk() {
		System.out.println("Walking " + this.name + " the dog!");
	}
}
