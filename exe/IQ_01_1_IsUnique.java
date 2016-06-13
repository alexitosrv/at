
import java.util.HashMap;
import java.util.Map.Entry;

public class IQ_01_1_IsUnique{
	
	public static void main(String[] args){
		
		//String s = "abcdaaa";
		String s = System.console().readLine("write:");
		
		System.out.println("Does this string have unique chars?");
		System.out.println(s);
		System.out.println(IsUniqueUsingHashtable(s));
	}
	
	public static boolean IsUniqueUsingHashtable(String s){
				
		HashMap<Character, Integer> ht = new HashMap<Character, Integer>();

		for(int i=0; i<s.length(); i++){
			Character c = s.charAt(i);
		
			if (!ht.containsKey(c))
				ht.put(c, 1);
			else
				ht.put(c, ht.get(c)+1);
		
		}
		
		for(Entry<Character, Integer> entry: ht.entrySet()){

			if (entry.getValue() > 1)
				return false;
			
		}
		
		return true;
	}
	
	
}