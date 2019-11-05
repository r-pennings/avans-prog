import java.util.HashMap;

public class CodeWordChecker {

	private HashMap<String, String> words;

	public CodeWordChecker() {
		words = new HashMap<String, String>();
	}

	public void addWord(String codeWord, String respons) {
		if (words.containsKey(codeWord)) {
			System.out.println("Het codewoord " + codeWord + " wordt overschreven!");
		}

		words.put(codeWord, respons);
	}

	public void showRespons(String codeWord) {
		if (!words.containsKey(codeWord)) {
			System.out.println("Dit is geen geldig codewoord!");
		} else {
			System.out.println(words.get(codeWord));
		}
	}

	public void removeCodePair(String codeWord) {
		words.remove(codeWord);
		
		System.out.println(codeWord + " is verwijderd!");
	}
}
