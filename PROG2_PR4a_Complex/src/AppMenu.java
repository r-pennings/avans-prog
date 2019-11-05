import java.util.ArrayList;

public class AppMenu {

	private ArrayList<PhoneApp> appAList = new ArrayList<PhoneApp>();

	public void addApp(PhoneApp app) {
		PhoneApp oldApp = null;
		Boolean inPhone = false;
		Boolean isHigherVersion = false;
		for (int index = 0; index < appAList.size(); index++) {
			oldApp = appAList.get(index);
			
			if (oldApp.getName() == app.getName()) {
				inPhone = true;

				if (oldApp.getVersion() < app.getVersion()) {
					isHigherVersion = true;
				}
				
				break;
			}
		}

		if (inPhone) {
			if (isHigherVersion) {
				System.out.println(app.getName() + " updaten...");
				this.removeApp(oldApp);
				
				this.appAList.add(app);
				
				app.printNewVersion();
			} else {
				app.printNewestExists();
			}
			
		} else {
			System.out.println(app.getName() + " aan het toevoegen...");
			appAList.add(app);
		}
	}

	public void removeApp(PhoneApp app) {
		appAList.remove(app);
	}

	public ArrayList<PhoneApp> getApps() {
		return this.appAList;
	}
	
	public void printAppMenu() {
		System.out.println("\n*** Current apps on this phone ***");
		for (PhoneApp app : appAList) {
			app.printApp();
		}
		
		System.out.println();
	}
}
