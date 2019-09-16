
public class Main {

	public static void main(String[] args) {
		Hand hand = new Hand();

		hand.addDie(6);
		hand.addDie(4);
		hand.addDie(8);
		hand.addDie(5);
		
		hand.throwDice();
		hand.showThrow();
	}
}
