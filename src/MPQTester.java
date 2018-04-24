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
	private final static int arrSize = 10000;

	/**
	 * 
	 * @param arr
	 * @return
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
			//		int a = waitTimes[0];
			//		m2.setArrivalTime(a);
			//		System.out.println(waitTimes[0]);
					zero2.add(m2);
		//			waitTimes[0] = 0;
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
	
	public static void main(String[] args) { 
		
		ArrayList<MessagePriorityQueue> list = new ArrayList<MessagePriorityQueue>();
		MPQTester main = new MPQTester();
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
		ArrayList<MessagePriorityQueue> list2 = main.process(list);
		for (int i = 0; i < list2.size(); i++)
			System.out.println(AVG_TIME + i + ": " + list2.get(i).averageTime() + MINUTES);
	}
	
}
