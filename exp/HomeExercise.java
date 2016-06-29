
import java.util.Arrays;

public class HomeExercise{
	
	public static void main(String [] args){
		int [] A = new int[]{3,9,11,17,19};
		int V = 12;
		int C = 3;
		
		System.out.println("Input array A = ");
		pp(A);
		System.out.println(String.format("V = %1$d, C = %1$d",V, C));
		
		int [] R = getNearestValues(A, V, C);
		
		System.out.println("Result =");
		pp(R);
	}
	
	public static void combineOrderedSubArrays(int [] A, int aF, int aT, int bF, int bT, int V, int C, int[] R){
		// A is combined from subarrays A[aF, aT) and A[bF, bt)
		// actually, aT = bF = idx, but the function is clearer when explicit
		// given A is sorted, the first subarray will be traversed in reverse:
	
		int i=aT-1, j=bF, k=0;
		while(i>=aF && j<bT && k<C){
			if (V-A[i] < A[j]-V)
				R[k++] = A[i--];
			else
				R[k++] = A[j++];
		}
		
		if(i<aF && k<C){
			while (j<bT && k<C)
				R[k++] = A[j++];
		}
		
		if(j>=bT && k<C){
			while (i>=aF && k<C)
				R[k++] = A[i--];
		}
	}	
	
	public static int refineIndex(int idx, int[] A, int V){
		// the goal is to get an index actually closest to V
		// based on the estimated position by binarySearch:
		if (idx < 0){ 
			idx = -idx - 1;
			idx = idx<A.length ? idx : A.length-1;
			if (idx-1>0 && V-A[idx-1] < A[idx]-V)
				idx--;
		}
		return idx;
	}
		
	public static int [] getNearestValues(int[] A, int V, int C){
		int j = 0;
		int[] R = new int[C];
		
		if (A[0]<V && V<A[A.length-1]){
			
			int b = Arrays.binarySearch(A, V);
			int idx = refineIndex(b, A, V);
			combineOrderedSubArrays(A, 0, idx, idx, A.length, V, C, R);
			
		}else
			if (V<=A[0])
				for (j=0; j<C; j++)
					R[j] = A[j];
			else 
				for (j=0; j<C; j++)
					R[j] = A[A.length-1-j];
			
		return R;
	}

	public static void pp(int [] a){
		for (int i : a){
			System.out.print(i+", ");
		}
		System.out.println();
		
	}

}