import java.util.HashMap;

public class TrafficTicketSystem {

	private HashMap<String, String> carTickets;

	public TrafficTicketSystem() {
		carTickets = new HashMap<String, String>();
	}

	public void addTicket(String numberPlate, String description) {
		/*
		 * addTicket : Voegt een nummerplaat met de beschrijving van de overtreding toe
		 * (aan carTickets). Check eerst of de nummerplaat niet al aanwezig is! In dat
		 * geval moet je de beschrijving van deze overtreding achter de beschrijving
		 * plakken die er al staat! Dit doe je door : 1. te checken of de nummerplaat al
		 * in de HashMap staat. 2. Zo ja: dan vraag je de beschrijving op die bij die
		 * nummerplaat hoort. 3. Daar plak je de nieuwe beschrijving achter. (String
		 * concatinating) 4. Dan voeg je de nummerplaat met beschrijving weer toe in de
		 * HashMap. (De HashMap class zal zelf de oude beschrijving overschrijven met de
		 * nieuwe.)
		 */
	}

	public void showTicket(String numberPlate) {
		/*
		 * Als de meegegeven nummerplaat een bekeuring aan zich gebonden heeft dan wordt
		 * de beschrijving in de console afgedrukt. Als dit niet zo is dan wordt een
		 * bericht gegeven dat deze auto geen bekeuring heeft.
		 */
	}

	public void payTickets(String numberPlate) {
		/*
		 * Alle bekeuringen op de meegegeven nummerplaat worden betaald. Verwijder de
		 * nummerplaat uit het systeem.
		 */
	}

	public void showAllTickets() {
		/*
		 * Druk in de console alle kentekens met hun bekeuringen af.
		 */
	}

}
