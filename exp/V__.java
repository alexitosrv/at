
import java.util.Arrays;
import java.util.Collections;

public class V__ {
	
	public static void main(String [] args){
//                           0   1  2  3  4
//		                             v  
//		                                    v  
//		                                v  
		//int [] a = new int[]{10,15,21, 28, 29,30,31,32,40,50};
		int [] a = new int[]{10,15};
		
		int [] b = new int[]{13,12,11,10,9,8,7,6,5,4,3,2,1,1,1,1,1,1,1,1,1};
		
		
		
		                       //        27
		int v = 14;
		int c = 2;
		
		int [] r = getNearestKValuesInSortedArray(a, v, c);
		//int [] r = merge(a,b,v,c);
		
		//reverse(b, 0, 4);
		
		pp(r);

	}
	
	public static void pp(int [] a){
		for (int i : a){
			System.out.println(i);
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
		int i=0,j=0,k=0;
		int [] r = new int [c];
		
		while(i<a.length && j<b.length && k<c){
			
			if (Math.abs(a[i]-v)<Math.abs(b[j]-v)){
				r[k++]=a[i++];
			}else{
				r[k++]=b[j++];
			}
		}
		
		if(i>=a.length){
			while (j<b.length && k<c){
				r[k++] = b[j++];
			}
		}
		
		if(j>=b.length){
			while (i<a.length && k<c){
				r[k++] = a[i++];
			}
		}
		
		return r;
		
		
	}
		
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
			
			System.out.println("idx= "+idx+" a[idx] = "+a[idx]);
			
			int [] p = Arrays.copyOfRange(a, 0, idx);
			int [] q = Arrays.copyOfRange(a, idx, a.length);
			reverse(p, 0, p.length);
			
			System.out.println("p= ");
			pp(p);
			System.out.println();
			System.out.println("q= ");
			pp(q);
			System.out.println();
			
			r = merge(p, q, v, c);
			
//              p      q
//			[0 idx) [idx+1 n-1)


   //       P_i > P_j
   //      (idx-1, idx-2, idx-3, ..., 3, 2, 1, 0]
   
   // [1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17]
   
   //           <-------
   //                  v
   // [1,2,3,4,5,6,7,8,9]
//   v=10
   
  /*    [9,8,7,6,5,4,3,2,1]
        [11,12,13,14,15,16,17]
		*/
// [9,11,8,12,13,6....

    //[10]	  
	//[15]
	//
// 15, 10
   
   //   --------->
   //   v
   // [11,12,13,14,15,16,17]
   
   

   // 		Q_i < Q_j
   //      [idx+1, idx+2, idx+3, ..., n-3, n-2, n-1]
   
   
   
		//	i idx, ...,1, 0
		//	k idx+1, ...n-1
		//	
			

			

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