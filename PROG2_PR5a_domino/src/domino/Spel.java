package domino;

/**
 * Er kunnen meerdere spelers aan het dominospel meedoen (in deze versie 3
 * spelers) Voorlopig wordt alleen door de computer tegen elkaar gespeeld. Elke
 * speler krijgt 6 willekeurig stenen uit de pot. Om de beurt proberen de
 * spelers aan 1 van de 2 kanten een steen aan te leggen zodat hij zo snel
 * mogelijk alle stenen kwijt is. Wanneer de speler geen steen kan aanleggen,
 * moet hij een steen uit de pot halen. De winnaar is degene die het eerst al
 * zijn stenen kwijt is. Het spel is ook afgelopen als er 3 keer achter elkaar
 * een speler niet kan aanleggen en als de pot leeg is
 *
 * 
 * @author P. de Niet/Marieke Versteijlen
 * @version 2
 */
public class Spel {

	private Pot pot;
	private Speler[] spelers; // er zijn 3 spelers
	private int steenLinks, steenRechts; // de linker en rechteruiteindes van de aangelegde stenen
	private final int aantalSpelers = 3;
	private String gelegdeStenen; // alle tot nu toe gelegde stenen

	/**
	 * Constructor for objects of class Spel Het spel krijgt een pot van 28 stenen.
	 * 
	 */
	public Spel() {
		pot = new Pot();
		
		System.out.println("NIEUW SPEL");
		
		spelers = new Speler[aantalSpelers];
		for (int i = 0; i < aantalSpelers; i++) {
			spelers[i] = new Speler("speler" + (i));
			spelers[i].haalStenenUitPot(pot, 6);
		}
		
		Steen steen = pot.geefRandomSteen(); // het spel begint met een willekeurige steen
		steenLinks = steen.getZijdeLinks();
		steenRechts = steen.getZijdeRechts();
		gelegdeStenen = steen.toString();
	}

	/**
	 * Het spel begint met een willekeurige steen. Aan beide zijde kan aangelegd
	 * worden. De loop van het spel kan gevolgd worden. Om de beurt wordt een steen
	 * aangelegd. Wanneer een speler geen stenen meer heeft is die speler de winnaar
	 * Wanneer geen van de spelers een steen op kan leggen of als de pot leeg is, is
	 * het spel afgelopen.
	 */
	public void speelSpel() {
		int beurt = 0;
		int nietAangelegd = 0; // 3 keer niet aangelegd, spel afgelopen

		Speler winnaar = null;

		while (!pot.isLeeg() && (nietAangelegd < 3) && winnaar == null) {
			Steen retourSteen = spelers[beurt].geefSteen(steenLinks, steenRechts);
			if (legSteenAan(retourSteen)) {
				nietAangelegd = 0; // deze speler kan aanleggen, dus we beginnen opnieuw te tellen
				System.out.println(gelegdeStenen);
						
				if (spelers[beurt].alleStenenKwijt()) {
					winnaar = spelers[beurt];
				}
			} else {
				nietAangelegd++;
				spelers[beurt].haalStenenUitPot(pot, 1);
			}
			beurt = volgendeSpeler(beurt);
		}
		geefUitslag(winnaar);
	}

	/**
	 * De volgende speler uit de lijst is aan de beurt
	 */
	public int volgendeSpeler(int beurt) {
		beurt++;
		return beurt % aantalSpelers;
	}

	/**
	 * De meegegeven steen (evt. gedraaid) wordt links of rechts aangelegd. De
	 * String gelegdeStenen wordt aangepast.
	 * 
	 * @return true or false, afhankelijk of het gelukt is om de steen aan te leggen
	 */
	public boolean legSteenAan(Steen aanlegSteen) {
		if (aanlegSteen == null) {
			return false;
		}
		if (aanlegSteen.getZijdeLinks() == steenLinks) {
			steenLinks = aanlegSteen.getZijdeRechts();
			gelegdeStenen = aanlegSteen.getZijdeRechts() + "|" + aanlegSteen.getZijdeLinks() + gelegdeStenen;
			return true;
		}
		if (aanlegSteen.getZijdeRechts() == steenLinks) {
			steenLinks = aanlegSteen.getZijdeLinks();
			gelegdeStenen = aanlegSteen.getZijdeLinks() + "|" + aanlegSteen.getZijdeRechts() + gelegdeStenen;
			return true;
		}
		if (aanlegSteen.getZijdeLinks() == steenRechts) {
			steenRechts = aanlegSteen.getZijdeRechts();
			gelegdeStenen = gelegdeStenen + aanlegSteen.getZijdeLinks() + "|" + aanlegSteen.getZijdeRechts();
			return true;
		}
		if (aanlegSteen.getZijdeRechts() == steenRechts) {
			steenRechts = aanlegSteen.getZijdeLinks();
			gelegdeStenen = gelegdeStenen + aanlegSteen.getZijdeRechts() + "|" + aanlegSteen.getZijdeLinks();
			return true;
		}
		return false;
	}

	/**
	 * Het aantal stenen en de punten van elke speler wordt op het scherm gezet.
	 */
	public void geefUitslag(Speler winnaar) {
		if (winnaar != null) {
			System.out.println(winnaar.getNaam() + " heeft het spel gewonnen!");
		} else {
			System.out.println("Er is geen winnaar");
		}
		System.out.println("De uitslag is");
		for (int i = 0; i < aantalSpelers; i++) {
			System.out.println("Speler" + (i + 1) + " heeft nog: " + spelers[i].getAantalStenen() + " stenen ");
		}
	}

	public int getSteenRechts() {
		return steenRechts;
	}

	public int getSteenLinks() {
		return steenLinks;
	}

	public String getSpelersNamen() {
		String namen = "";
		for (int i = 0; i < aantalSpelers; i++) {
			namen += spelers[i].getNaam() + ", ";
		}
		return namen;
	}

	public String toString() {
		return gelegdeStenen;
	}
}
