package guess_who;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Roel Pennings
 * @version 1
 */
public class GuessWho {
	/**
	 * our main method
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		// You may ignore the three lines of code below this one:
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			// Here you'll find some examples of how to do stuff. You can leave them in your
			// program:
			// Putting text in the console:
			System.out.println("Welcome to 'Guess Who'! Let me guess your guy. Type 'yes' or 'no', followed by ENTER.");
			// Reading text from the console (click in the console and type one character,
			// press enter):
			String s = br.readLine();
			// Putting text in the console, use '+' to concatenate Strings (stick them
			// together):
			System.out.println("OK great! You typed: " + s + ". Now we can start for real!");

			////////////////// YOUR CODE - START ///////////////////////

			boolean isMan = askQuestion("Is it a man?", br);

			if (isMan) {
				boolean hasOnHead = askQuestion("Is he wearing something on his head?", br);

				if (hasOnHead) {
					boolean hasBlueEyes = askQuestion("Does he have blue eyes?", br);

					if (hasBlueEyes) {
						boolean hasRedHair = askQuestion("Does he have red hair?", br);

						if (hasRedHair) {
							System.out.println("IT IS CHRIS!");
						} else {
							System.out.println("IT IS JAKE!");
						}
					} else {
						System.out.println("IT IS JAC!");
					}
				} else {
					boolean isSkinWhite = askQuestion("Is his skin white?", br);

					if (isSkinWhite) {

					} else {
						boolean hasBeard = askQuestion("Does he have a beard?", br);

						if (hasBeard) {
							boolean isHairBlack = askQuestion("Is his hair white?", br);

							if (isHairBlack) {
								System.out.println("IT IS BOB!");
							} else {
								System.out.println("IT IS MARK!");
							}
						} else {
							boolean isBold = askQuestion("Is he bold?", br);

							if (isBold) {
								System.out.println("IT IS SAM!");
							} else {
								boolean isHairBlack = askQuestion("Is his hair black?", br);

								if (isHairBlack) {
									System.out.println("IT IS TUPP!");
								} else {
									System.out.println("IT IS JOE!");
								}
							}
						}
					}

					// Beard
					// Bold
					// Hair black
				}
			} else {
				System.out.println("You're thinking of a woman. You shouldn't do that!");
			}

			/////////////////// YOUR CODE - END ////////////////////////

			// You may ignore everything below this line
		} catch (Exception e) {
			System.out.println("AII - Something went wrong: " + e.getMessage());
		}

	}

	private static boolean askQuestion(String question, BufferedReader br) {
		System.out.println();
		System.out.println(question);

		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s.equals("yes");
	}
}
