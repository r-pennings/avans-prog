import java.util.ArrayList;

public class SuperMarket {

	private ArrayList<CashDesk> cashDesks;
	private int maxNrOfCashDesks;
	private int maxPreferredQueueSize;

	public void addCust(Customer newCust) {
		
	}

	public void doTick() {

	}

	public int getAverageQueueLength() {
		int local = 0;

		for (CashDesk desk : cashDesks) {
			local += desk.getQueueSize();
		}

		int avg = local / cashDesks.size();
		return avg;
	}

	public int getCustomerTotal() {
		int local = 0;

		for (CashDesk desk : cashDesks) {
			local += desk.getQueueSize();
		}
		
		return local;
	}

	public int getAmountOfCashDeskOpen() {
		int amount = 0;

		for (CashDesk desk : cashDesks) {
			amount += desk.getQueueSize();
		}
		
		return amount;
	}

	public void setMaxNumberOfCashDesks(int nr) {
		this.maxNrOfCashDesks = nr;
	}

}
