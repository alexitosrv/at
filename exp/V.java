import java.util.Arrays;

public class V{
	
	public static void main(String [] args){
//                           0 1  2  3  4
//		                             v  
		int [] A = new int[]{16,19,111,117,119};
		int V = 12;
		int C = 3;
		int n = A.length;

		if (A[0]<V){
		
			int insertionPoint = Arrays.binarySearch(A, V);
			int startingPoint;

			if (insertionPoint < 0){
				
				insertionPoint = -insertionPoint - 1;
				
				if (Math.abs(A[insertionPoint-1]-V) < Math.abs(A[insertionPoint]-V))
					startingPoint = insertionPoint-1;
				else
					startingPoint = insertionPoint;
			}else
				startingPoint = insertionPoint;
			
			//System.out.println(startingPoint);
			
			if (C%2 == 1){
				System.out.println(A[startingPoint]);
			}
			
/*

[0, insertionPoint) [insertionPoint, n)

C=9

[i-4=0] 7     ,22 [i+4=8]
[i-3=1] 8,    ,21 [i+3=7]
[i-2=2] 9,    ,20 [i+2=6]
[i-1=3] 10,   ,19 [i+1=5]
           13    
           ^	
		   4

C=10
[i-5=0] 7     ,22 [i+5=9]
[i-4=1] 8,    ,21 [i+4=8]
[i-3=2] 9,    ,20 [i+3=7]
[i-2=3] 10,   ,19 [i+2=6]
[i-1=4] 13,   ,18 [i+1=5]
               ^     
       4     5		   
*/
			//System.out.println(A[insertionPoint]);
			
			int k = 1;
			while (k<=C/2 && startingPoint-k>=0 && startingPoint+k<n){
				if (Math.abs(A[startingPoint-k]-V) < Math.abs(A[startingPoint+k]-V)){
					System.out.println(A[startingPoint-k]);
					System.out.println(A[startingPoint+k]);
				}else{
					System.out.println(A[startingPoint+k]);
					System.out.println(A[startingPoint-k]);
				}
				
				k++;
			}
				
			
				
		}else{
			// return the first C elements in A
			for (int i=0; i<C; i++){
				System.out.println(A[i]);
			}
			
		}
		
	}
	

		
		
		
	
	
}