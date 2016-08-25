import java.util.List;
import java.util.ArrayList;

public class MaxSubArray{

	public static int findMaxSubArray(List<Integer> A){
		int minSum=0, sum=0, maxSum=0;
		
		for (int i=0; i<A.size(); i++){
			sum += A.get(i);
			if (sum < minSum){
				minSum = sum;
			}
			if (sum - minSum > maxSum){
				maxSum = sum - minSum;
			}
				
		}
		
		return maxSum;
	}

	public static void main(String [] args){
	
		List<Integer> a = new ArrayList<Integer>();
		a.add(904);
		a.add(-40);
		a.add(523);
		a.add(12);
		a.add(-335);
		a.add(-385);
		a.add(-124);
		a.add(4481);
		a.add(-31);
		
		System.out.println(findMaxSubArray(a));
	
	}
}