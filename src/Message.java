
public class Message {

	public int priority;
	public int arrival;
	
	public Message() {
		priority = 0;
	}
	
	public Message(int p) {
		priority = p;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int p) {
		priority = p;
	}
	
	public int getArrival () {
		return arrival;
				
	}

	public void setArrivalTime(int i) {
		arrival = i;
	}
	
	
	
	
}
