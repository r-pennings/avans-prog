package domino;

/**
 * Er kunnen meerdere spelers aan het dominospel meedoen (meestal maximaal 4 bij een enkel spel)
 * Elke speler krijgt 6 willekeurig stenen uit de pot. 
 * 
 * @author P. de Niet/ Marieke Versteijlen
 * @version 2
 */
import java.util.ArrayList;

public class Speler {
    // instance variables -

    private String naam;
    private ArrayList<Steen> mijnStenen; //je eigen voorraad stenen

    /**
     * Constructor for objects of class Speler
     */
    public Speler(String p_naam) {
        mijnStenen = new ArrayList<Steen>();
        naam = p_naam; 
    }

    public String getNaam() {
        return naam;
    }

    /**
     * methode om stenen uit de pot te halen.
     *
     * @param de pot, het aantal stenen,dat er uit gehaald moet worden
     */
    public void haalStenenUitPot(Pot pot, int aantal) {
        for (int i = 1; i <= aantal; i++)
        {
            Steen steen = pot.geefRandomSteen();
            if (steen != null) {
                mijnStenen.add(steen);
            }
        }
    }

    /**
     * Als de speler een steen heeft, die links of rechts aan te leggen is,
     * wordt deze steen geretourneerd. De steen moet vervolgens uit de eigen voorraad verwijderd worden
     *
     * Wanneer de speler deze steen niet heeft, wordt null geretourneerd
     */
    public Steen geefSteen(int links, int rechts) {
        if (alleStenenKwijt()) {
            return null;
        }
        
        Steen steen = zoekSteen(links);
        if (steen == null) {
            steen = zoekSteen(rechts);
        }
        
        if (steen != null) {
        	mijnStenen.remove(steen);
            return steen;
        }
        
        return null;
    }

    /**
     * kijk of je een steen hebt waarbij op een van de zijdes de meegegeven waarde voorkomt.
     * 
     * @param  waarde  
     * @return gevonden steen of null
     */
    public Steen zoekSteen(int waarde) {
        for (Steen steen : mijnStenen) {
            if (steen.getZijdeLinks() == waarde) {
                return steen;
            }
            if (steen.getZijdeRechts() == waarde) {
                return steen;
            }
        }
        return null;
    }

    /**
     * het aantal stenen die nog in je bezit zijn
     */
    public int getAantalStenen() {
        return mijnStenen.size();
    }

    public boolean alleStenenKwijt() {
        return mijnStenen.isEmpty();
    }
}
