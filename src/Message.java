/**
 * 
 * @author will olson (git: willolson27)
 * Assignment 8 - MessagePriorityQueue
 * Due April 24, 2018
 *
 */
public class Message {

	//FIELDS
	public int priority;
	public int arrival;
	
	/**
	 * creates a new message with a default priority of zero and arrival time of zero
	 */
	public Message() {
		priority = 0;
		arrival = 0;
	}
	
	/**
	 * creates a new Message with a given priority level and an arrival time of zero
	 * @param p - given priority level for this message
	 */
	public Message(int p) {
		priority = p;
		arrival = 0;
	}
	
	/**
	 * retrieves the priority level of this message - from 0 to 4
	 * @return integer from 0 to 4 representing the priority level
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * sets the priority level of this message to a given integer
	 * @param p - new priority of this message
	 */
	public void setPriority(int p) {
		priority = p;
	}
	
	/**
	 * retrieves the amount of time (in "minutes") it took for this message to be processed
	 * @return number of minutes it took this message to arrive
	 */
	public int getArrival () {
		return arrival;
				
	}

	/**
	 * sets the arrival time of this message to a given integer *UNUSED*
	 * @param i - number of minutes set to be the new arrival time
	 */
	public void setArrivalTime(int i) {
		arrival = i;
	}
	
	/**
	 * increases the arrival time of this Message by one "minute"
	 */
	public void increment() {
		arrival++;
	}
	
	
	
	
}
