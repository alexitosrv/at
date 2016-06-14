

#include<stdlib.h>
#include<stdio.h>

int reverse_number(int n){
	int i = 1;
	int m = 0;
	int is_neg = n<0;
	
	if(is_neg)
		n = -n;
	
	while( (n/i) > 0){
		
		m = (m*10)+(n/i)%10;
		
		i *= 10;
	}	
	
	if(is_neg)
		return -m;
	else
		return m;
}

int main(){
	int n;
	printf("write a number:");
	scanf("%d", &n);
	printf("reversed number:\n%d", reverse_number(n));
	
	return 0;

}