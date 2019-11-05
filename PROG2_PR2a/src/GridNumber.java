
public class GridNumber {

	private int value;
	private int x;
	private int y;

	public GridNumber(int x, int y) {
		value = 0;
		this.x = x;
		this.y = y;
	}

	public void printValue() {
		if(value < 10) {
			System.out.print(" ");
		}
		
		if (y < 4) {
			System.out.print(value + "|");
		} else {
			System.out.print(value);
		}
	}

	public boolean isValidValue() {
		int newValue = (value + ((x + y) + 1));
		return (newValue <= 50);
	}

	public void resetValue() {
		value = 0;
	}
	
	public void increaseValue() {
		value = (value + ((x + y) + 1));
	}
}
