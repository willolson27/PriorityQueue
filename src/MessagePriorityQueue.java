import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author will olson (git: willolson27)
 * Assignment 8 - MessagePriorityQueue
 * Due April 24, 2018
 *
 */
public class MessagePriorityQueue {

	//DATA STRUCTURES
	private Queue<Message> mainQ;
	
	/**
	 * creates a new MessagePriorityQueue with a default empty queue
	 */
	public MessagePriorityQueue() {
		mainQ = new LinkedList<Message>();
	}
	
	/**
	 * calculates the average time the messages in this queue had to wait to be processed
	 * @return the average amount of time it took for a message in this queue to be processed
	 */
	public double averageTime() {
		
		Queue<Message> q = this.mainQ;
		double sum = 0;
		double avg = 0;	
		int size = 0;
		
		for (Message m : q) {
			if (m != null) {
				sum += m.getArrival();
				size++;
			}
		}
		
		if (sum > 0)
			avg = sum / size;
		return avg;
	}
	
	/**
	 * checks if the main queue of this instance is empty
	 * @return boolean - true if empty, false if not
	 */
	public boolean isEmpty() {
		return mainQ.isEmpty();
	}

	/**
	 * adds a message to the queue based on FIFO
	 * @param m Message to be added to the main queue
	 */
	public void add(Message m) {
		mainQ.add(m);
	}
	
	/**
	 * removes an element from the Queue based on FIFO
	 * @return the Message removed from the queue
	 */
	public Message remove() {
		if (!mainQ.isEmpty())
			return mainQ.remove();
		else
			return null;
	}
	
	/**
	 * retrieves the main queue housed in this instance of MessagePriorityQueue
	 * @return the main queue for this instasnce of the class
	 */ 
	public Queue<Message> getQueue() {
		return mainQ;
	}
	
}
