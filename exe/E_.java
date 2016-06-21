

public class E {   
    public static int answer(int[] heights) { 

        int n = heights.length;
		int z = 0;
		int i = 0;
		int j;
		int k;
		int min;
		int d2;
		
		while(i<n-1){
			j = i+1;
			d2 = heights[i]-heights[j];
			
			System.out.println("d2 = "+d2);
			
			if (d2 < 0){
				// we must keep the trend otherwise we stop
				while (j<n-1 && d2<=0){
					d2 = heights[j]-heights[j+1];
					System.out.println("d2 = "+d2);
					j++;
				}
				
				if (j<n){
					if (d2>0){
						// backtrack j all the way towards i,
						// and calculate the min betweek h[k] and h[j] to determine the height of the water
						min = Math.min(heights[i],heights[j]);
						System.out.println("i "+i);
						System.out.println("j "+j);
						System.out.println("heights[i] "+heights[i]);
						System.out.println("heights[j] "+heights[j]);
						System.out.println("min es "+min);
						k = j;
						while(k>i){ //  && min>=heights[k]
							System.out.println("entramos al otro ciclo");
							z += min-heights[k];
							k--;
						}
					}
				}
			}
			
			if (d2 > 0){
				System.out.println("we must keep the trend otherwise we stop");
				while (j<n-1 && d2>=0){
					d2 = heights[j]-heights[j+1];
					System.out.println("d2= "+d2);
					j++;
				}

				System.out.println(" changed at j = "+j);
				// it means we changed trend
				if (j<n){
						// backtrack j all the way towards i
						// and calculate the min betweek h[k] and h[j] to determine the height of the water
						min = Math.min(heights[i],heights[j]);
						System.out.println("i "+i);
						System.out.println("j "+j);
						System.out.println("heights[i] "+heights[i]);
						System.out.println("heights[j] "+heights[j]);
						System.out.println("min es "+min);							
						k = j;
						while(k>i){
							System.out.println("min - h[k]"+Integer.toString(min-heights[k]));
							z += min-heights[k];
							k--;
						}
					}
					else{ // it means d2 < 0
						
					}
			}
			
			if (d2 == 0){
			}
			
			i = j;
		}
		return z;
		
    }
	
	
	public static void main(String[] args){
		
		int[] h = new int[] {6,1,1,2,3};
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