package com.example.first;

public class KMP {
	public boolean kmpMatch(String pattern, String str){
		int i = 0;
		int j = 0;
		int [] next = new int [pattern.length()];
		getNext(pattern, next);
		while(i < pattern.length() && j < str.length()){
			if(pattern.charAt(i) == pattern.charAt(j)){
				i++;
				j++;
			}else{
				if(next[i] == -1){
					j++;
					i = 0;
				}else{
					i = next[i];
				}
			}
			if(i == pattern.length())
				return true;
		}
		return false;
	}
	
	private void getNext(String pattern, int [] next){
		int i = 0;
		int k = -1;
		next[0] = -1;
		while(i < pattern.length() - 1){
			if(k == -1 || pattern.charAt(i) == pattern.charAt(k)){
				i++;
				k++;
				next[i] = k;
			}else{
				k = next[k];
			}
		}
	}
}
