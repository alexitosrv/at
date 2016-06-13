#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int contains_char(char *, int, char, int);
int is_unique_chars(char *, int);
int is_unique_chars2(char *, int);


int main(){
	
	char * s; 
	size_t ssize = 100;
	size_t num_of_chars;
	
	s = (char *)malloc(ssize * sizeof(char));
	
	if(s == NULL){
		perror("buy more memory!");
		exit(1);
	}
	
	printf("write a string:");
	scanf("%s", s);
	int n = strlen(s);
	
	printf("Does this string have unique chars?:\n'%s' (%d)\n", s, n);
	int r = is_unique_chars(s, n);
	int r2 = is_unique_chars2(s, n);
	printf("%s", r?"true":"false");
	printf("\nUsing the idea of a boolean array with a runtime of O(256)\n");
	printf("%s", r?"true":"false");
	
	free(s);
	
	return 0;	
}

int is_unique_chars(char * s, int n){
	

	int i=0;
	
	while(i<n-1){
		if(contains_char(s, n, s[i], i+1))
			return 0;
		i++;
	}
	
	return 1;
	
}

int is_unique_chars2(char *s, int n){
	int * f;
	size_t fsize = 256;
	f = (int *)malloc(fsize * sizeof(int));
	
	memset(f, 0, sizeof f);
	
	for(int i=0; i<n; i++){
		f[s[i]]++;
		if (f[s[i]]>1)
			return 0;
	}
	
	free (f);
	return 1;
	
}


int contains_char(char *s , int n, char c, int start){
	int i=start;
	
	while(i<n && s[i] != c)
		i++;
	
	return i<n;
}
