//package com.google.challenges; 


import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;


public class J{   


	public static void main(String [] arg){
		
		
		int [] data = new int[] {1,1,1,2,3,4,4,4,4,4,4,4};
		//int [] data = new int[] {1, 2, 2, 3, 3, 3, 4, 5, 5};
		//int n = 1;
		//int [] data = new int[] {1, 2, 3};
		//int n = 0;
		int n = 6;
		int [] result = answer(data, n);
		
		pp(result);
	}
	
public static void pp (int [] d){
	System.out.println();
	for(int i=0; i<d.length;i++)
		System.out.print(d[i]+", ");
	System.out.println();
}

    public static int[] answer(int[] data, int n) { 

        // Your code goes here.
		
		
		/*
		understanding of the algorithm:
		naive solution
		
		go through each item and determine number of repetitions 
		and finally after having known how many times each item is repeated then proceed to generate a new array removing those entries appearing n or more times 
		
		
		optimized solution
		
		the array NOT necessarily is sorted:
		 1 3 1 3 3 5 5 5 8 8 9 
		
		I can create a hash table with each entry, only 100 positions
		and then count how many times the item appears
		
		afterwards 
		1 2
		3 3
		5 3
		8 2 
		9 1
		
		with that info and n
		I can build the answer 
		
		all entries appearing less than or equal to n times have to be kept
		
		and thus removing all other entries appearing more n times
		
		the algorithm is 
		
		create the hash table
		if the entry count goes to more than n, then discard the entry
		
		finally the answer is created in a new array
		
		
		
		*/
		//int h[] = new int[100];
		HashMap <Integer, Integer> h = new HashMap<Integer, Integer>();
		
		for (int i=0; i<data.length; i++){
			if (!h.containsKey(data[i])){
				h.put(data[i], 0);
			}
			
			h.put(data[i], h.get(data[i])+1);
			//h[data[i]]++;
	
			if (h.get(data[i]) > n){
				h.put(data[i], Integer.MIN_VALUE);
			}
		}
		
		ArrayList<Integer> r = new ArrayList<Integer>();
		
		for(int i=0; i<data.length; i++){
			
			if (h.get(data[i])>0){
				r.add(data[i]);
			}
		}
		
		//pp(h);
		//System.out.println(h);
		
		int [] rr = new int [r.size()];

		for(int k=0; k<r.size(); k++){
			rr[k] = r.get(k);
		}
		
		
		return rr;
    } 
}