package blub;

import java.util.ArrayList;
/**
 * @author Bob van der Putten
 * 
 */
public class FishTank
{
	private ArrayList<Fish> fishTank;
	
	public FishTank()
	{
		fishTank = new ArrayList<Fish>();
	}

	public void addFishy() {
	  ArrayList<Fish> fishTank = new ArrayList<Fish>();
	  fishTank.add(new Fish("Bluppy"));
	}

	public void letFishiesSwim() {
	  for (Fish f:fishTank) {
	    f.swimAround();
	    f.drawOnCanvas();
	  }
	}
}
