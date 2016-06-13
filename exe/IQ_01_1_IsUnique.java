
import java.util.HashMap;
import java.util.Map.Entry;

public class IQ_01_1_IsUnique{
	
	public static void main(String[] args){
		
		//String s = "abcdaaa";
		String s = System.console().readLine("write a string:");
		
		System.out.println("Does this string have unique chars?");
		System.out.println(s);
		
		System.out.println("Using a hash table and with a runtime of O(N)");
		System.out.println(isUniqueUsingHashtable(s));
		
		System.out.println("Using nothing more and with a runtime of O(N^2)");
		System.out.println(isUnique(s));
	}
	
	/*
	runtime analysis:
	first we create a hashtable, ht
	then we run throuhg each character in the string, N
	the put operation has a constant time
	then we traverse the ht as soon as we get something higher than 1 we return false
	N + N * O(1) + N
	3*O(N)
	*/
	public static boolean isUniqueUsingHashtable(String s){
				
		HashMap<Character, Integer> ht = new HashMap<Character, Integer>();

		for(int i=0; i<s.length(); i++){
			Character c = s.charAt(i);
		
			if (ht.containsKey(c))
				//ht.put(c, ht.get(c)+1);
				return false;
			else
				ht.put(c, 1);
		
		}
		/*
		for(Entry<Character, Integer> entry: ht.entrySet()){

			if (entry.getValue() > 1)
				return false;
			
		}*/
		
		return true;
	}
	

	public static boolean isUnique(String s){
		int i=0;
		while(i<s.length()-1){
			Character c = s.charAt(i);
			
			if (containsChar(s, c, i+1))
				return false;
			
			i++;
		}
		
		return true;
	}
	
	/*
	idea: 
	go through each character of the string
	example
	a b c d e a
i:	^
-------

	a b c d e a
i:	          ^

N-1
N-2
...
N-k
...
3
2
1

N^2
	*/
	
	public static boolean containsChar(String s, Character c, int start){
		int i=start;
		
		while(i<s.length() && s.charAt(i) != c)
			i++;

		return i<s.length();
	}
}