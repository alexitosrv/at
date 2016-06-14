

public class IQ_05_8_reverse {
	
	public static void main(String [] args){
		
		System.out.println("write a number:");
		
		int n = Integer.parseInt(System.console().readLine());

		System.out.println("reversed number:\n" + reverseNumber(n));
		
	}
	
	
	public static int reverseNumber(int n){
		
		boolean isNegative = n<0;
		
		if(isNegative)
			n = -n;
		
		// lets access to the digits of n individually,
		
		// n = xyz = x*10^3 + y*10^2 + z*10^1
		// n % 10 = z
		// n' = n/10
		// n' % 10 = y
		// n' = n'/10
		// n' % 10 = x
		
		// 356
		
		// 356/1
		// n = 356
		// d = 356%10 = 6
		// m = 6
		// i = 10
		// 356/10 = 35
		// d = 5
		// m = 6*10 + 5 = 65
		// i = 100
		// 356/100 = 3 
		// d = 3
		// m = 65*10 + 3
		// i = 1000
		// 356/1000 = 0

		int i = 1;
		int m = 0;
		while( (n/i) > 0){
			
			m = (m*10)+(n/i)%10;
			
			i *= 10;
		}
		
		if (isNegative)
			return -m;
		else
			return m;
	}
	
}