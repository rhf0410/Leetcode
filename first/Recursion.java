package com.example.first;

public class Recursion {
	/**
	 * Find the number of routes
	 * @param data
	 * @param i
	 * @param j
	 * @param count
	 * @param sum
	 * @return
	 */
    public int theNumberofRoutes(int [][] data, int i, int j, int count, int sum, int amount){
    	if(i>=data.length || j >= data[i].length)
    		return count;
		if(i == data.length-1){
			if(j == data[i].length-1){
				return count;
			}
			if(sum + data[i][j] == amount){
				count++;
			}
		}
		sum += data[i][j];
		count = theNumberofRoutes(data, i+1, j, count, sum, amount);
		count = theNumberofRoutes(data, i+1, j+1, count, sum, amount);
		sum -= data[i][j];
		return count;
    }
}
