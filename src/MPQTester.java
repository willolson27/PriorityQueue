import java.util.ArrayList;
/**
 * 
 * @author will olson (git: willolson27)
 * Assignment 8 - MessagePriorityQueue
 * Due April 24, 2018
 *
 */
public class MPQTester {
	
	//FIELDS
	private final static String AVG_TIME = "Average time to wait for priority ";
	private final static String MINUTES = " minutes";
	
	/**
	 * tests out the MessagePriorityQueue class by creating five MPQs and running them through
	 * MessagePriorityQueue's process method
	 * @param args
	 */
	public static void main(String[] args) { 
		
		ArrayList<MessagePriorityQueue> list = new ArrayList<MessagePriorityQueue>();
//		MPQTester main = new MPQTester();
		MessagePriorityQueue zero = new MessagePriorityQueue();
		MessagePriorityQueue one = new MessagePriorityQueue();
		MessagePriorityQueue  two = new MessagePriorityQueue();
		MessagePriorityQueue three = new MessagePriorityQueue();
		MessagePriorityQueue four = new MessagePriorityQueue();
		
		list.add(zero);
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		ArrayList<MessagePriorityQueue> list2 = zero.process(list);
		for (int i = 0; i < list2.size(); i++)
			System.out.println(AVG_TIME + i + ": " + list2.get(i).averageTime() + MINUTES);
	}
	
}
