
public class Main {

	private static AppMenu menu;

	public static void main(String[] args) {
		menu = new AppMenu();

		PhoneApp whatsapp = new PhoneApp("WhatsApp", 25, 2.6);
		PhoneApp twitter = new PhoneApp("Twitter", 10, 1.9);
		PhoneApp facebook = new PhoneApp("FaceBook", 46, 3.1);
		PhoneApp pinterest = new PhoneApp("Pinterest", 16, 2.3);

		menu.addApp(whatsapp);
		menu.addApp(twitter);
		menu.addApp(facebook);
		menu.addApp(pinterest);

		menu.printAppMenu();

		addLowerVersion();
	}

	/* TESTS */
	@SuppressWarnings("unused")
	private static void addSameApp() {
		PhoneApp twitter = new PhoneApp("Twitter", 10, 2.0);

		menu.addApp(twitter);
		
		menu.printAppMenu();
	}

	@SuppressWarnings("unused")
	private static void addLowerVersion() {
		PhoneApp twitter = new PhoneApp("Twitter", 10, 1.6);

		menu.addApp(twitter);
		
		menu.printAppMenu();
	}

	@SuppressWarnings("unused")
	private static void updateApp() {
		menu.getApps().get(2).updateApp(3.4);
		
		menu.printAppMenu();
	}

}
