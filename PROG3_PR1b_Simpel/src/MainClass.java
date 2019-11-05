
public class MainClass {

	public static void main(String[] args) {
		Charmander cmander = new Charmander();
		Charmeleon cmelion = new Charmeleon();
		Charizard czard = new Charizard();
		
		cmander.showData();
		cmander.speak();
		cmander.doMainAttack();
		cmander.doSecAttack();
		
		cmelion.showData();
		cmelion.speak();
		cmelion.doMainAttack();
		cmelion.doSecAttack();
		
		czard.showData();
		czard.speak();
		czard.doMainAttack();
		czard.doSecAttack();

	}

}
