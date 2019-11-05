
public class MainClass {

	public static void main(String[] args) {
		Chiwawa hond1 = new Chiwawa();
		Retreever hond2 = new Retreever();
		Chiwawa hond3 = new Chiwawa();
		
		// Chiwawa with name
		hond1.setName("Jimmy");
		hond1.bark();
		hond1.walk();
		
		// Retreever with name
		hond2.setName("Timmy");
		hond2.bark();
		hond2.walk();
		
		// Chiwawa without name
		hond3.bark();
		hond3.walk();
	}

}
