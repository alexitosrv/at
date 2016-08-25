import java.util.Map;
import java.util.HashMap;

class H{


public static void main(String [] a){


Map<String, Integer> h = new HashMap<String, Integer>();


h.put("one", 1);
h.put("two", 2);
h.put("trois", 3);


for (Map.Entry<String, Integer> i : h.entrySet()){
	
	System.out.println(i.getKey());
	System.out.println();
	System.out.println(i.getValue());
	System.out.println();
	
}
}

}