
import java.util.ArrayList;

public class D {
	
    public static String answer(String chunk, String word) { 

        ArrayList<String> candidates = new ArrayList<String>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		int n = chunk.length();
		int m = word.length();
		
		// the chunk is traversed finding substrings equals to word
		// starting at each character and saved into positions arraylist
		for (int i=0; i<n; i++){
			int p = chunk.indexOf(word,i);
			if (!positions.contains(p) && p>-1)
				positions.add(p);
		}
		
		int k = positions.size();

// l  o  l  o  l
// 0  1  2  3  4
//          ^
// l o l o l
//   *   o l  <- here the first lol was removed
// l o   *    <- here the other was removed too
// after those removals I can consider that I can remove any other lol in each one until there is no more
// this allows for 
// my big problem was that I tried at first to do the opposite, that is to remove each other but the current one
// those approaches are equivalent but this one is much more easier to implement 

// positions where w was found in c:
// 0  2 
// 0  1
//     ^ 

/*



*/
//  ^
  
  
/* |
 c | i \ j [k]
 -----------------
 l | 0   0 [0 1] 1 [0 1]
 o | 1 
 l | 2 
 o | 3 
 l | 4 
*/  
		candidates.add(chunk);
		
		for (int i=0; i<n; i++){ // iterate over chunk
			for (int j=0; j<k; j++){ 
					// if the character is at one of the positions where the word was found 
					// then create a candidate where that substring is removed 
					// (later I will remove any other repetition of words found there):
					if (i == positions.get(j)){
						// omit the characters i to i+m because there it's the substring
						String s1 = new String(chunk.subSequence(0, i).toString());
						//System.out.println("removed:"+chunk.subSequence(i, i+m));
						//System.out.println("i="+i);
						String s2 = new String(chunk.subSequence(i+m, n).toString());
						String s3 = new String(s1.toString()+s2.toString());
						//System.out.println("s1+s2= "+s1+"] ["+s2);
						//System.out.println("s3= "+s3);
						
						if (!candidates.contains(s3))
							candidates.add(s3);
					}
			}			
		}
	
		//System.out.println("candidates");
		//System.out.println(candidates);
		
		// now we will remove all substrings word in each candidate:
		// as I already remove one substring in each candidate
		// the alignment for each candidate allows to have all the different combinations
		int i = 0;
		while (i<candidates.size()){
			String s = new String(candidates.get(i));
			do {
				s = s.replaceAll(word, "");
			} while (s.indexOf(word) > -1);
			candidates.set(i, s);
			i++;
		}

		//System.out.println("candidates");
		//System.out.println(candidates);
		
		int shortest_candidate = 21;
		String earliest_candidate = new String(candidates.get(0));
		
		while (candidates.size()>0){
			String c = candidates.remove(0);
			if (c.length()<shortest_candidate){
				shortest_candidate = c.length();
				earliest_candidate = new String(c);
			}
			else if (c.length() == shortest_candidate){
				if (c.compareTo(earliest_candidate) < 0){
					earliest_candidate = new String(c);
				}
			}
		}
		
		//System.out.println("earliest_candidate");
		//System.out.println(earliest_candidate);
		//System.out.println("shortest_candidate");
		//System.out.println(shortest_candidate);
		
		return earliest_candidate;
    } 
	
	
	public static void main(String [] args){
		
		System.out.println(answer("lololololo", "lol"));
		System.out.println(answer("goodgooogoogfogoood", "goo"));
		System.out.println(answer("lololo", "lol"));
		System.out.println(answer("aaabbb", "ab"));
		System.out.println(answer("lololololol", "lol"));
		
	}
}