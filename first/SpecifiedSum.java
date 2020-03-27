package com.example.first;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecifiedSum {
	/**
	 * Find arrays whose sum is specified sum.
	 * @param arrays
	 * @param sum
	 * @return
	 */
	public ArrayList<String>solution(int [] arrays, int sum){
		ArrayList<String>results = new ArrayList<String>();
		ArrayList<Integer>result = new ArrayList<Integer>();
		Arrays.sort(arrays);
		recursive(arrays, sum, 0, 0, results, result);
		return results;
	}
	
	/**
	 * Recursion to find sub-arrays meeting the requirement.
	 * @param arrays
	 * @param sum
	 * @param nsum
	 * @param k
	 * @param results
	 * @param result
	 */
	private void recursive(int [] arrays, int sum, int nsum, int k, ArrayList<String>results, ArrayList<Integer>result){
		for(int i=k;i<arrays.length;i++){
			nsum += arrays[i];
			if(nsum == sum){
				result.add(arrays[i]);
				String str = String.valueOf(result);
				results.add(str);
				nsum -= arrays[i];
				result.remove(result.size() - 1);
				return;
			}else if(nsum < sum){
				result.add(arrays[i]);
				recursive(arrays, sum, nsum, i+1, results, result);
				nsum -= arrays[i];
				result.remove(result.size() - 1);
			}else{
				return;
			}
		}
	}
}
