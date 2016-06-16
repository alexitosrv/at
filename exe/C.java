import java.util.Arrays;

public class C {
	
	public static void infectAndHunt(int[][] population, int i, int j, int strength){

		int rows = population.length;
		int columns = population[0].length;

		if ( i-1 >= 0 ){
			int r = population[i-1][j];
			if (r != -1 && r <= strength){
				population[i-1][j] = -1;
				infectAndHunt(population, i-1, j, strength);
			}
		}
		
		if ( j-1 >= 0 ){
			int r = population[i][j-1];
			if (r != -1 && r <= strength){
				population[i][j-1] = -1;
				infectAndHunt(population, i, j-1, strength);
			}
		}
		
		if ( j+1 < columns ){
			int r = population[i][j+1];
			if (r != -1 && r <= strength){
				population[i][j+1] = -1;
				infectAndHunt(population, i, j+1, strength);
			}
		}
		if ( i+1 < rows ){
			int r = population[i+1][j];
			if (r != -1 && r <= strength){
				population[i+1][j] = -1;
				infectAndHunt(population, i+1, j, strength);
			}
		}
		
	}

	public static int[][] answer(int[][] population, int x, int y, int strength){

		if ( 0 <= population[y][x] && population[y][x] <= strength ){
			population[y][x] = -1;
		}

		infectAndHunt(population, y, x, strength);

		return population;

	}
	
	public static void printRabbits(int [][] population){
		
		for (int [] i : population){
			for (int j : i ){
				System.out.print(j+" ");
			}
			System.out.println();
		}		
	}
	
	
	public static void main(String []a){
		//int [][] population = {{1,2}, {3,4}};
		//int [][] population = {{1, 2, 3}, {2, 3, 4}, {3, 2, 1}};
		//int y = 0;
		//int x = 0;
		//int strength = 2;
		
		int [][] population = {{6, 7, 2, 7, 6}, {6, 3, 1, 4, 7}, {0, 2, 4, 1, 10}, {8, 1, 1, 4, 9}, {8, 7, 4, 9, 5}};
		int x = 2; 
		int y = 1;
		int strength = 5;
		
		printRabbits(population);
		System.out.println();
		System.out.println();
		
		answer(population,y,x,strength);
		
		System.out.println();
		System.out.println();
		printRabbits(population);
		
	}
		
}