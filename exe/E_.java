

public class E_ {   

    public static int answer(int[] heights) { 

        int n = heights.length;
		int z = 0;
		int j;
		int k;
		int left = -Integer.MIN_VALUE;
		int right = -Integer.MIN_VALUE;
		int i = 0;
		int i_lef = 0;
		int i_rig = 0;

		while(i<n){
			System.out.println("start with i= "+i);
			
			if (left < heights[i]){ 
				System.out.println("left compared with current height is shorter");
				left = heights[i];
				i_lef = i;
			}else{
				System.out.println("i = "+i+", left: "+left+" >= heights[i]="+heights[i]);
				
				j=i;
				System.out.println("  j = i= "+j);
				while(j < n && left > heights[j]){
					System.out.println("     j<n and left>heights[j], j= "+j);
					j++;
				}
				j--;

				j = (j+1<n?j+1:n-1);
				System.out.println("     j= "+j);
				System.out.println("     h[j]= "+heights[j]);

				k=j;
				System.out.println("   we found a bound to the right");
				System.out.println("   i_lef= "+i_lef);
				System.out.println("   j= "+j);
				System.out.println("   k= "+k);
				
				right = heights[j];
				i_rig = j;
				
				while(j > i_lef){
					System.out.println("        "+j+" = j>i ; go back again to find the lowest high");
					
					if (right < heights[j]){
						right = heights[j];
						i_rig = j;
					}
					
					j--;
				}
				System.out.println("     right = "+right);
				System.out.println("     i_rig= "+i_rig);
				
				int m = Math.min(left, right);
				System.out.println("     m = "+m);
				System.out.println("   j= "+j);
				
				j++;
				
				while(j<i_rig){
					System.out.println("        j<n && m>"+heights[j]);
					System.out.println("        j= "+j);
					System.out.println("        delta= "+Integer.toString(m-heights[j]));
					System.out.println("        z= "+z);
					z = z + m - heights[j];
					System.out.println("        new z= "+z);
					j ++;
				}
				
				right = -Integer.MIN_VALUE;
				left = -Integer.MIN_VALUE;
				i=i_rig;
				System.out.println("  end with i= "+i);
				continue;

			}
			i++;
		}
		return z;
    }
	
	public static void main(String[] args){
		//                   0  1  2  3  4  5  6
		//                            v
		int[] h = new int[] {1, 4, 2, 5, 1, 2, 3};
		//int[] h = new int[] {3,2,3};
		//int[] h = new int[] {1,4,2,5,1,2,3};
		//int[] h = new int[] {1, 2, 3, 2, 1};
//		int[] h = new int[] {1,2,3,4,3,2,1,5};
		//int[] h = new int[] {2, 5, 1, 2, 3, 4, 7, 7, 6};
		//int[] h = new int[] {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
		//int[] h = new int[] {2, 7, 2, 7, 4, 7, 1, 7, 3, 7};
		//int[] h = new int[] {6, 7, 7, 4, 3, 2, 1, 5, 2}; // *
		//int[] h = new int[] {2, 5, 1, 2, 3, 4, 7, 7, 6, 2, 7, 1, 2, 3, 4, 5, 5, 4}; //*
		System.out.println(answer(h));
	}
}