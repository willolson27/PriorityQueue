import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MessagePriorityQueue {

	private static Queue<Message> mainQ;
	
	public MessagePriorityQueue() {
		mainQ = new LinkedList<Message>();
	}
	
	public static double averageTime(MessagePriorityQueue mpq) {
		int sum = 0;
		double avg;
		Queue<Message> q = mpq.mainQ;
		for (Message m : q) {
			sum += m.getArrival();
		}
		avg = sum / q.size();
		return avg;
	}
	
	public static void process(ArrayList<MessagePriorityQueue> arr) {
		int[] waitTimes = {0, 0, 0, 0, 0};
		for (int i = 0; i < 100; i++) {
			int r = (int)(Math.random() * 4);
			if (i < 20) {
				Message m = new Message(r);
				arr.get(r).add(m);
				waitTimes[r] ++;
			}
			if (i % 4 == 0) {
				if (!arr.get(0).isEmpty()) {
					Message m2 = arr.get(0).remove();
					m2.setArrivalTime(waitTimes[0]);
				}
				else if (!arr.get(1).isEmpty()) {
					Message m2 = arr.get(1).remove();
					m2.setArrivalTime(waitTimes[1]);
				}
				else if (!arr.get(2).isEmpty()) {
					Message m2 = arr.get(2).remove();
					m2.setArrivalTime(waitTimes[2]);
				}
				else if (!arr.get(3).isEmpty()) {
					Message m2 = arr.get(3).remove();
					m2.setArrivalTime(waitTimes[3]);
				}
				else {
					Message m2 = arr.get(4).remove();
					m2.setArrivalTime(waitTimes[4]);
				}
			}
		}
	}
	
	private boolean isEmpty() {
		return mainQ.isEmpty();
	}

	public void add(Message m) {
		mainQ.add(m);
	}
	
	public Message remove() {
		if (!mainQ.isEmpty())
			return mainQ.remove();
		else
			return null;
	}
	
	public static void main(String[] args) { 
		
		ArrayList<MessagePriorityQueue> list = new ArrayList<MessagePriorityQueue>();
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
		MessagePriorityQueue.process(list);
		System.out.println(averageTime(zero));
		System.out.println(averageTime(one));
		System.out.println(averageTime(two));
		System.out.println(averageTime(three));
		System.out.println(averageTime(four));
	}
}
