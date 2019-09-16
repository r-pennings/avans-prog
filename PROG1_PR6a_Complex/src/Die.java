import java.util.Random;

public class Die {

	int sides;
	int lastThrow;
	
	void setNumberOfSides(int sides) {
		this.sides = sides;
	}
	
	int getNumberOfSides() {
		return sides;
	}
	
	int getThrow() {
		return lastThrow;
	}
	
	void throwDie() {
		Random random = new Random();
		
		this.lastThrow = random.nextInt(sides) + 1;
	}
}
