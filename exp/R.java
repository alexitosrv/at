import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class R{
	
	public static void main(String []args){
		
		List<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		
		System.out.println(l);
		Collections.rotate(l,-1);
		System.out.println(l);
		Collections.addAll(l, 4,5);
		System.out.println(l);
	}
	
}