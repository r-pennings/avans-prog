package domino;

/**
 * Een enkel dominospel heeft 28 stenen. Daaruit wordt telkens een willekeurige steen genomen.
 * De volgende stenen komen voor:
 * 0|0 0|1 0|2 0|3 0|4 0|5 0|6
 * 1|1 1|2 1|3 1|4 1|5 1|6
 * 2|2 2|3 2|4 2|5 2|6
 * 3|3 3|4 3|5 3|6
 * 4|4 4|5 4|6
 * 5|5 5|6
 * 6|6
 * 
 * @author P. de Niet/Marieke Versteijlen
 * @version 2
 */
import java.util.Random;
import java.util.ArrayList;

public class Pot {

	private ArrayList<Steen> stenen;
	private Random random = new Random();

	/**
	 * Constructor for objects of class Pot De stenen worden in volgorde in de pot
	 * geplaatst
	 */
	public Pot() {
		stenen = new ArrayList<Steen>();
		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= i; j++) {
				stenen.add(new Steen(j, i));
			}
		}
	}

	/**
	 * Een willekeurige steen wordt uit de pot gehaald De laatste steen wordt gezet
	 * op de plaats van de willekeurig steen Het aantal stenen in de pot wordt met 1
	 * verminderd.
	 */
	public Steen geefRandomSteen() {
		if (isLeeg()) {
			return null;
		}
		int getal = random.nextInt(stenen.size());
		Steen steen = stenen.get(getal);
		stenen.remove(steen);
		return steen;
	}

	/**
	 * Test of de pot leeg is.
	 */
	public boolean isLeeg() {
		return stenen.isEmpty();
	}

	public int inDePot() {
		return stenen.size();
	}
}
