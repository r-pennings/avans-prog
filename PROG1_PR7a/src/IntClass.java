
public class IntClass {

	private int value;

	public void setValue(int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

	public IntClass copy() {
		int value = getValue();
		
		IntClass newIntClass = new IntClass();
		newIntClass.setValue(value);
		return newIntClass;
	}
	
	public boolean equals(Object object) {
		return this.getClass() == object.getClass();
	}
}
