
public class Sine {

	final static int xOffset = 50;
	final static double sinus = 2 * Math.PI;
	final static double sinusStep = sinus / 20;

	public static void main(String args[]) throws InterruptedException {
		/* DRAW 10 SINUSSES */
		for (int i = 0; i < 10; i++) {
			/* DRAW A SINGLE SINE */
			for (double angle = 0; angle < sinus; angle += sinusStep) {
				double result = 20 * Math.sin(angle);

				String resultString = "";

				for (int count = 0; count <= result + xOffset; count++) {
					resultString += " ";
				}

				resultString += "x";

				System.out.println(resultString);

				Thread.sleep(50);
			}
		}
	}
}
