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
	
	//FIELDS
	private final static int arrSize = 10000;

	
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
	 * @return the main queue for this instance of the class
	 */ 
	public Queue<Message> getQueue() {
		return mainQ;
	}
	
	/**
	 * creates a series of messages from priority 0 to 40 and processes them based on order of their priority
	 * @param arr - array of empty queues to be filled
	 * @return array of queues filled with messages with set arrival times
	 */
	public ArrayList<MessagePriorityQueue> process(ArrayList<MessagePriorityQueue> arr) {
	
		MessagePriorityQueue zero2 = new MessagePriorityQueue();
		MessagePriorityQueue one2 = new MessagePriorityQueue();
		MessagePriorityQueue two2 = new MessagePriorityQueue();
		MessagePriorityQueue three2 = new MessagePriorityQueue();
		MessagePriorityQueue four2 = new MessagePriorityQueue();
		ArrayList<MessagePriorityQueue> list2 = new ArrayList<MessagePriorityQueue>();
		
		for (int i = 0; i < arrSize; i++) {
			int r = (int)(Math.random() * 5);
			if (i% 10 == 0) 
				r = 4;
			if (i < (arrSize / 5)) {
				Message m = new Message(r);
				arr.get(r).add(m);
			}
			for (MessagePriorityQueue q : arr)
				for (Message m : q.getQueue())
					m.increment();
			if (i % 4 == 0) {
				if (!arr.get(0).isEmpty()) {
					Message m2 = new Message();
					m2 = arr.get(0).remove();
					zero2.add(m2);
				}
				else if (!arr.get(1).isEmpty()) {
					Message m2 = arr.get(1).remove();
					one2.add(m2);
				}
				else if (!arr.get(2).isEmpty()) {
					Message m2 = new Message();
					m2 = arr.get(2).remove();
					two2.add(m2);
				}
				else if (!arr.get(3).isEmpty()) {
					Message m2 = new Message();
					m2 = arr.get(3).remove();
					three2.add(m2);
				}
				else {
					Message m2 = new Message();
					m2 = arr.get(4).remove();
					four2.add(m2);
				}
			}
		}
		list2.add(zero2);
		list2.add(one2);
		list2.add(two2);
		list2.add(three2);
		list2.add(four2);
		return list2;
	}
	
}
