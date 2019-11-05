import java.util.ArrayList;

public class CashDesk {

	private ArrayList<Customer> queue;
	private int spentTimeHelping;
	private Boolean opened;
	
	public void addCust(Customer newCust) {
		
	}
	
	public void helpCust() { 
		
	}
	
	public int getQueueSize() {
		return queue.size();
	}
	
	public Customer getLastCust() {
		return queue.get(queue.size() - 1);
	}
	
}
