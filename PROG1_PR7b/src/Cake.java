
public class Cake {

	private String name;
	private boolean sugarFree;
	
	public Cake(String name, boolean isSugarFree) {
		this.name = name;
		this.sugarFree = isSugarFree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSugarFree() {
		return sugarFree;
	}

	public void setSugarFree(boolean sugarFree) {
		this.sugarFree = sugarFree;
	}
}
