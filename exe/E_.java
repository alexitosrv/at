

public class E_ {   

    public static int answer(int[] heights) { 
        int n = heights.length;
		int j;
		int z = 0;
		int left = -Integer.MIN_VALUE;
		int right = -Integer.MIN_VALUE;
		int i_lef = 0;
		int i_rig = 0;

		int i = 0;
		while(i < n){
		
			if (left < heights[i]){ 
				left = heights[i];
				i_lef = i;
			}else{
				j = i;
				while(j < n && left > heights[j]){
					j++;
				}
				j--;

				j = (j+1<n?j+1:n-1);

				right = heights[j];
				i_rig = j;
				
				while(j > i_lef){
					if (right < heights[j]){
						right = heights[j];
						i_rig = j;
					}
					
					j--;
				}
				j++;
				
				int m = Math.min(left, right);
				
				while(j < i_rig){
					System.out.println("        delta= "+Integer.toString(m-heights[j]));
					System.out.println("        z= "+z);
					z = z + m - heights[j];
					System.out.println("\n        new z= "+z);
					j ++;
				}
				
				left = -Integer.MIN_VALUE;
				i = i_rig;
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
		//int[] h = new int[] {1,4,2,2,3,5};
		//int[] h = new int[] {1,4,2,5,1,2,3};
		//int[] h = new int[] {1, 2, 3, 2, 1};
//		int[] h = new int[] {1,2,3,4,3,2,1,5};
		//int[] h = new int[] {2, 5, 1, 2, 3, 4, 7, 7, 6};
		//int[] h = new int[] {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
		//int[] h = new int[] {2, 7, 2, 7, 4, 7, 1, 7, 3, 7};
		//int[] h = new int[] {6, 7, 7, 4, 3, 2, 1, 5, 2}; // *
		//int[] h = new int[] {2, 5, 1, 2, 3, 4, 7, 7, 6, 2, 7, 1, 2, 3, 4, 5, 5, 4}; 
		System.out.println(answer(h));
	}
}