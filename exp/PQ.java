

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

class PQ{
	
	public static void main(String[] a){
		
		PriorityQueue <Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		PriorityQueue <Integer> pq2 = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		
		PriorityQueue <Integer> pq3 = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b){
				return Integer.compare(a, b);
			}
		});
		
		
		pq.add(1);
		pq.add(11);
		pq.add(111);
		
		System.out.println(pq.peek());
		
		pq3.add(1);
		pq3.add(11);
		pq3.add(111);
		
		System.out.println(pq3);
		System.out.println(pq3.peek());
		
		
		
	}
	
}