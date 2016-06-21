

public class E {   
    public static int answer(int[] heights) { 

        int n = heights.length;
		int i = 0;
		int z = 0;
		int partial = 1;

		int left=0;
		int right=0;
		
		while(i<n-1){
			int d2 = heights[i]-heights[i+1];
			
			System.out.println("d2 = "+d2);

			if (d2<0){
				if (left>0){
					do{
						right=Math.abs(d2);
						z = z + Math.min(left, right)*partial;
						i++;
						partial++;
						if (i<n-1){
							d2 = heights[i]-heights[i+1];
							System.out.println("d2 = "+d2);
						}
					}while(d2<0 && i<n-1);
				}
			}

			if (d2==0){
				partial++;
			}
			
			if (d2>0){
				int j = i;
				int w = 0;
				int d3 = 0;
				do{
					if (j<n-1){
						d3 = heights[i]-heights[j+1];
						if(d3>0){
							w = w + d3;
							System.out.println("d3 = "+d3);
						}else{
							break;
						}
					}
					j++;
				}while(d3>0 && j<n-1);
				
				if (d3<0){
					z = z + w;
					i = j;
				}else{
					left = d2;
				}
				partial = 1;
			}
			
			i++;
		}
		
		return z;
    }
	
	
	public static void main(String[] args){
		
		//int[] h = new int[] {1,4,2,5,1,2,3};
		//int[] h = new int[] {1, 2, 3, 2, 1};
//		int[] h = new int[] {1,2,3,4,3,2,1,5};
		//int[] h = new int[] {2, 5, 1, 2, 3, 4, 7, 7, 6};
		//int[] h = new int[] {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
		//int[] h = new int[] {2, 7, 2, 7, 4, 7, 1, 7, 3, 7};
		int[] h = new int[] {6, 7, 7, 4, 3, 2, 1, 5, 2}; // *
		//int[] h = new int[] {2, 5, 1, 2, 3, 4, 7, 7, 6, 2, 7, 1, 2, 3, 4, 5, 5, 4}; //*
		System.out.println(answer(h));
	}
}