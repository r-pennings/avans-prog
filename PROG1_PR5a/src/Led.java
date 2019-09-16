
public class Led {
	private boolean ledIsOn;
	
	public Led() {
		ledIsOn = false;
	}
	
	public void setLedState(boolean ledState) {
		ledIsOn = ledState;
	}
	
	public boolean getLedIsOn() {
		return ledIsOn;
	}
}
