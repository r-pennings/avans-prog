
public abstract class Airplane {

	protected int xPos;
	protected int yPos;

	protected int height;

	public Airplane(int x, int y, int h) {
		this.xPos = x;
		this.yPos = y;
		this.height = h;
	}
	
	public void showInfoOnRadar() {
		System.out.println("x: " + this.xPos + ", y:" + this.yPos + ", altitude: " + this.height + " - " + this.getClass());
	}
}
