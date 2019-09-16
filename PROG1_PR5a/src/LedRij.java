
public class LedRij {
	private final Led[] ledArray;

	public LedRij(int size) {
		ledArray = new Led[size];

		for (int i = 0; i < ledArray.length; i++) {
			ledArray[i] = new Led();
		}
	}

	public void schakel(int positie, boolean aanUit) {
		if (ledArray.length > positie - 1 && ledArray[positie - 1] != null) {
			ledArray[positie - 1].setLedState(aanUit);
		} else {
			System.out.println("Deze schakel is niet mogelijk op deze kolom!");
		}

	}

	public void schuif(boolean naarRechts) {
		if (naarRechts) {
			boolean lastState = ledArray[3].getLedIsOn();
			ledArray[3].setLedState(ledArray[2].getLedIsOn());
			ledArray[2].setLedState(ledArray[1].getLedIsOn());
			ledArray[1].setLedState(ledArray[0].getLedIsOn());
			ledArray[0].setLedState(lastState);
		} else {
			boolean firstState = ledArray[0].getLedIsOn();
			ledArray[0].setLedState(ledArray[1].getLedIsOn());
			ledArray[1].setLedState(ledArray[2].getLedIsOn());
			ledArray[2].setLedState(ledArray[3].getLedIsOn());
			ledArray[3].setLedState(firstState);
		}
	}

	public String toString() {
		String ledString = "";

		for (Led led : ledArray) {
			if (led.getLedIsOn()) {
				ledString += "|O|";
			} else {
				ledString += "|-|";
			}
		}

		return ledString;
	}

	public int length() {
		return ledArray.length;
	}

	public void clear() {
		for (Led led : ledArray) {
			led.setLedState(false);
		}
	}
}
