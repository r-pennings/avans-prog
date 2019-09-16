
public class Main {

	public static void main(String[] args) {
		Guest alice = initializeAlice();
		Guest madHatter = initializeMadHatter();
		Guest marchHare = initializeMarchHare();
		Guest dormouse = initializeDormouse();
		
		Table table = new Table();
		table.addGuest(alice);
		table.addGuest(madHatter);
		table.addGuest(marchHare);
		table.addGuest(dormouse);
		
		table.printTeaParty();
	}
	
	static Guest initializeAlice() {
		Guest alice = new Guest();
		alice.setName("Alice");
		
		Tea rosehipTea = new Tea();
		rosehipTea.setName("Rosehip Tea");
		rosehipTea.setMilk(true);
		
		Cake chocolateSponge = new Cake();
		chocolateSponge.setName("Chocolate Sponge");
		
		alice.giveTea(rosehipTea);
		alice.giveCake(chocolateSponge);
		
		return alice;
	}
	
	static Guest initializeMadHatter() {
		Guest madHatter = new Guest();
		madHatter.setName("Mad Hatter");
		
		Tea lapsang = new Tea();
		lapsang.setName("Lapsang Souchong");
		lapsang.setMilk(true);
		
		Cake lemonTart = new Cake();
		lemonTart.setName("Lemon Tart");
		
		madHatter.giveTea(lapsang);
		madHatter.giveCake(lemonTart);
		
		return madHatter;
	}
	
	static Guest initializeMarchHare() {
		Guest marchHare = new Guest();
		marchHare.setName("March Hare");
		
		Tea darjeeling = new Tea();
		darjeeling.setName("Darjeeling");
		darjeeling.setMilk(true);
		
		Cake carrotCake = new Cake();
		carrotCake.setName("Carrot Cake");
		
		marchHare.giveTea(darjeeling);
		marchHare.giveCake(carrotCake);
		
		return marchHare;
	}
	
	static Guest initializeDormouse() {
		Guest dormouse = new Guest();
		dormouse.setName("Dormouse");
		
		Tea ceylon = new Tea();
		ceylon.setName("Ceylon Blend");
		ceylon.setMilk(true);
		
		Cake fruit = new Cake();
		fruit.setName("Fruit Cake");
		
		dormouse.giveTea(ceylon);
		dormouse.giveCake(fruit);
		
		return dormouse;
	}

}
