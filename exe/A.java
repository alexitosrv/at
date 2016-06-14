//https://www.google.com/foobar/?eid=v3JfV8axAYXLeJKnsbAJ&usg=AG3vBD3CSB0Wcw3BF4AysPMtWWlr28jsHA

//https://foobar.withgoogle.com/login/in-game/

public class A{
	
	public static void main(String[] arg){
		
		//int [] numbers = {1,3,0,1};
		
				int [] loop = new int[5000];
				
				System.out.println(loop[4999]);
		int [] numbers = {1,2,1};
		
		System.out.println(answer(numbers));
		
	}
	
	
	public static int answer(int [] numbers){
		int [] loop = new int[5000];
		for (int i=0; i<5000; loop[i++] = -1);
		
		int k;
		int j = 0;
		int p = 0;
		
		do{
			// numbers[p] in loop[0:j]
			k = isAlreadyThere(loop, j, numbers[p]);
			
			if (k>=0){
				// loop detected entre j y k = j-k
				break;
			}else{
				// sigo metiendo a loop
				// follow the sequence:
				loop[j++] = numbers[p];
				p = numbers[p];
			}
		}while(k<0);

		return j-k;
	}
	
	public static int isAlreadyThere(int [] a, int j, int x){
		while(j>=0){
			if (a[j] == x)
				return j;
			j--;	
		}
		return j;
	}
	
}