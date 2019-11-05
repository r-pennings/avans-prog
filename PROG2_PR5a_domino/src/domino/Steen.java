package domino;

/**
 *   De steen van het dominospel
 *   Hier zitten geen fouten in
 * 
 * @author P. de Niet/ Marieke Versteijlen 
 * @version Versie 2
 */
public class Steen {
    // instance variables -

    private int zijdeLinks;
    private int zijdeRechts;

    /**
     * Constructor for objects of class Steen
     */
    public Steen() {
    }

    /**
     * Een steen heeft 2 zijdes met daarop een getal 0 - 6
     */
    public Steen(int zijdeL, int zijdeR) {
        setSteen(zijdeL, zijdeR);
    }

    public void setSteen(int zijdeL, int zijdeR) {
        this.zijdeLinks = zijdeL;
        this.zijdeRechts = zijdeR;
    }

    public int getWaarde() {
        return zijdeLinks + zijdeRechts;
    }

    public int getZijdeLinks() {
        return zijdeLinks;
    }

    public int getZijdeRechts() {
        return zijdeRechts;
    }

    public String toString() {
        return zijdeLinks + "|" + zijdeRechts;
    }
}
