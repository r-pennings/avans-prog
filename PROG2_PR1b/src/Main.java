import java.util.*;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Geef de zin die je wil coderen: ");

			String input = sc.nextLine();
			String trimmed = input.trim();
			if (!trimmed.isEmpty() && trimmed.matches("^[a-zA-Z,. ]*$")) {
				String encoded = code(trimmed);
				System.out.println(encoded);

				String decoded = decode(encoded);
				System.out.println(decoded);
				break;
			} else {
				continue;
			}
		}
	}

	public static String code(String message) {
		String codedMessage = "";

		char[] charArray = message.toCharArray();

		int wordCount = 1;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ') {
				wordCount++;
			}

			String hex = Integer.toHexString(charArray[i]).toUpperCase();
			if (isAlphabeticalCharacter(charArray[i])) {
				
			} else {
				codedMessage += hex;
			}

			if (i < charArray.length)
				codedMessage += " ";
		}

		return codedMessage;
	}

	public static String decode(String codedMessage) {
		String message = "";

		return message;
	}

	private static boolean isAlphabeticalCharacter(char character) {
		if (character >= 'a' || character <= 'z' || character >= 'A' || character <= 'Z') {
			return true;
		}

		return false;
	}

}
