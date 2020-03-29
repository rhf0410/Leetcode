package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheness {
	/**
	 * Find different ways to add parentheses
	 * @param input
	 * @return
	 */
	public List<Integer> diffWaysToCompute(String input) {
        return differ(input, 0, input.length()-1, new List[input.length()][input.length()]);
    }
	
	public List<Integer> differ(String input, int begin, int end, List<Integer> list[][]){
		List<Integer>result = new ArrayList<Integer>();
		if(list[begin][end] != null)
			return list[begin][end];
		for(int i=begin;i<=end;i++){
			char c = input.charAt(i);
			if(!Character.isDigit(c)){
				List<Integer>list1 = differ(input, begin, i-1, list);
				List<Integer>list2 = differ(input, i+1, end, list);
				for(int num1 : list1){
					for(int num2: list2){
						result.add(c == '+' ? num1 + num2 : (c == '-' ? num1 - num2 : num1*num2));
					}
				}
			}
		}
		if(result.size() == 0){
			result.add(Integer.valueOf(input.substring(begin, end + 1)));
		}
		list[begin][end] = result;
		return result;
	}
}
