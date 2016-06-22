

public class E_ {   

    public static int answer(int[] heights) { 

        int n = heights.length;
		int z = 0;
		int j;
		int k;
		int left = -Integer.MIN_VALUE;
		int right = -Integer.MIN_VALUE;
		int i = 0;

		while(i<n){
			System.out.println("i= "+i);
			
			if (left < heights[i]){ 
				System.out.println("this means left compared with current height is shorter");
				left = heights[i];
			}else{
				System.out.println("left is greater or equal than heights[i] = "+left);
				
				j=i;
				System.out.println("  j= "+j);
				while(j < n && left > heights[j]){
					System.out.println("     j<n and left>heights[j], j= "+j);
					j++;
				}
				System.out.println("     j= "+j);
				
				//j--;
				k=j;
				if (j<n){
					System.out.println("     j<n means there is more data");
					System.out.println("     i= "+i);
					System.out.println("     j= "+j);
					System.out.println("     k= "+k);
					while(j > i){
						System.out.println("     j>i means there I can go back again");
					
						if (right < heights[j]){
							right = heights[j];
						}

						j--;
					}
					System.out.println("     right = "+right);
					
					int m = Math.min(left, right);
					while(j<n && m > heights[j]){
						System.out.println("     j= "+j);
						System.out.println("     delta= "+Integer.toString(m-heights[j]));
						System.out.println("     z= "+z);
						z = z + m - heights[j];
						System.out.println("     new z= "+z);
						j ++;
					}
					
					right = -Integer.MIN_VALUE;
					left = -Integer.MIN_VALUE;
					i=k;
				}
				else{
					System.out.println("   j>=n ");
				}
				System.out.println("  i= "+i);
				
			}
			i++;
		}
		return z;
		
    }
	
	
	public static void main(String[] args){
		
		int[] h = new int[] {3,2,3};
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