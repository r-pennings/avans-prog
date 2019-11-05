
public class FoundIntNumber {

	private int value;
	private int nrCounted;
	
	public FoundIntNumber(int newValue) {
		this.value = newValue;
		this.nrCounted = 1;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getNrCounted() {
		return this.nrCounted;
	}
	
	public void increaseNrCounted() {
		this.nrCounted++;
	}
}
