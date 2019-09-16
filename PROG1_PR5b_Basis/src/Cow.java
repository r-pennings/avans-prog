
public class Cow {
	String name;
	int age;
	double price;
	boolean hasMilk;

	public void aging() {
		this.age++;
	}

	public void print() {
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("Price: " + this.price);
		
		if (this.hasMilk) {
			System.out.println("Does give milk");
		} else {
			System.out.println("Doesn't give milk");
		}
		
		System.out.println();

	}
}
