
public class Main {

	public static void main(String[] args) {
		Order order = new Order(10);

		order.addCoffee("Cappuccino", 2);
		order.addCoffee("Koffie Verkeerd", 3);
		order.addCoffee("Espresso", 1);

		Cake moorkop = new Cake("Moorkop", false);
		Cake appeltaartSugarFree = new Cake("Appeltaart", true);
		Cake appeltaart = new Cake("Appeltaart", false);

		order.addCake(moorkop);
		order.addCake(appeltaartSugarFree);
		order.addCake(appeltaart);

		order.showOrder();
	}

}
