package com.example.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class permutationSequence {
	/*public double factorial(int n){
		if(n == 0 || n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}*/
	
	/**
	 * get Permutation.
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {
		String result = new String("");
		
        return result;
    }
	
	private void getPermutations(ArrayList<Integer>list, int size, int count, ArrayList<String>results){
		if(count == size){
			String result = ArrayListToString(list);
			if(!results.contains(result))
				results.add(result);
		}else{
			for(int i=0;i<size;i++){
				Collections.swap(list, i, count);
				getPermutations(list, size, count + 1, results);
				Collections.swap(list, i, count);
			}
		}
	}
	
	private String ArrayListToString(ArrayList<Integer>list){
		String result = new String("");
		Iterator<Integer>ite = list.iterator();
		while(ite.hasNext())
			result += ite.next();
		return result;
	}
	
	private int factorial(int n){
		if(n == 0 || n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
	
	public String Solution(int n, int rank){
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>res = new ArrayList<Integer>();
		int [] fact = new int[n];
		fact[0] = 1;
		for(int i=1;i<n;i++){
			fact[i] = i * fact[i-1];
		}
		for(int i=0;i<n;i++)
			res.add(i+1);
		rank = rank - 1;
		for(int i=n;i>0;i--){
			int index = rank / fact[i-1];
			rank = rank % fact[i-1];
			sb.append(res.get(index));
			res.remove(index);
		}
		return sb.toString();
	}
}
