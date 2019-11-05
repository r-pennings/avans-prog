
public class Main {

	public static void main(String[] args) {
		// Opdracht 1
		/*
		 * int[] intArray = new int[2]; intArray[0] = 3; intArray[1] =
		 * intArray[0]; intArray[1] = 2;
		 * 
		 * for (int index = 0; index < intArray.length; index++) {
		 * System.out.println("index: " + index + ". Value: " + intArray[index]); }
		 */

		// Opdracht 2
		IntClass[] intClassArray = new IntClass[2];

		IntClass intClass1 = new IntClass();
		intClass1.setValue(3);
		intClassArray[0] = intClass1;
		intClassArray[1] = intClassArray[0];
		intClassArray[1].setValue(2);
		System.out.println("Value position 0 = " + intClassArray[0].getValue());
		System.out.println("Value position 1 = " + intClassArray[1].getValue());
	}

}
