
import java.util.Arrays;
import java.util.Collections;

public class V____ {
	
	public static void main(String [] args){
//                           0   1  2  3  4
//		                             v  
//		                                    v  
//		                                v  
		int [] A = new int[]{10,15,21, 28, 29,30,31,38,40,50};
//		int [] a = new int[]{3,9,11,17,19};
		//int [] a = new int[]{10,15};
		
		int [] b = new int[]{13,12,11,10,9,8,7,6,5,4,3,2,1,1,1,1,1,1,1,1,1};
		
		
		
		                       //        27
		int V = 12;
		int C = 3;

		int [] r = getNearestKValuesInSortedArray(A, V, C);
		//int [] r = merge(a,b,v,c);
		
		//reverse(b, 0, 4);
		
		System.out.println("");
		System.out.println("r queda: ");
		pp(r);

	}
	
	public static void pp(int [] a){
		for (int i : a){
			System.out.println(i);
		}
	}
	
	public static void ppp(int [] a, int i, int j, boolean reverse){
		if (!reverse)
			for (int k=i; k<j; k++){
				System.out.println(a[k]);
			}
		else
			for (int k=j-1; k>=0; k--){
				System.out.println(a[k]);
			}
	}
	
	
	public static void reverse(int [] a, int f, int t){
		for (int i=f; i<t/2; i++){
			int w = a[i];
			a[i] = a[t-1-i];
			a[t-1-i] = w;
		}
		
	}
	
	public static int [] merge(int [] a, int [] b, int v, int c){
		int i=a.length-1,j=0,k=0;
		int [] r = new int [c];
		
		while(i>=0 && j<b.length && k<c){
			if (Math.abs(a[i]-v)<Math.abs(b[j]-v)){
				r[k++]=a[i--];
			}else{
				r[k++]=b[j++];
			}
		}
		
		if(i<0 && k<c){
			while (j<b.length && k<c){
				r[k++] = b[j++];
			}
		}
		
		if(j>=b.length && k<c){
			while (i>=0 && k<c){
				r[k++] = a[i--];
			}
		}
		
		return r;
	}
	
	            //                                A              B
												
	public static void combineOrderedSubArraysIntoR(int [] A, int aF, int aT, int bF, int bT, int V, int C, int[] R){
		int i=aT-1, j=bF, k=0; // A is subdivided in [aF, aT) and [bF, bt) 
		// as A is sorted, the first subarray will be traversed in reverse
	
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
	
	public static int refineStartingIndex(int idx, int[] a, int v){
		if (idx < 0){
			idx = -idx - 1;
			idx = idx<a.length ? idx : a.length-1;
			if (idx-1>0 && Math.abs(a[idx-1]-v) < Math.abs(a[idx]-v))
				idx = idx-1;
		}
		return idx;
	}
		
	public static int [] getNearestKValuesInSortedArray(int[] A, int V, int C){
		int j = 0;
		int[] R = new int[C];
		
		if (A[0]<V && V<A[A.length-1]){
			
			int idx = Arrays.binarySearch(A, V);

			idx = refineStartingIndex(idx, A, V);
			
			System.out.println("starting idx = " + idx);
			
			int [] p = Arrays.copyOfRange(A, 0, idx);
			
			int [] q = Arrays.copyOfRange(A, idx, A.length);
						
			reverse(p, 0, p.length);
			System.out.println("");
			System.out.println("p= ");
			pp(p);
			
			System.out.println("");
			System.out.println("");
			System.out.println("p desde a = ");
			ppp(A, 0, idx, true);

			System.out.println("");
			System.out.println("q= ");
			pp(q);
			
			System.out.println("");
			System.out.println("q desde a = ");
			ppp(A, idx, A.length,false);
			
			
			combineOrderedSubArraysIntoR(A, 0, idx, idx, A.length, V, C, R);
			
		}else
			if (V<=A[0])
				for (j=0; j<C; j++)
					R[j] = A[j];
			else 
				for (j=0; j<C; j++)
					R[j] = A[A.length-1-j];
			

		return R;

	}
	
	
}