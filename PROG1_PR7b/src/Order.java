
public class Order {

	private int tableNumber;
	private Coffee[] coffeeArray;
	private Cake[] cakeArray;

	public Order(int tableNumber) {
		this.tableNumber = tableNumber;
		coffeeArray = new Coffee[10];
		cakeArray = new Cake[10];
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Coffee[] getCoffeeArray() {
		return coffeeArray;
	}

	public void setCoffeeArray(Coffee[] coffeeArray) {
		this.coffeeArray = coffeeArray;
	}

	public Cake[] getCakeArray() {
		return cakeArray;
	}

	public void setCakeArray(Cake[] cakeArray) {
		this.cakeArray = cakeArray;
	}

	public void addCake(Cake newCake) {
		for (int i = 0; i < cakeArray.length; i++) {
			if (cakeArray[i] == null) {
				cakeArray[i] = newCake;
				break;
			}
		}
	}

	public void addCoffee(String name, int size) {
		for (int i = 0; i < coffeeArray.length; i++) {
			if (coffeeArray[i] == null) {
				coffeeArray[i] = new Coffee(name, size);
				break;
			}
		}
	}

	public String listSugarFree() {
		String list = "";

		for (int i = 0; i < cakeArray.length; i++) {
			Cake cake = cakeArray[i];
			if (cake != null && cake.isSugarFree())
				list += cake.getName();
		}

		return list;
	}

	public void showOrder() {
		System.out.println("Tafelnummer: " + tableNumber);

		int coffeeCups = 0;
		for (Coffee coffee : coffeeArray) {
			if (coffee != null) {
				System.out.println(coffee.getName() + " - " + coffee.getSize());

				coffeeCups++;
			}
		}

		if (coffeeCups > 0) {
			System.out.println();
			System.out.println("Totaal: " + coffeeCups);
			System.out.println();
		}

		int cakeParts = 0;
		for (Cake cake : cakeArray) {
			if (cake != null) {
				String cakeString = "";

				cakeString += cake.getName();

				if (cake.isSugarFree()) {
					cakeString += " suikervrij";
				}

				System.out.println(cakeString);

				cakeParts++;
			}
		}

		if (cakeParts > 0) {
			System.out.println();
			System.out.println("Totaal: " + cakeParts);
		}
	}

}
