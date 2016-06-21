import java.util.ArrayDeque;
import java.util.ArrayList;

public class E {   
    public static int answer(int[] heights) { 

        int n = heights.length;
		int z = -1;
		int w = 0;
		int i = 0;
		int k;
		int min;
		int d2;
		
		ArrayList<Integer> left_wall_height_candidates = new ArrayList<Integer>();
		ArrayDeque<Integer> right_wall_height_candidates = new ArrayDeque<Integer>();

		while(i<n){
		
			left_wall_height_candidates.add(heights[i]);

			right_wall_height_candidates.push(heights[i]);

			i++;

		}

		System.out.println(left_wall_height_candidates);
		System.out.println(right_wall_height_candidates);
		
		for (i=0; i<n;i++){
			System.out.println(left_wall_height_candidates.get(left_wall_height_candidates.size()-1));
			left_wall_height_candidates.remove();
			
			System.out.println(right_wall_height_candidates.pop());
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