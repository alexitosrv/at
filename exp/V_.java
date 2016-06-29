import java.util.Arrays;

public class V_ {
	
	public static void main(String [] args){
//                           0   1  2  3  4
//		                             v  
//		                                    v  
//		                                v  
		//int [] a = new int[]{10,15,21, 28, 29,30,31,32,40,50};
		int [] a = new int[]{10,15};
		
		                       //        27
		int v = 14;
		int c = 2;
		
		int [] r = getNearestKValuesInSortedArray(a, v, c);
		
		for (int i : r){
			System.out.println(i);
		}
	}

	// c <= n
		
	public static int [] getNearestKValuesInSortedArray(int[] a, int v, int c){
		int[] r = new int[c];
		int j = 0;
		
		int n = a.length;
		
		if (a[0]<v && v<a[n-1]){
			
			int idx = Arrays.binarySearch(a, v);

			if (idx < 0){
				idx = -idx - 1;
				idx = idx<n ? idx : n-1;
				if (idx-1>0 && Math.abs(a[idx-1]-v) < Math.abs(a[idx]-v))
					idx = idx-1;
			}

			if (c%2 == 1){
				r[j++] = a[idx]; 
				c--;
			}
			
//              p      q
//			[0 idx) [idx+1 n-1)


   //       P_i > P_j
   //      (idx-1, idx-2, idx-3, ..., 3, 2, 1, 0]
   
   // [1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17]
   
   //           <-------
   //                  v
   // [1,2,3,4,5,6,7,8,9]
   v=10
   
      [9,8,7,6,5,4,3,2,1]
      [11,12,13,14,15,16,17]
// [9,11,8,12,13,6....

    [10]	  
	[15]
	
// 15, 10
   
   //   --------->
   //   v
   // [11,12,13,14,15,16,17]
   
   

   // 		Q_i < Q_j
   //      [idx+1, idx+2, idx+3, ..., n-3, n-2, n-1]
   
   
   
			i idx, ...,1, 0
			k idx+1, ...n-1
			
			

			

		}else
			if (v<=a[0])
				for (j=0; j<c; j++)
					r[j] = a[j];
			else 
				for (j=0; j<c; j++)
					r[j] = a[n-1-j];
			

		return r;
		
	}
	
	
}