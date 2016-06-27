

import java.util.LinkedList;
import java.util.Deque;
 

public class H{
	
	@Override 
	public int hashCode(){
		return 0;
	}
	
	@Override 
	public boolean equals(Object o){
		
		return true;
	}
	
	
	public static void main(String [] args){
		
		//System.out.println(Objects.hash("    "));
		
		//Deque<Integer> queue = new LinkedList<Integer> ();
		//
		//queue.addLast(1);
		//queue.removeFirst();
		//queue.getFirst();
		
		
		Deque<String> stack = new LinkedList<String> ();
		System.out.println(stack);
		stack.addFirst("as");
		//stack.peekFirst();
		System.out.println(stack);
		stack.removeFirst();
		System.out.println(stack);
	}
}