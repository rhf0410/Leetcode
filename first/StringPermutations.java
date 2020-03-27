package com.example.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class StringPermutations {
	/**
	 * Return all permutations of specified string.
	 * @param str
	 * @return
	 */
	public ArrayList<String> Permutation(String str) {
	       ArrayList<String>result = new ArrayList<String>();
	       if(str == null || str.length() == 0)
	    	   return result;
	       int size = str.length();
	       char [] chs = str.toCharArray();
	       all_permutations(result, chs, 0, size);
	       //ArrayList类型转换为字符串数组类型
	       String[] array = (String[]) result.toArray(new String[0]);
	       Arrays.sort(array, new Comparator<String>(){

				public int compare(String o1, String o2) {
					String[] temp = {o1.toLowerCase(), o2.toLowerCase()};
					Arrays.sort(temp);
					
					if(o1.equalsIgnoreCase(temp[0])){
						return -1;
					}else if(temp[0].equalsIgnoreCase(temp[1])){
						return 0;
					}else{
						return 1;
					}
					
				}
				
			});
	       //字符串数组类型转换回ArrayList类型
	       ArrayList<String>lists = new ArrayList<String>(Arrays.asList(array));
	       return lists;
    }
	
	/**
	 * Find all permutations.
	 * @param result
	 * @param str
	 * @param i
	 * @param size
	 */
	private void all_permutations(ArrayList<String>result, char[] chs, int i, int size){
		if(i == size){
			String value = String.valueOf(chs);
			if(!result.contains(value))
				result.add(String.valueOf(chs));
		}else{
			for(int j=i;j<size;j++){
				swap(chs, i, j);
				all_permutations(result, chs, i + 1, size);
				swap(chs, i, j);
			}
		}
	}
	
	/**
	 * Switching characters.
	 * @param i
	 * @param j
	 */
	private void swap(char [] chs, int i, int j){
		char ch = chs[i];
		chs[i] = chs[j];
		chs[j] = ch;
	}
	
	private void reverse(char [] chs, int begin, int end){
		while(begin < end){
			swap(chs, begin, end);
			begin++;
			end--;
		}
	}
	
	public String permutation(char [] chs){
		ArrayList<String>result = new ArrayList<String>();
		char [] refs = chs;
		int base = -1;
		for(int i=chs.length - 1;i>1;i--){
			if(chs[i] > chs[i-1]){
				base = i-1;
				break;
			}
		}
		if(base == -1){
			return null;
		}
		int bigger = 0;
		for(int i=chs.length-1;i>=base;i--){
			if(chs[i] > chs[base]){
				bigger = i;
				break;
			}
		}
		swap(chs, base, bigger);
		reverse(chs, base + 1, chs.length - 1);
		return String.valueOf(chs);
	}
}
